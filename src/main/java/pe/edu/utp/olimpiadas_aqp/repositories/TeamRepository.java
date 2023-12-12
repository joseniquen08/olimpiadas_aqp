package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.olimpiadas_aqp.entities.TeamEntity;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    @Transactional
    @Modifying
    @Query("update team t set t.name = :name, t.imageUrl = :imageUrl where t.teamId = :team_id")
    int editById(
            @Param("team_id") Long teamId,
            @Param("name") String name,
            @Param("imageUrl") String imageUrl);

    @Query(value = "select * from team where category_id = :category_id", nativeQuery = true)
    List<TeamEntity> findByCategoryId(@Param("category_id") Long categoryId);
}
