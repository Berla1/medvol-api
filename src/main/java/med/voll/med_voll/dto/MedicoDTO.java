package med.voll.med_voll.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(
        @NotBlank // representa que nao pode ser vazio, nem null, so funciona para campos String
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // o "\\d" indica que são digitos e o "4,6" indica que são de 4 a 6 digitos
        String crm,
        @NotNull
        EspecialidadeDTO especialidade,
        @NotNull
        @Valid
        EnderecoDTO endereco) {

    @Override
    public String toString() {
        return
                "------------------------------\n" +
                "Nome: " + nome + "\n" +
                "Email: " + email + "\n" +
                "CRM: " + crm + "\n" +
                "Especialidade: " + especialidade + "\n" +
                "\nEndereço:\n " + endereco;
    }
}
