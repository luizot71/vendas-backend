package com.getinfo.luizot.vendas.repository;

import com.getinfo.luizot.vendas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

}
