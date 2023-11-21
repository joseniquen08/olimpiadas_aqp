package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.olimpiadas_aqp.entities.CategoryEntity;

import java.sql.Date;

@Repository
public interface CategoryRepository  extends JpaRepository<CategoryEntity, Long> {
    @Transactional
    @Modifying
    @Query("update category s set s.name = :name, s.description = :description where s.categoryId = :category_id")
    int editById(
            @Param("category_id") Long categoryId,
            @Param("name") String name,
            @Param("description") String description);

}
