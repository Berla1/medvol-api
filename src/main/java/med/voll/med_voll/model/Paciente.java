package med.voll.med_voll.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import med.voll.med_voll.dto.pacientes.PacienteDTO;

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

    public Long getId() {
        return id;
    }

    public Paciente setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Paciente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Paciente setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Paciente setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Paciente setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Paciente setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }
}
