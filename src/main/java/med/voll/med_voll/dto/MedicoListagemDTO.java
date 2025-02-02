package med.voll.med_voll.dto;

import med.voll.med_voll.model.Medico;

public record MedicoListagemDTO(String nome, String email, String crm, EspecialidadeDTO especialidade) {

    public MedicoListagemDTO(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
