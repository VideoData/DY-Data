package com.lida.dy.schedle.util;

import com.alibaba.fastjson.JSON;
import com.lida.dy.schedle.entity.TalentUser;
import com.lida.dy.schedle.entity.TalentUserInfoEntity;
import com.lida.dy.schedle.pojo.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/30 0030 12:35
 * @Version: 1.0
 */
@Component
public class SpiderUtil {
    public static String path;

    /**
     * 清除数据里的html代码
     *
     * @return
     */
    public static String cleanHtml(String data) {
        String splitStr ="pre-wrap;\">";
        String splitEndStr ="</pre>";
        data =data.split(splitStr)[1];
        return data.split(splitEndStr)[0];
    }


    public static int getpage() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(path));
            Data data = JSON.parseObject(inputStream, Data.class);
            inputStream.close();
            return data.getPage();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static void initpage() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(path));
            Data data = JSON.parseObject(inputStream, Data.class);
            data.setPage(1);
            String s = JSON.toJSONString(data);
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File(path)));
            writer.write(s);
            writer.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addpage() {
        InputStream inputStream = null;
        OutputStreamWriter writer = null;
        try {
            inputStream = new FileInputStream(new File(path));
            Data data = JSON.parseObject(inputStream, Data.class);
            data.setPage(data.getPage() + 1);
            String s = JSON.toJSONString(data);
            writer = new OutputStreamWriter(new FileOutputStream(new File(path)));
            writer.write(s);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void addCatagory() {
        File file;
        OutputStreamWriter writer = null;
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(new File(path));
            Data data = JSON.parseObject(inputStream, Data.class);
            data.setPage(1);
            List<Integer> ok = data.getOk();
            List<Integer> ok2 = new ArrayList<>();
            if (ok.get(0) == 0) {
                ok2.add(1);
                for (int i = 1; i < ok.size(); i++) {
                    ok2.add(0);
                }
            } else {
                ok2.add(1);
                for (int i = 1; i < ok.size(); i++) {
                    if (ok.get(i - 1) == 1 && ok.get(i) == 0) {
                        ok2.add(1);
                    } else {
                        ok2.add(ok.get(i));
                    }
                }
            }
            data.setOk(ok2);
            String s = JSON.toJSONString(data);
            writer = new OutputStreamWriter(new FileOutputStream(new File(path)));
            writer.write(s);

            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Integer> getCatgoryData() {
        System.out.println(path);
        try {
            InputStream inputStream = new FileInputStream(new File(path));
            Data data = JSON.parseObject(inputStream, Data.class);
            System.out.println(data.toString());
            ArrayList<Integer> catgorys = new ArrayList<>();
            List<Integer> data1 = data.getData();
            for (Integer integer : data1) {
                catgorys.add(integer);
            }
            List<Integer> ok = data.getOk();
            for (Integer integer : ok) {
                if (integer == 1) {
                    catgorys.remove(0);
                } else {
                    return catgorys;
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * talentUser 转换成实体
     *
     * @param talentUser
     * @param talentUserInfoEntity
     * @return
     */
    public static TalentUserInfoEntity talentUserToEntity(TalentUser talentUser, TalentUserInfoEntity talentUserInfoEntity) {
        talentUserInfoEntity.setAvatarLink(talentUser.getAvatar_uri());
        talentUserInfoEntity.setProvince(talentUser.getProvince());
        talentUserInfoEntity.setCity(talentUser.getCity());
        talentUserInfoEntity.setNickName(talentUser.getNick_name());
//        talentUserInfoEntity.setXtPrePlayNum((int) talentUser.getExpected_play_num());
//        talentUserInfoEntity.setXtFollowerCount((int) talentUser.getFollower());
//        talentUserInfoEntity.setXtPersonalInterateRate(talentUser.getPersonal_interate_rate());
//        talentUserInfoEntity.setXtId(talentUser.getId());
//        talentUserInfoEntity.setXtIsStar(talentUser.is_star() ? 1 : 0);
//        talentUserInfoEntity.setXtCpm(talentUser.getExpected_cpm());
        talentUserInfoEntity.setGender(talentUser.getGender());
        talentUserInfoEntity.setPrice(talentUser.getPriceInfo());
        talentUserInfoEntity.setUniqueId(talentUser.getUnique_id());
        return talentUserInfoEntity;
    }

    /**
     * src的属性拷贝到target非空属性上
     *
     * @param src
     * @param target
     */
    public static void copyPropertiesNoNull(TalentUserInfoEntity src, TalentUserInfoEntity target) {
        Class<? extends TalentUserInfoEntity> aClass = target.getClass();
        Method[] methods = aClass.getMethods();
        Class<? extends TalentUserInfoEntity> aClass1 = src.getClass();
        Method[] methods1 = aClass1.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                try {
                    Object o = method.invoke(target);
                    if (o != null) {
                        continue;
                    }
                    if (o == null || (int) o == 0) {
                        Object o1 = null;
                        for (Method method1 : methods1) {
                            if (method.getName().equals(method1.getName())) {
                                o1 = method1.invoke(src);
                                break;
                            }
                        }
                        for (Method method1 : methods) {
                            if (method1.getName().startsWith("get")) {
                                continue;
                            }
                            if (method1.getName().endsWith(method.getName().replace("get", ""))) {
                                Class<?> returnType = method.getReturnType();
                                if (returnType.getName().indexOf("Double") > 0) {
                                    method1.invoke(target, (Double) o1);
                                } else if (returnType.getName().indexOf("Integer") > 0) {
                                    method1.invoke(target, (Integer) o1);
                                } else if (returnType.getName().indexOf("String") > 0) {
                                    method1.invoke(target, (String) o1);
                                } else if (returnType.getName().indexOf("Date") > 0) {
                                    method1.invoke(target, (Date) o1);
                                } else if (returnType.getName().indexOf("Float") > 0) {
                                    method1.invoke(target, (Float) o1);
                                }

                                break;
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
