package com.Uber.Uber.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Uber.Uber.Entitys.Chamados;


@Repository
public interface ChamadosRepository extends JpaRepository<Chamados, Long> {

}
