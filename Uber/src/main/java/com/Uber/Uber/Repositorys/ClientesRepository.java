package com.Uber.Uber.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Uber.Uber.Entitys.Clientes;

@Repository
public interface ClientesRepository  extends JpaRepository<Clientes, Long>{

}
