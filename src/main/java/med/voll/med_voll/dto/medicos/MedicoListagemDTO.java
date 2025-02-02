package med.voll.med_voll.dto.medicos;

import med.voll.med_voll.model.Medico;

public record MedicoListagemDTO(Long id, String nome, String email, String crm, EspecialidadeDTO especialidade) {

    public MedicoListagemDTO(Medico medico){
        this(medico.getId() ,medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
