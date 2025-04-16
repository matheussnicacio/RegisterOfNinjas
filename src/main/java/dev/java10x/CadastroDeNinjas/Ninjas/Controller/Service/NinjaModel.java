package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Entity ele transforma uma classe em uma entidade do BD
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")

// Cria construtor noArgs
@NoArgsConstructor
// Cria construtor allArgs
@AllArgsConstructor
// Cria todos os GETTER e SETTERS
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Falar que essa coluna é unica no banco de dados
    @Column(unique = true)
    private String email;

    private int idade;

    // @ManyToOne - Um ninja tem apenas uma unica missao
    @ManyToOne
    // @JoinColumn - Junta duas colunas do banco de dados criando uma outra coluna
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira
    private MissoesModel missoes;


}
