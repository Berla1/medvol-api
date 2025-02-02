package med.voll.med_voll.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.med_voll.dto.medicos.EspecialidadeDTO;
import med.voll.med_voll.dto.medicos.MedicoDTO;

@Entity
@Table(name = "medicos")
@AllArgsConstructor // Cria o construtor com todos os argumentos
@EqualsAndHashCode(of = "id") // Compara se tem campos duplicados com base no ID e gera o hash code com base no ID
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private EspecialidadeDTO especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public Medico() {
    }

    public Long getId() {
        return id;
    }

    public Medico setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Medico setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Medico setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Medico setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getCrm() {
        return crm;
    }

    public Medico setCrm(String crm) {
        this.crm = crm;
        return this;
    }

    public EspecialidadeDTO getEspecialidade() {
        return especialidade;
    }

    public Medico setEspecialidade(EspecialidadeDTO especialidade) {
        this.especialidade = especialidade;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Medico setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }
}