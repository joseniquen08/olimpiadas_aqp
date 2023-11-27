package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.olimpiadas_aqp.entities.DelegateEntity;
import pe.edu.utp.olimpiadas_aqp.entities.SportEventEntity;

import java.util.List;

@Repository
public interface DelegateRepository extends JpaRepository<DelegateEntity, Long> {
    @Query("select d from delegate d where d.user.userId = ?1")
    DelegateEntity findByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("update delegate d set d.phone = :phone where d.delegateId = :delegate_id")
    int editDelegateById(
            @Param("delegate_id") Long delegateId,
            @Param("phone") Long phone);
}
