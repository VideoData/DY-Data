package com.lida.dy.cal.f500tomysql;

import com.alibaba.fastjson.JSONObject;
import com.lida.dy.cal.dao.*;
import com.lida.dy.cal.entity.*;
import com.lida.dy.cal.tool.DataDealUtils;
import com.lida.entity.FTalentUserInfoEntity;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 500达人入库
 *
 * @Auther: lida
 * @Description:
 * @Date 2020/2/6 0006 14:25
 * @Version: 1.0
 */
@Component
public class ToMysql {
    @Autowired
    TalentUserRepository talentUserRepository;
    @Autowired
    FansUserInfoRepositiory fansUserInfoRepositiory;
    @Autowired
    TalentFansUnionRepository talentFansUnionRepository;
    @Autowired
    TalentTypeRepository talentTypeRepository;
    @Autowired
    TalentTypeUnioRepository talentTypeUnioRepository;
    List<String> nicknames = new ArrayList<String>();


    public void main() throws IOException {
        System.out.println("========start=======");
        String path = "E:\\桌面\\dy\\数据\\500达人\\500达人信息.csv";
        List<FTalentUserInfoEntity> user = DataDealUtils.getUser(path);
        user =  filter(user);
        System.out.println("达人总计数量:" + user.size());
        String[] pathFile = getPathFile("E:\\桌面\\dy\\数据\\500达人\\500达人粉丝列表");
        getdata();
        System.out.println("暫存达人数量：" + nicknames.size());
        int num = 0;
        for (FTalentUserInfoEntity fTalentUserInfoEntity : user) {
            String nickName = fTalentUserInfoEntity.getNickName();
            if(nickName.contains("暖男张教练")){
                continue;
            }
            if (!nicknames.contains(nickName)) {
                for (String name : pathFile) {
                    if (name.contains(nickName)) {
                        try {
                            String s = name.split(nickName)[0];
                            List<FansUserInfoEntity> fansList = getFansList(fTalentUserInfoEntity, s.replace("-", ""));
                            if (fansList != null) {
                                save(fTalentUserInfoEntity, fansList);
                            }
                            adddata(nickName, null);
                            num++;
                        } catch (Exception e) {
                            e.printStackTrace();
                            adddata(nickName, "E:\\桌面\\dy\\tempNicknamerEror.txt");
                        } finally {
                            System.out.println("num:" + num);
                        }
                        break;
                    }
                }
            } else {
                System.out.println("--");
            }
        }
    }

    public List<FTalentUserInfoEntity> filter(List<FTalentUserInfoEntity> users) {
        List<FTalentUserInfoEntity> result = new ArrayList<>();
        for (FTalentUserInfoEntity fTalentUserInfoEntity : users) {
            TalentUserInfoEntity user = talentUserRepository.findByUniqueId(fTalentUserInfoEntity.getUniqueId());
            if (user == null) {
                try {
                    user = talentUserRepository.findAllByNickName(fTalentUserInfoEntity.getNickName()).get(0);
                } catch (Exception e) {
//                        e.printStackTrace();
                    System.out.println("无达人：" + fTalentUserInfoEntity.getNickName());
                    continue;
                } finally {
                    if (user == null) {
                        System.out.println("无达人：" + fTalentUserInfoEntity.getNickName());
                        continue;
                    }
                }
            }
            List<TalentFansUnionEntity> allByTalentId = talentFansUnionRepository.findAllByTalentId(user.getId());
            if (allByTalentId == null || allByTalentId.isEmpty()) {
                result.add(fTalentUserInfoEntity);
            }else{
                System.out.println("已入："+user.getNickName());
            }
        }
        return result;
    }

    private void save(FTalentUserInfoEntity fTalentUserInfoEntity, List<FansUserInfoEntity> fansList) {
        TalentUserInfoEntity byUniqueId = talentUserRepository.findByUniqueId(fTalentUserInfoEntity.getUniqueId());
        if (byUniqueId == null) {
            TalentUserInfoEntity talentUserInfoEntity = new TalentUserInfoEntity();
            BeanUtils.copyProperties(fTalentUserInfoEntity, talentUserInfoEntity);
            byUniqueId = talentUserRepository.save(talentUserInfoEntity);
            dealTag(byUniqueId.getId(), fTalentUserInfoEntity.getTags());
            dealFans(byUniqueId.getId(), fansList);
        } else {
            dealFans(byUniqueId.getId(), fansList);
        }
        System.out.println(fTalentUserInfoEntity.getNickName());
    }

    private void dealFans(Integer id, List<FansUserInfoEntity> fansList) {
        ArrayList<TalentFansUnionEntity> ids = new ArrayList<>();
        int index = 0;
        for (FansUserInfoEntity fansUserInfoEntity : fansList) {
            index++;
            if (index % 50 == 0) {
                System.out.println(1);
            }
            FansUserInfoEntity byUid = fansUserInfoRepositiory.findByUid(fansUserInfoEntity.getUid());
            if (byUid == null) {
                byUid = fansUserInfoRepositiory.save(fansUserInfoEntity);
            }
            TalentFansUnionEntity talentFansUnionEntity = new TalentFansUnionEntity();
            talentFansUnionEntity.setTalentId(id);
            talentFansUnionEntity.setFansId(byUid.getId());
            ids.add(talentFansUnionEntity);
        }
        index = 0;
        System.out.println(ids.size());
        ArrayList<TalentFansUnionEntity> ids2 = new ArrayList<>();
        for (TalentFansUnionEntity talentFansUnionEntity : ids) {
            TalentFansUnionEntity byFansIdAndTalentId = talentFansUnionRepository.findByFansIdAndTalentId(talentFansUnionEntity.getFansId(), talentFansUnionEntity.getTalentId());
            if (byFansIdAndTalentId == null) {
                ids2.add(talentFansUnionEntity);
            }
            index++;
            if (index % 50 == 0) {
                System.out.println(2);
            }
        }

        talentFansUnionRepository.saveAll(ids2);
        System.out.println("ok");
    }

