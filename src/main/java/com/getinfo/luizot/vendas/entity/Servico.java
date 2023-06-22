package com.getinfo.luizot.vendas.entity;

import javax.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column
    private BigDecimal valor;
}
