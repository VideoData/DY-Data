package com.lida.dy.serviceImpl;

import com.lida.dy.conf.DefaultConfig;
import com.lida.dy.dao.TalentTypeRepostitory;
import com.lida.dy.dao.TalentTypeUnionRepositiory;
import com.lida.dy.dao.TalentUserRepository;
import com.lida.dy.model.entity.TalentTypeEntity;
import com.lida.dy.model.entity.TalentTypeUnionEntity;
import com.lida.dy.model.entity.TalentUserInfoEntity;
import com.lida.dy.utils.ToolUtil;
import com.lida.dy.model.vo.CandidateSearchMutiVO;
import com.lida.dy.model.vo.MutilSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 10:47
 * @Version: 1.0
 */
@Service
public class TalentUserService {
    @Autowired
    TalentUserRepository talentUserRepository;
    @Autowired
    TalentTypeRepostitory talentTypeRepostitory;
    @Autowired
    TalentTypeUnionRepositiory talentTypeUnionRepositiory;
    @Autowired
    ToolUtil toolUtil;

    //分页查询
    public Page<TalentUserInfoEntity> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TalentUserInfoEntity> pages = talentUserRepository.findAllByOther("1", pageable);
//        Page<TalentUserInfoEntity> pages = talentUserRepository.findAll(pageable);
        toolUtil.wrapperTanlentUserInfo(pages);
        return pages;
    }


    /**
     * 按关键字排序查询
     *
     * @param page
     * @param size
     * @param sortName 关键字
     * @param isAsc    是否升序
     * @return
     */
    public Page<TalentUserInfoEntity> getAllByCondition(int page, int size, String sortName, boolean isAsc) {
        Pageable pageable;
        if (isAsc) {
            pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortName));
        } else {
            pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sortName));
        }
        Page<TalentUserInfoEntity> pages = talentUserRepository.findAllByOther("1", pageable);
