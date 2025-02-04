package med.voll.med_voll.dto.medicos;

import med.voll.med_voll.model.Endereco;
import med.voll.med_voll.model.Medico;

public record DetalhamentoMedicoDTO(Long id,
                                    String nome,
                                    String email,
                                    String crm,
                                    String telefone,
                                    EspecialidadeDTO especialidade,
                                    Endereco endereco) {

    public DetalhamentoMedicoDTO(Medico medico){
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }
}
