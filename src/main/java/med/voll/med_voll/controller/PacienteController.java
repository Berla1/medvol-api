package med.voll.med_voll.controller;

import jakarta.validation.Valid;
import med.voll.med_voll.dto.pacientes.ListagemPacienteDTO;
import med.voll.med_voll.dto.pacientes.PacienteDTO;
import med.voll.med_voll.model.Paciente;
import med.voll.med_voll.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;


    @PostMapping

    public void cadastrarPaciente(@RequestBody @Valid PacienteDTO dados) {
        pacienteRepository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<ListagemPacienteDTO> listarPaciente(Pageable paginacao){
        return pacienteRepository.findAll(paginacao).map(ListagemPacienteDTO::new);
    }
}
