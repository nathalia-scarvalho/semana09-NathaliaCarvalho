package Curso.API.produto;
import Curso.API.fabricante.FabricanteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private FabricanteDTO fabricante;

    public static ProdutoDTO fromProduto(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                FabricanteDTO.fromFabricante(produto.getFabricante())
        );
    }

    public static Page<ProdutoDTO> fromProdutoPage(Page<Produto> produto) {
        return produto.map(ProdutoDTO::fromProduto);
    }
}
