package io.jaconunes.walletcontrolapi.repository;

import io.jaconunes.walletcontrolapi.entities.Despesa;
import io.jaconunes.walletcontrolapi.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query(value = "SELECT * FROM tb_receita WHERE user_id = :userId", nativeQuery = true)
    Set<Receita> findReceitaByUserId(@Param("userId") Long userId);

}
