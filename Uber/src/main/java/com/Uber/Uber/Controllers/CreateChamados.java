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

       // Clientes newCliente = new Clientes(request.getNome(), request.getTelefone(), request.getEndereco(), request.getCpfRg());

        clientesRepository.save(request);

        
        return ResponseEntity.ok("Cliente Cadastrado com sucesso");
    }

    @PostMapping("/createCorrida")
    public ResponseEntity<String> createCorrida(@RequestBody Corrida request) {

        Corrida newCorrida = new Corrida(request.getOrigem(), request.getDestino(), request.getData(), request.getTipoServico(), request.getIdCliente(), true);

        corridaRepository.save(newCorrida);
        
        return ResponseEntity.ok("Corrida Cadastrada com sucesso");
    }

    
    @GetMapping("/consultaCorrida")
    public List<Corrida> consultaCorrida() {
        List<Corrida> allCorridasSemChamado = new ArrayList<>();
        List<Corrida> allCorridas = corridaRepository.findAll();
        
        for (Corrida corrida : allCorridas) {
            try {
                if (corrida.isSemMotorista()) {
                    allCorridasSemChamado.add(corrida);
                } else {
                    System.out.println(corrida);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return allCorridasSemChamado;
    }
    

    

    
    
    @PostMapping("/createChamado")
    public ResponseEntity<String> createNewChamado(@RequestBody Long request) {

        Corrida corrida = corridaService.getCorridaById(request);
        Clientes cliente = corridaService.getClienteById(corrida.getIdCliente());

        Endereco enderecoMotorista = new Endereco("Rua A", 123, "88000000", "Casa", "SC", "Florianópolis");
        enderecoRepository.save(enderecoMotorista);
        Motoristas motorista = new Motoristas("Rafael", "489917717665", enderecoMotorista, "788995562");
        motoristasRepository.save(motorista);
        Veiculos veiculo = new Veiculos("OZW-6777", "F-80", "2025", "Vermelha", "Ferrari");
        veiculosRepository.save(veiculo);

        corrida.setSemMotorista(false);
        corridaRepository.save(corrida);

        Chamados newChamado = new Chamados(corrida.getOrigem(),corrida.getDestino(),corrida.getData(), corrida.getTipoServico(),corrida.getIdCliente(), corrida.isSemMotorista(), 1, 7, "10:57",  "11:07", 10.57, veiculo, motorista,  cliente );

        chamadosRepository.save(newChamado);
        
        


        return ResponseEntity.ok("Chamado criado com sucesso!");
    }


}


