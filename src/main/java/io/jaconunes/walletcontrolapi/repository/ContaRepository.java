package io.jaconunes.walletcontrolapi.repository;

import io.jaconunes.walletcontrolapi.entities.Conta;
import io.jaconunes.walletcontrolapi.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query(value = "SELECT * FROM tb_conta WHERE user_id = :userId", nativeQuery = true)
    Set<Conta> findContaByUserId(@Param("userId") Long userId);

}
