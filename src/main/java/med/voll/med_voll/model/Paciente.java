package med.voll.med_voll.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import med.voll.med_voll.dto.PacienteDTO;

@Entity
@Table(name = "pacientes")
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded
    private Endereco endereco;

    public Paciente(PacienteDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public Paciente() {
    }
}
