package com.Uber.Uber.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Uber.Uber.Entitys.Clientes;
import com.Uber.Uber.Entitys.Corrida;
import com.Uber.Uber.Repositorys.ChamadosRepository;
import com.Uber.Uber.Repositorys.ClientesRepository;
import com.Uber.Uber.Repositorys.CorridaRepository;
import com.Uber.Uber.Repositorys.EnderecoRepository;
import com.Uber.Uber.Repositorys.MotoristasRepository;
import com.Uber.Uber.Repositorys.VeiculosRepository;





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


        //TODO: process POST request
        
        return ResponseEntity.ok("Corrida Cadastradaa com sucesso");
    }

    
    @GetMapping("/consultaCorrida")
    public List<Corrida> consultaCorrida() {
        return corridaRepository.findAll();
    }
    


    

    
    
    // @PostMapping("/createChamado")
    // public ResponseEntity<String> createNewChamado(@RequestBody String requestBody) {
    //     // JSONObject json = new JSONObject(requestBody);

    //     // createCorrida();
    //     //     JSONObject cliente = json.getJSONObject("cliente");
    //     //     JSONObject endereco = cliente.getJSONObject("endereco");
        
    //     //     String logradouro = endereco.getString("logradouro");
    //     //     int numero = endereco.getInt("numero");
    //     //     String cep = endereco.getString("cep");
    //     //     String complemento = endereco.getString("complemento");
    //     //     String estado = endereco.getString("estado");
    //     //     String cidade = endereco.getString("cidade");
        
    //     //     Endereco enderecoCliente = new Endereco(logradouro, numero, cep, complemento, estado, cidade);
    //     //     enderecoRepository.save(enderecoCliente);
        
    //     //     // Criar cliente com os dados também do JSON, por exemplo:
    //     //     String nome = cliente.getString("nome");
    //     //     String telefone = cliente.getString("telefone");
    //     //     String cpfRg = cliente.getString("cpfRg");
        
    //     //     Clientes clienteObj = new Clientes(nome, telefone, enderecoCliente, cpfRg);
    //     //     clientesRepository.save(clienteObj);



    //     // buscaMotorista();
    //     //     // Motorista
    //     //     Endereco enderecoMotorista = new Endereco("Rua A", 123, "88000000", "Casa", "SC", "Florianópolis");
    //     //     enderecoRepository.save(enderecoMotorista);
    //     //     Motoristas motorista = new Motoristas("Rafael", "489917717665", enderecoMotorista, "788995562");
    //     //     motoristasRepository.save(motorista);
    //     //     // Veículo
    //     //     Veiculos veiculo = new Veiculos("OZW-6777", "F-80", "2025", "Vermelha", "Ferrari");
    //     //     veiculosRepository.save(veiculo);

    //     // // Chamado
    //     // Chamados chamado = new Chamados(
    //     //     "Rio Grande do Sul",
    //     //     "Santa Catarina",
    //     //     "2025-06-23",
    //     //     "Uber X",
    //     //     1020.0,
    //     //     1028.3,
    //     //     "21:00",
    //     //     "21:20",
    //     //     27.0,
    //     //     veiculo, motorista, clienteObj
    //     // );

    //     // chamadosRepository.save(chamado);

    //     // return ResponseEntity.ok("Chamado criado com sucesso!");
    // }

    public  void createCorrida(){

                
        
    }

    public void buscaMotorista(){
        

    }


    @SuppressWarnings("unchecked")
    public static Object getNested(Map<String, Object> map, String... path) {
        Object current = map;
        for (String key : path) {
            if (!(current instanceof Map)) return null;
            current = ((Map<String, Object>) current).get(key);
        }
        return current;
    }
}


