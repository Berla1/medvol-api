package med.voll.med_voll.dto.pacientes;

import med.voll.med_voll.model.Paciente;

public record ListagemPacienteDTO(String nome, String email, String cpf) {

    public ListagemPacienteDTO(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
