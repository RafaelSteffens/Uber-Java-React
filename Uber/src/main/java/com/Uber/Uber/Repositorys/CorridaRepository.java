package com.Uber.Uber.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Uber.Uber.Entitys.Corrida;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Long>{

}




