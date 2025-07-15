package com.Uber.Uber.Entitys;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public class Corrida {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCorrida;
    private String origem;
    private String destino;
    private String data;
    private String tipoServico;
    private Long idCliente;
    private boolean semMotorista = true;

    public Corrida() { }

    public Corrida(String origem, String destino, String data, String tipoServico, Long idCliente, boolean semMotorista) {
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.tipoServico = tipoServico;
        this.idCliente = idCliente;
        this.semMotorista = semMotorista;
    }

    
    public boolean isSemMotorista() {
        return semMotorista;
    }

    public void setSemMotorista(boolean semMotorista) {
        this.semMotorista = semMotorista;
    }

    public Long getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(Long idCorrida) {
        this.idCorrida = idCorrida;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }


    


    

    

}
