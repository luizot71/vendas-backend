package com.getinfo.luizot.vendas.controller;

import com.getinfo.luizot.vendas.entity.Cliente;
import com.getinfo.luizot.vendas.repository.ClientesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
@CrossOrigin("http://localhost:4200")
public class ClientesController {
    private final ClientesRepository repository;
    @Autowired
    public ClientesController(ClientesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> obterTodos() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@Valid @RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente clientById(@PathVariable Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable Integer id) {
        repository
                .findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return  Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateClientById(@PathVariable Integer id, @Valid @RequestBody Cliente clienteAtualizado) {
        repository
                .findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setCpf(clienteAtualizado.getCpf());
                    return repository.save(cliente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

}
