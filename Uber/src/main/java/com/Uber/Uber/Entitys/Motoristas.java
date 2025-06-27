package com.Uber.Uber.Entitys;

import jakarta.persistence.Entity;


@Entity
public class Motoristas extends Pessoa {


    private String CNH;
    

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String cNH) {
        CNH = cNH;
    }
    // public Motoristas() {}

    public Motoristas (String nome, String telefone, Endereco endereco, String CNH) {
        super(nome, telefone, endereco);
        this.CNH = CNH;
    }


}
