package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.utp.olimpiadas_aqp.entities.SportEventEntity;

import java.util.List;

@Repository
public interface SportEventRepository extends JpaRepository<SportEventEntity, Long> {
    @Query(value = "select * from sport_event where event_id = :event_id", nativeQuery = true)
    List<SportEventEntity> findByEventId(@Param("event_id") Long eventId);

    @Query(value = "select * from sport_event where event_id = :event_id and delegate_id = :delegate_id", nativeQuery = true)
    List<SportEventEntity> findByEventIdAndDelegateId(@Param("event_id") Long eventId, @Param("delegate_id") Long delegateId);
}
