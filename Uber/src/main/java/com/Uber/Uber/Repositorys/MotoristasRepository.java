package com.Uber.Uber.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Uber.Uber.Entitys.Motoristas;

@Repository
public interface MotoristasRepository extends JpaRepository<Motoristas, Long>{

}
