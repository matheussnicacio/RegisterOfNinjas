package dev.java10x.CadastroDeNinjas.Ninjas;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Entity ele transforma uma classe em uma entidade do BD
// JPA = Java Persistence API
@Entity

// Cria tabela
@Table(name = "tb_cadastro")
// Junta várias funcionalidades em uma só. Quando você coloca @Data em cima de uma classe, o Lombok automaticamente gera
@Data
// Cria construtor noArgs
@NoArgsConstructor
// Cria construtor allArgs
@AllArgsConstructor
// Gera o método toString()
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @Column (name = "nome")
    private String nome;

    // Falar que essa coluna é unica no banco de dados
    @Column(unique = true)
    private String email;

    @Column (name = "img_url")
    private String imgUrl;

    @Column (name = "rank")
    private String rank;

    @Column (name = "idade")
    private int idade;

    // @ManyToOne - Um ninja tem apenas uma unica missao
    @ManyToOne
    // @JoinColumn - Junta duas colunas do banco de dados criando uma outra coluna
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira
    private MissoesModel missoes;

}