//        Page<TalentUserInfoEntity> pages = talentUserRepository.findAll(pageable);
        toolUtil.wrapperTanlentUserInfo(pages);
        return pages;
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<TalentUserInfoEntity> getAll() {
        System.out.println(talentUserRepository.findById(1));
        List<TalentUserInfoEntity> all = talentUserRepository.findAllByOther("1");
        toolUtil.wrapperTanlentUserInfo(all);
        return all;
    }


    /**
     * 获取解析Predicate
     *
     * @param name
     * @param root
     * @param criteriaBuilder
     * @param s
     * @return
     */
    public Predicate parseToPredicate(String name, Root<TalentUserInfoEntity> root, CriteriaBuilder
            criteriaBuilder, String s) {
        if (s.indexOf("以上") > -1) {
            s.replace("以上", "");
            return criteriaBuilder.gt(root.get(name), toolUtil.WToInt(s));
        } else if (s.indexOf("以下") > -1) {
            s.replace("以下", "");
            return criteriaBuilder.le(root.get(name), toolUtil.WToInt(s));
        } else if (s.indexOf("-") > -1) {
            String[] split = s.split("-");
            return criteriaBuilder.between(root.get(name), toolUtil.WToInt(split[0]), toolUtil.WToInt(split[1]));
        }
        return null;
    }

    public Page<TalentUserInfoEntity> searchByKeyword(String keyword, int page, int size) {
        // 构造自定义查询条件
        Specification<TalentUserInfoEntity> queryCondition = new Specification<TalentUserInfoEntity>() {
            @Override
            public Predicate toPredicate(Root<TalentUserInfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                predicateList.add(criteriaBuilder.like(root.get("nickName"), "%" + keyword + "%"));
                predicateList.add(criteriaBuilder.equal(root.get("other"), "1"));
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        PageRequest pageRequest = PageRequest.of(page, size);

        Page pages = talentUserRepository.findAll(queryCondition, pageRequest);
        toolUtil.wrapperTanlentUserInfo(pages);
        return pages;

    }

    public TalentUserInfoEntity findById(int id) {
        TalentUserInfoEntity talentUserInfoEntity1 = talentUserRepository.findById(id).get();
        toolUtil.wrapperTanlentUserInfo(talentUserInfoEntity1);
        return talentUserInfoEntity1;
    }

    public List<TalentUserInfoEntity> searchByListId(Set<Integer> ids) {
        List<TalentUserInfoEntity> talentUserInfoEntities = new ArrayList<>();
        for (Integer id : ids) {
            talentUserInfoEntities.add(talentUserRepository.findById(id).get());
        }
        toolUtil.wrapperTanlentUserInfo(talentUserInfoEntities);
        return talentUserInfoEntities;
    }

    /**
     * 复杂搜索
     *
     * @param mutilSearchVo
     * @return
     */
    public Page<TalentUserInfoEntity> multiSearch(MutilSearchVo mutilSearchVo) {

        // 构造自定义查询条件
        Specification<TalentUserInfoEntity> queryCondition = new Specification<TalentUserInfoEntity>() {
            @Override
            public Predicate toPredicate(Root<TalentUserInfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                /*处理类型*/
                if (mutilSearchVo.getType() != null) {
                    ArrayList<Integer> userIds = new ArrayList<>();
                    for (String typeName : mutilSearchVo.getType()) {
                        List<Integer> ids = talentTypeRepostitory.findIdByTypeNames(typeName);
                        if (ids != null && !ids.isEmpty()) {
                            for (Integer id : ids) {
                                List<Integer> tempsId = talentTypeUnionRepositiory.findIdByTypeId(id);
                                userIds.addAll(tempsId);
                            }
                        }
                    }
                    if (!userIds.isEmpty()) {
                        CriteriaBuilder.In<Integer> in = criteriaBuilder.in(root.get("id"));
                        for (Integer userId : userIds) {
                            in.value(userId);
                        }
                        predicateList.add(in);
                    }
                }
                /*处理搜索关键字*/
                if (mutilSearchVo.getKeyWord() != null) {
                    Predicate like = criteriaBuilder.like(root.get("nickName"), "%" + mutilSearchVo.getKeyWord() + "%");
                    predicateList.add(like);
                }
                /*处理粉丝数*/
                if (mutilSearchVo.getFans() != null && !mutilSearchVo.getFans().isEmpty()) {
                    predicateList.add(getMutilNumPredicate("fansCount", root, criteriaBuilder, mutilSearchVo.getFans()));
                }
                /*处理价值，预计播放量*/
                if (mutilSearchVo.getValue() != null && !mutilSearchVo.getValue().isEmpty()) {
                    predicateList.add(getMutilNumPredicate("prePlayNum", root, criteriaBuilder, mutilSearchVo.getValue()));
                }
                /*处理选择平台*/
                predicateList.add(criteriaBuilder.equal(root.get("platformId"), mutilSearchVo.getPlatform()));
                if (mutilSearchVo.getPlatform() == 1) {
                    predicateList.add(criteriaBuilder.equal(root.get("other"), "1"));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        PageRequest pageRequest = null;
        Sort.Direction direction = mutilSearchVo.isDESC() ? Sort.Direction.DESC : Sort.Direction.ASC;
        if (mutilSearchVo.getSortWord() == null || mutilSearchVo.getSortWord().length() < 1) {
            pageRequest = PageRequest.of(mutilSearchVo.getPage() - 1, mutilSearchVo.getSize());
        } else if (mutilSearchVo.getSortWord().contains("粉丝数")) {
            System.out.println("fans");
            pageRequest = PageRequest.of(mutilSearchVo.getPage() - 1, mutilSearchVo.getSize(), Sort.by(direction, "fansCount"));
        } else if (mutilSearchVo.getSortWord().contains("预期播放量")) {
            System.out.println("preplaynum");
            pageRequest = PageRequest.of(mutilSearchVo.getPage() - 1, mutilSearchVo.getSize(), Sort.by(direction, "prePlayNum"));
        } else {
            pageRequest = PageRequest.of(mutilSearchVo.getPage() - 1, mutilSearchVo.getSize());
        }
        System.out.println(mutilSearchVo.toString());
        System.out.println(pageRequest.getPageNumber() + "::" + pageRequest.getPageSize());
        Page pages = talentUserRepository.findAll(queryCondition, pageRequest);
        toolUtil.wrapperTanlentUserInfo(pages);
        return pages;
    }

    private Predicate getMutilNumPredicate(String rootName, Root<TalentUserInfoEntity> root, CriteriaBuilder criteriaBuilder, List<String> items) {
        int[][] result = dealSort(items);
        ArrayList<Predicate> predicates = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            Predicate predicate = null;
            if (i != result.length - 1) {
                predicate = criteriaBuilder.between(root.get(rootName), result[i][0], result[i][1]);
            } else {
                if (result[i][1] == -1) {
                    predicate = criteriaBuilder.gt(root.get(rootName), result[i][0]);
                } else {
                    predicate = criteriaBuilder.between(root.get(rootName), result[i][0], result[i][1]);
                }
            }
            predicates.add(predicate);
        }
        return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));

    }

    private int[][] dealSort(List<String> fans) {
        int[][] temp = new int[fans.size()][2];
        int i = 0;
        for (String fan : fans) {
            if (fan.indexOf("-") > -1) {
                String[] split = fan.split("-");
                temp[i][0] = toolUtil.WToInt(split[0]);
                temp[i][1] = toolUtil.WToInt(split[1]);
            } else if (fan.contains("以下")) {
                fan = fan.replace("以下", "");
                temp[i][0] = 0;
                temp[i][1] = toolUtil.WToInt(fan);
            } else {
                temp[i][0] = toolUtil.WToInt(fan);
                temp[i][1] = -1;
            }
            i++;
        }
        int[][] result = new int[i][2];
        for (int j = 0; j < i - 1; j++) {
            for (int k = 0; k < i - 1 - j; k++) {
                if (temp[k][0] > temp[k + 1][0]) {
                    int a = temp[k + 1][0];
                    int b = temp[k + 1][1];
                    temp[k + 1][0] = temp[k][0];
                    temp[k + 1][1] = temp[k][1];
                    temp[k][0] = a;
                    temp[k][1] = b;
                }
            }
        }
        result[0][0] = temp[0][0];
        result[0][1] = temp[0][1];
        int k = 0;
        for (int j = 1; j < i; j++) {
            if (result[k][1] == temp[j][0]) {
                result[k][1] = temp[j][1];
            } else {
                k++;
                result[k][0] = temp[j][0];
                result[k][1] = temp[j][1];
            }
        }
        int[][] ints = new int[k][2];
        for (int j = 0; j < k; j++) {
            ints[j][0] = result[j][0];
            ints[j][1] = result[j][1];
        }
        return ints;
    }
}
