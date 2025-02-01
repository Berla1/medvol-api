package med.voll.med_voll.model;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.med_voll.dto.EnderecoDTO;

@Getter // Cria todos os getters
@Setter // Cria todos os setters
@AllArgsConstructor // Cria o construtor com todos os argumentos
@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDTO dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    public Endereco(){}
}
