package pe.edu.utp.olimpiadas_aqp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.utp.olimpiadas_aqp.entities.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    @Query("select c from client c where c.user.userId = ?1")
    ClientEntity findByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("update client c set c.phone = :phone, c.representative = :representative where c.clientId = :client_id")
    int editClientById(
            @Param("client_id") Long clientId,
            @Param("phone") Long phone,
            @Param("representative") String representative);
}