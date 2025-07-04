package com.Uber.Uber.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Chamados extends Corrida{
    private double kmInicial;
    private double kmFinal;
    private String hrInicial;
    private String hrFinal;
    private double valorCorrida;

    @ManyToOne
    private Veiculos veiculo;

    @ManyToOne
    private Motoristas motorista;

    @ManyToOne
    private Clientes cliente;

    // public Chamados() { }

    public Chamados(String origem, String destino, String data, String tipoServico, Long idCliente,
                    double kmInicial, double kmFinal,
                    String hrInicial, String hrFinal, double valorCorrida,
                    Veiculos veiculo, Motoristas motorista, Clientes cliente) {
        super(origem, destino, data, tipoServico, idCliente);
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.hrInicial = hrInicial;
        this.hrFinal = hrFinal;
        this.valorCorrida = valorCorrida;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.cliente = cliente;
    }


    public double getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(double kmInicial) {
        this.kmInicial = kmInicial;
    }

    public double getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(double kmFinal) {
        this.kmFinal = kmFinal;
    }

    public String getHrInicial() {
        return hrInicial;
    }

    public void setHrInicial(String hrInicial) {
        this.hrInicial = hrInicial;
    }

    public String getHrFinal() {
        return hrFinal;
    }

    public void setHrFinal(String hrFinal) {
        this.hrFinal = hrFinal;
    }

    public double getValorCorrida() {
        return valorCorrida;
    }

    public void setValorCorrida(double valorCorrida) {
        this.valorCorrida = valorCorrida;
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }

    public Motoristas getMotorista() {
        return motorista;
    }

    public void setMotorista(Motoristas motorista) {
        this.motorista = motorista;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }


    
}
