package com.Uber.Uber.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Uber.Uber.Entitys.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