    private void dealTag(Integer id, String tags) {
        tags = tags.replace("\"", "");
        tags = tags.replace("[", "");
        tags = tags.replace("]", "");
        String[] split = null;
        if (tags.indexOf(",") > -1) {
            split = tags.split(",");
        } else {
            split = new String[1];
            split[0] = tags;
        }
        ArrayList<TalentTypeUnionEntity> talentTypeUnionEntities = new ArrayList<>();
        for (String s : split) {
            List<TalentTypeEntity> talentTypeEntities = talentTypeRepository.findAllByTypeName(s);
            if (talentTypeEntities != null) {
                for (TalentTypeEntity talentTypeEntity : talentTypeEntities) {
                    TalentTypeUnionEntity talentTypeUnionEntity = new TalentTypeUnionEntity();
                    talentTypeUnionEntity.setTalentTypeId(talentTypeEntity.getId());
                    talentTypeUnionEntity.setTalentUserInfoId(id);
                    talentTypeUnionEntities.add(talentTypeUnionEntity);
                }
            } else {
                TalentTypeEntity talentTypeEntity = new TalentTypeEntity();
                talentTypeEntity.setTypeName(s);
                talentTypeEntity = talentTypeRepository.save(talentTypeEntity);
                TalentTypeUnionEntity talentTypeUnionEntity = new TalentTypeUnionEntity();
                talentTypeUnionEntity.setTalentTypeId(talentTypeEntity.getId());
                talentTypeUnionEntity.setTalentUserInfoId(id);
                talentTypeUnionEntities.add(talentTypeUnionEntity);
            }
        }
        talentTypeUnioRepository.saveAll(talentTypeUnionEntities);
    }

    public int toInt(String s) {
        if (s.indexOf("w") > -1) {
            s = s.replace("w", "");
            return (int) (Float.parseFloat(s) * 10000);
        }
        return Integer.parseInt(s);
    }

    private List<FansUserInfoEntity> getFansList(FTalentUserInfoEntity fTalentUserInfoEntity, String replace) throws
            IOException {
        String path = "E:\\桌面\\dy\\数据\\500达人\\500粉丝数据\\";
        File file = new File(path, replace + ".json");
        if (file.exists()) {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String text = "";
            while (bfr.ready()) {
                text += bfr.readLine();
            }
            JSONObject jsonObject;
            try {
                jsonObject = JSONObject.parseObject(text);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                bfr.close();
            }

            Set<String> keySet = jsonObject.keySet();
            JSONObject jsonObject1 = null;
            List<FansUserInfoEntity> userInfoEntities = new ArrayList<>();
            for (String key : keySet) {
                try {
                    jsonObject1 = jsonObject.getJSONObject(key);
                    if (jsonObject1 != null) {
                        FansUserInfoEntity fansUserInfoEntity = new FansUserInfoEntity();
                        if (jsonObject1.containsKey("nick_name")) {
                            fansUserInfoEntity.setNickName(jsonObject1.getString("nick_name"));
                        }
                        fansUserInfoEntity.setDyNum(jsonObject1.getString("douyin_id"));
                        fansUserInfoEntity.setSignature(jsonObject1.getString("describe"));
                        fansUserInfoEntity.setFollowingCount(toInt(jsonObject1.getString("follow_count")));
                        fansUserInfoEntity.setFollowerCount(toInt(jsonObject1.getString("fans")));
                        fansUserInfoEntity.setTotalFavorited(toInt(jsonObject1.getString("like")));
                        fansUserInfoEntity.setAwemeCount(toInt(jsonObject1.getString("work")));
                        fansUserInfoEntity.setFavoritingCount(toInt(jsonObject1.getString("love")));
                        fansUserInfoEntity.setUid(key);
                        userInfoEntities.add(fansUserInfoEntity);
                    } else {
                        System.out.println(false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return userInfoEntities;
        }
        return null;
    }

    private String[] getPathFile(String s) {
        File file = new File(s);
        String[] list = file.list();
        return list;
    }

    public void getdata() {
        String path = "E:\\桌面\\dy\\tempNickname.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            String line = reader.readLine();
            if (line != null) {
                if (line.indexOf(",") > -1) {
                    String[] split = line.split(",");
                    nicknames.addAll(Arrays.asList(split));
                } else {
                    nicknames.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void adddata(String nick, String path) {
        nicknames.add(nick);
        if (path == null) {
            path = "E:\\桌面\\dy\\tempNickname.txt";
        }
        InputStream inputStream = null;
        OutputStreamWriter writer = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
            String line = reader.readLine();
            if (line != null) {
                line = line + "," + nick;
            } else {
                line = nick;
            }
            writer = new OutputStreamWriter(new FileOutputStream(new File(path)));
            writer.write(line);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void test() {
        ToMysql toMysqlMain = new ToMysql();
        try {
            toMysqlMain.main();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
