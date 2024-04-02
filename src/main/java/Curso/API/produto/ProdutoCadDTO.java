package Curso.API.produto;

import Curso.API.fabricante.DadosFabricante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoCadDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private Double preco;

    @NotNull
    private DadosFabricante fabricante;
}