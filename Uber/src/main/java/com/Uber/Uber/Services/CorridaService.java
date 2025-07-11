package com.Uber.Uber.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Uber.Uber.Entitys.Chamados;
import com.Uber.Uber.Entitys.Clientes;
import com.Uber.Uber.Entitys.Corrida;
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
                .orElseThrow(null);
    }

    public Chamados getChamadoById(Long id) {
        Optional<Chamados> optionalChamado = chamadosRepository.findById(id);
        return optionalChamado.orElse(null); // Retorna o objeto Chamados se presente, ou null se não estiver
    }
    

    public Clientes getClienteById(Long id) {
        return clientesRepository.findById(id)
                .orElseThrow(null);
    }
}
