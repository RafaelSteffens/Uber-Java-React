package com.Uber.Uber.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Chamados extends Corrida{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChamados;
    private String TipoChamado;
    private double KmInicial;
    private double KmFinal;
    private String HrInicial;
    private String HrFinal;
    private double ValorCorrida;

    @ManyToOne
    private Veiculos veiculo;

    @ManyToOne
    private Motoristas motorista;

    @ManyToOne
    private Clientes cliente;
    


    public Chamados(String origem, String destino, String data, String tipoChamado, double kmInicial, double kmFinal,
            String hrInicial, String hrFinal, double valorCorrida, Veiculos idVeiculos, Motoristas idMotoristas,
            Clientes idClientes) {
        super(origem, destino, data);

        TipoChamado = tipoChamado;
        KmInicial = kmInicial;
        KmFinal = kmFinal;
        HrInicial = hrInicial;
        HrFinal = hrFinal;
        ValorCorrida = valorCorrida;
        this.veiculo = idVeiculos;
        this.motorista = idMotoristas;
        this.cliente = idClientes;
    }

    
    public Long getIdChamados() {
        return idChamados;
    }
    public void setIdChamados(Long idChamados) {
        this.idChamados = idChamados;
    }

    public String getTipoChamado() {
        return TipoChamado;
    }
    public void setTipoChamado(String tipoChamado) {
        TipoChamado = tipoChamado;
    }
    public double getKmInicial() {
        return KmInicial;
    }
    public void setKmInicial(double kmInicial) {
        KmInicial = kmInicial;
    }
    public double getKmFinal() {
        return KmFinal;
    }
    public void setKmFinal(double kmFinal) {
        KmFinal = kmFinal;
    }
    public String getHrInicial() {
        return HrInicial;
    }
    public void setHrInicial(String hrInicial) {
        HrInicial = hrInicial;
    }
    public String getHrFinal() {
        return HrFinal;
    }
    public void setHrFinal(String hrFinal) {
        HrFinal = hrFinal;
    }
    public double getValorCorrida() {
        return ValorCorrida;
    }
    public void setValorCorrida(double valorCorrida) {
        ValorCorrida = valorCorrida;
    }
    public Veiculos getIdVeiculos() {
        return veiculo;
    }
    public void setIdVeiculos(Veiculos idVeiculos) {
        this.veiculo = idVeiculos;
    }
    public Motoristas getIdMotoristas() {
        return motorista;
    }
    public void setIdMotoristas(Motoristas idMotoristas) {
        this.motorista = idMotoristas;
    }
    public Clientes getIdClientes() {
        return cliente;
    }
    public void setIdClientes(Clientes idClientes) {
        this.cliente = idClientes;
    }

    

}
