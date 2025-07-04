package com.Uber.Uber.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Uber.Uber.Entitys.Chamados;
import com.Uber.Uber.Entitys.Corrida;
import com.Uber.Uber.Entitys.Clientes;
import com.Uber.Uber.Repositorys.ChamadosRepository;
import com.Uber.Uber.Repositorys.ClientesRepository;
import com.Uber.Uber.Repositorys.CorridaRepository;

@Service
public class CorridaService {

    @Autowired
    private CorridaRepository corridaRepository;

    @Autowired
    private ChamadosRepository chamadosRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    public Corrida getCorridaById(Long id) {
        return corridaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corrida não encontrada com o ID: " + id));
    }

    public Chamados getChamadoById(Long id) {
        return chamadosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corrida não encontrada com o ID: " + id));
    }

    public Clientes getClienteById(Long id) {
        return clientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corrida não encontrada com o ID: " + id));
    }
}
