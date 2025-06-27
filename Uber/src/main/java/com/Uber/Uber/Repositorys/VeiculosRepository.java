package com.Uber.Uber.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Uber.Uber.Entitys.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {

}
