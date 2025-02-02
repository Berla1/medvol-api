package med.voll.med_voll.dto.medicos;

import jakarta.validation.constraints.NotNull;
import med.voll.med_voll.dto.EnderecoDTO;

public record MedicoAtualizarDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
