package med.voll.med_voll.controller;

import jakarta.validation.Valid;
import med.voll.med_voll.dto.MedicoDTO;
import med.voll.med_voll.dto.MedicoListagemDTO;
import med.voll.med_voll.model.Medico;
import med.voll.med_voll.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void cadastrarMedico(@RequestBody @Valid MedicoDTO dados){
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<MedicoListagemDTO> listarMedico(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return medicoRepository.findAll(paginacao).map(MedicoListagemDTO::new);
    }
}
