package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.olimpiadas_aqp.entities.CategoryEntity;
import pe.edu.utp.olimpiadas_aqp.entities.SportEventEntity;

import java.sql.Date;
import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<CategoryEntity, Long> {
    @Transactional
    @Modifying
    @Query("update category c set c.name = :name, c.description = :description where c.categoryId = :category_id")
    int editById(
            @Param("category_id") Long categoryId,
            @Param("name") String name,
            @Param("description") String description);

    @Query(value = "select * from category where sport_event_id = :sport_event_id", nativeQuery = true)
    List<CategoryEntity> findBySportEventId(@Param("sport_event_id") Long sportEventId);
}
