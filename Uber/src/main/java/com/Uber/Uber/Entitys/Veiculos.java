package com.Uber.Uber.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeiculos;

    private String Placa;
    private String Modelo;
    private String Ano;
    private String Cor;
    private String Marca;



    public Veiculos () {}
    
    public Veiculos(String placa, String modelo, String ano, String cor, String marca) {
        Placa = placa;
        Modelo = modelo;
        Ano = ano;
        Cor = cor;
        Marca = marca;

    }

    public Long getIdVeiculos() {
        return idVeiculos;
    }
    public void setIdVeiculos(Long idVeiculos) {
        this.idVeiculos = idVeiculos;
    }
    public String getPlaca() {
        return Placa;
    }
    public void setPlaca(String placa) {
        Placa = placa;
    }
    public String getModelo() {
        return Modelo;
    }
    public void setModelo(String modelo) {
        Modelo = modelo;
    }
    public String getAno() {
        return Ano;
    }
    public void setAno(String ano) {
        Ano = ano;
    }
    public String getCor() {
        return Cor;
    }
    public void setCor(String cor) {
        Cor = cor;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }

    



}
