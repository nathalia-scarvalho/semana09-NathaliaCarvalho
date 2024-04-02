package Curso.API.fabricante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FabricanteDTO {

    private Long id;
    private String nome;

    public static FabricanteDTO fromFabricante(Fabricante fabricante) {
        return new FabricanteDTO(
                fabricante.getId(),
                fabricante.getNome()
        );
    }
}
