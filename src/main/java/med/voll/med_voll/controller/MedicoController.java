package med.voll.med_voll.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.med_voll.dto.medicos.MedicoAtualizarDTO;
import med.voll.med_voll.dto.medicos.MedicoDTO;
import med.voll.med_voll.dto.medicos.MedicoListagemDTO;
import med.voll.med_voll.model.Medico;
import med.voll.med_voll.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;

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
        return medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoListagemDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody  MedicoAtualizarDTO dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
