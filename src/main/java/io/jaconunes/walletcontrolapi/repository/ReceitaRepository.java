package io.jaconunes.walletcontrolapi.repository;

import io.jaconunes.walletcontrolapi.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
