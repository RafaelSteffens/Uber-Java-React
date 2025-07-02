package com.Uber.Uber.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Uber.Uber.Entitys.Chamados;
import com.Uber.Uber.Entitys.Clientes;
import com.Uber.Uber.Entitys.Corrida;
import com.Uber.Uber.Entitys.Endereco;
import com.Uber.Uber.Entitys.Motoristas;
import com.Uber.Uber.Entitys.Veiculos;
import com.Uber.Uber.Repositorys.ChamadosRepository;
import com.Uber.Uber.Repositorys.ClientesRepository;
import com.Uber.Uber.Repositorys.CorridaRepository;
import com.Uber.Uber.Repositorys.EnderecoRepository;
import com.Uber.Uber.Repositorys.MotoristasRepository;
import com.Uber.Uber.Repositorys.VeiculosRepository;
import com.Uber.Uber.Services.CorridaService;





@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CreateChamados {

    @Autowired
    private ChamadosRepository chamadosRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private MotoristasRepository motoristasRepository;

    @Autowired
    private VeiculosRepository veiculosRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CorridaRepository corridaRepository;

    @Autowired
    private CorridaService corridaService;


    @GetMapping("/index")
    public String Index() {
        return "index";
    }
    @PostMapping("/createUser")
    public ResponseEntity<String> formRegisterUser (@RequestBody Clientes request) {

        Clientes newCliente = new Clientes(request.getNome(), request.getTelefone(), request.getEndereco(), request.getCpfRg());

        clientesRepository.save(newCliente);

        
        return ResponseEntity.ok("Cliente Cadastrado com sucesso");
    }

    @PostMapping("/createCorrida")
    public ResponseEntity<String> createCorrida(@RequestBody Corrida request) {

        Corrida newCorrida = new Corrida(request.getOrigem(), request.getDestino(), request.getData(), request.getTipoServico(), request.getIdCliente());

        corridaRepository.save(newCorrida);
        
        return ResponseEntity.ok("Corrida Cadastradaa com sucesso");
    }

    
    @GetMapping("/consultaCorrida")
    public List<Corrida> consultaCorrida() {
    
        // List<Corrida> listCorridaSemMotorista = new ArrayList<>();
    
        // List<Corrida> todasCorridas = corridaRepository.findAll();
    
        // for (Corrida corrida : todasCorridas) {
        //     Chamados chamado = corridaService.getChamadoById(corrida.getIdCorrida());
    
        //     // Verifica se o chamado NÃO tem motorista associado
        //     if (chamado.getMotorista() == null) {
        //         listCorridaSemMotorista.add(corrida);
        //     }
        // }
    
        // return listCorridaSemMotorista;
        return corridaRepository.findAll();
    }
    
    


    

    
    
    @PostMapping("/createChamado")
    public ResponseEntity<String> createNewChamado(@RequestBody Long request) {

        Corrida corrida = corridaService.getCorridaById(request);

        // Motorista
        Endereco enderecoMotorista = new Endereco("Rua A", 123, "88000000", "Casa", "SC", "Florianópolis");
        enderecoRepository.save(enderecoMotorista);
        Motoristas motorista = new Motoristas("Rafael", "489917717665", enderecoMotorista, "788995562");
        motoristasRepository.save(motorista);
        // Veículo
        Veiculos veiculo = new Veiculos("OZW-6777", "F-80", "2025", "Vermelha", "Ferrari");
        veiculosRepository.save(veiculo);

        Chamados newChamado = new Chamados(corrida.getOrigem(),corrida.getDestino(),corrida.getData(), corrida.getTipoServico(),corrida.getIdCliente(), null, 0, 0, null, null, 0, null, null, null);

        chamadosRepository.save(newChamado);


        return ResponseEntity.ok("Chamado criado com sucesso!");
    }


}


