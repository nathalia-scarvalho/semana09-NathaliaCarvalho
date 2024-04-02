package Curso.API.produto;
import Curso.API.fabricante.Fabricante;
import lombok.Data;

@Data
public class DadosCadProduto {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private Double preco;

    @NotBlank
    private Fabricante fabricante;
}