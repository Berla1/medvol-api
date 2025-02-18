package med.voll.med_voll.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.med_voll.dto.medicos.DetalhamentoMedicoDTO;
import med.voll.med_voll.dto.medicos.MedicoAtualizarDTO;
import med.voll.med_voll.dto.medicos.MedicoDTO;
import med.voll.med_voll.dto.medicos.MedicoListagemDTO;
import med.voll.med_voll.model.Medico;
import med.voll.med_voll.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity cadastrarMedico(@RequestBody @Valid MedicoDTO dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        medicoRepository.save(medico);
        // devolve o codigo 201(created)
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoMedicoDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoListagemDTO>> listarMedico(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoListagemDTO::new);
        return ResponseEntity.ok(page); // devolve 200
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoMedicoDTO(medico)); // devolve o código 204(no content), ao inves do 200
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody  MedicoAtualizarDTO dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        // devolve o corpo da requisição com os dados atualizados, metodo 200
        return ResponseEntity.ok(new DetalhamentoMedicoDTO(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build(); // devolve o código 204(no content), ao inves do 200
    }
}
