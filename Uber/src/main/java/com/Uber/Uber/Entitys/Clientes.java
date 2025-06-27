package com.Uber.Uber.Entitys;

import jakarta.persistence.Entity;


@Entity
public class Clientes extends Pessoa {
    private String cpfRg;

    // public Clientes() {}

    public Clientes(String nome, String telefone, Endereco endereco, String cpfRg) {
        super(nome, telefone, endereco);
        this.cpfRg = cpfRg;
    }
    



}
