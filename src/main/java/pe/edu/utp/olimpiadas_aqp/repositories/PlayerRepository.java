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
    @Query("update player s set s.name = :name, s.gender = :gender, s.dateBirth = :dateBirth, s.size = :size, s.weight = :weight, s.numberTshirt = :numberTshirt where s.playerId = :player_id")
    int editById(
            @Param("player_id") Long palyerId,
            @Param("name") String name,
            @Param("gender") String gender,
            @Param("dateBirth") Date dateBirth,
            @Param("size") double size,
            @Param("weight") double weight,
            @Param("numberTshirt") int numberTshirt);
    
}
