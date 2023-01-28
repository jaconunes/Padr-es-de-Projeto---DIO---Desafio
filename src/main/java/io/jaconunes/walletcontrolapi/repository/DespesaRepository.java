package io.jaconunes.walletcontrolapi.repository;

import io.jaconunes.walletcontrolapi.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query("")
    Set<Despesa> buscarDespesasPorUsuario(Long id);

}
