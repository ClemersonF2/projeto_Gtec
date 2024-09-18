package com.Gtec.ProjetoGtec.repository;

import com.Gtec.ProjetoGtec.entity.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante,Long> {

}
