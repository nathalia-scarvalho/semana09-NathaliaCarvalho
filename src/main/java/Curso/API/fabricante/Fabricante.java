package Curso.API.fabricante;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fabricante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Fabricante(String nome) {
        this.nome = nome;
    }

    public static Fabricante criarOuObterFabricante(String nome, FabricanteRepository fabricanteRepository) {
        return fabricanteRepository.findByNome(nome)
                .orElseGet(() -> fabricanteRepository.save(new Fabricante(nome)));
    }
}
