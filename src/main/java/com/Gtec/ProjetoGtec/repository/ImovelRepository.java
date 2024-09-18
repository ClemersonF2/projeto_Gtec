package com.Gtec.ProjetoGtec.repository;

import com.Gtec.ProjetoGtec.entity.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel,Long> {
}
