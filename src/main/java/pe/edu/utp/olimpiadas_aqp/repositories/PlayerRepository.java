package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.olimpiadas_aqp.entities.PlayerEntity;


import java.sql.Date;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    @Transactional
    @Modifying
    @Query("update player p set p.name = :name, p.gender = :gender, p.birthdate = :birthdate, p.height = :height, p.weight = :weight, p.jerseyNumber = :jerseyNumber where p.playerId = :player_id")
    int editById(
            @Param("player_id") Long playerId,
            @Param("name") String name,
            @Param("gender") String gender,
            @Param("birthdate") Date birthdate,
            @Param("height") double height,
            @Param("weight") double weight,
            @Param("jerseyNumber") int jerseyNumber);
}
