package Curso.API.produto;

import Curso.API.fabricante.Fabricante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;

    @ManyToOne
    private Fabricante fabricante;

    public static Produto createFromDTO(ProdutoCadDTO produtoDTO, Fabricante fabricante) {
        Objects.requireNonNull(produtoDTO, "O DTO do produto não pode ser nulo");

        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setFabricante(fabricante);

        return produto;
    }
}

