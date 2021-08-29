package com.lida.dy.dao;

        import com.lida.dy.model.entity.PlatformPropertyEntity;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;

        import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/3 0003 15:03
 * @Version: 1.0
 */
public interface PlatformPropertyRepostitory extends JpaRepository<PlatformPropertyEntity, Integer> {
    @Query(value = "select * from platform_property where platform_id = :platformId and type_id = :typeId limit :size", nativeQuery = true)
    List<PlatformPropertyEntity> getAllPlatformTypeUserData(@Param("platformId") int platformId, @Param("typeId") int typeId, @Param("size") int size);
}
