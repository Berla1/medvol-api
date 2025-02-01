package med.voll.med_voll.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.med_voll.dto.EspecialidadeDTO;
import med.voll.med_voll.dto.MedicoDTO;

@Entity
@Table(name = "medicos")
@Getter // Cria todos os getters
@Setter // Cria todos os setters
@AllArgsConstructor // Cria o construtor com todos os argumentos
@EqualsAndHashCode(of = "id") // Compara se tem campos duplicados com base no ID e gera o hash code com base no ID
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    @Enumerated(EnumType.STRING)
    private EspecialidadeDTO especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public Medico() {
    }
}