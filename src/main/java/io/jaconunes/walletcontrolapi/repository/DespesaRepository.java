package io.jaconunes.walletcontrolapi.repository;

import io.jaconunes.walletcontrolapi.entities.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
