package med.voll.med_voll.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}") // Indica que são 8 digitos que compoe o campo
        String cep,
        String cidade,
        @NotBlank
        String uf,
        String numero,
        String complemento) {

    @Override
    public String toString() {
        return  "Logradouro: " + logradouro + "\n" +
                " Bairro: " + bairro + "\n" +
                " CEP: " + cep + "\n" +
                " Cidade: " + cidade + "\n" +
                " UF: " + uf + "\n" +
                " Número: " + numero + "\n" +
                " Complemento: " + complemento + "\n" +
                "------------------------------"
                ;
    }
}
