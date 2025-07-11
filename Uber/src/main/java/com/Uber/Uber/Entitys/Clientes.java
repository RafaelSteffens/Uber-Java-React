package com.Uber.Uber.Entitys;

import jakarta.persistence.Entity;


@Entity
public class Clientes extends Pessoa {
    private String cpfRg;

    // public Clientes() {}
    public Clientes() {
        super("Nome Padrão", "Telefone Padrão", new Endereco()); // Chama o construtor da classe pai
    }
    public Clientes(String nome, String telefone, Endereco endereco, String cpfRg) {
        super(nome, telefone, endereco);
        this.cpfRg = cpfRg;
    }

    public String getCpfRg() {
        return cpfRg;
    }

    public void setCpfRg(String cpfRg) {
        this.cpfRg = cpfRg;
    }
    
    



}
