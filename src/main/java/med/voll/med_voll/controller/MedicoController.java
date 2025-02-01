package med.voll.med_voll.controller;

import med.voll.med_voll.dto.MedicoDTO;
import med.voll.med_voll.model.Medico;
import med.voll.med_voll.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void cadastrarMedico(@RequestBody MedicoDTO dados){
        medicoRepository.save(new Medico(dados));
    }
}
