package com.Uber.Uber.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Corrida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCorrida;
    private String Origem;
    private String Destino;
    private String Data;

    public Corrida(String origem, String destino, String data) {
        Origem = origem;
        Destino = destino;
        Data = data;
    }

    public Long getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(Long idChamados) {
        this.idCorrida = idChamados;
    }

    public String getOrigem() {
        return Origem;
    }

    public void setOrigem(String origem) {
        Origem = origem;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    

    

}
