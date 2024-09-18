package com.Gtec.ProjetoGtec.repository;

import com.Gtec.ProjetoGtec.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
}
