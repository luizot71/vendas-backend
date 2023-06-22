package com.getinfo.luizot.vendas.service;

import com.getinfo.luizot.vendas.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository clientesRepository;
    @Autowired
    public ClientesService(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

}
