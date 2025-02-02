package med.voll.med_voll.controller;

import jakarta.validation.Valid;
import med.voll.med_voll.dto.PacienteDTO;
import med.voll.med_voll.model.Paciente;
import med.voll.med_voll.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;


    @PostMapping

    public void cadastrarPaciente(@RequestBody @Valid PacienteDTO dados) {
        pacienteRepository.save(new Paciente(dados));
    }
}
