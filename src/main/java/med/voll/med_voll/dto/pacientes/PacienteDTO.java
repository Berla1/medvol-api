package med.voll.med_voll.dto.pacientes;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import med.voll.med_voll.dto.EnderecoDTO;

public record PacienteDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone,
        EnderecoDTO endereco
) {
}
