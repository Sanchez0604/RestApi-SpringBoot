package com.jpedro.schedule.controller;

import com.jpedro.schedule.model.especialidade.Especialidade;
import com.jpedro.schedule.repository.EspecialidadeRepository;
import com.jpedro.schedule.repository.EspecialidadeRepository;
import com.jpedro.schedule.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;
    @Autowired
    private EspecialidadeService especialidadeService;


    @PostMapping
    public Especialidade criar (@RequestBody Especialidade Especialidade) {
        return especialidadeRepository.save(Especialidade);
    }
    @GetMapping
    public List<Especialidade> listar() {
        return especialidadeRepository.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Especialidade> atualizarEspecialidade(@PathVariable Long id, @RequestBody Especialidade Especialidade) {
        Especialidade EspecialidadeAtualizado = especialidadeService.atualizarEspecialidade(id, Especialidade);
        return ResponseEntity.ok(EspecialidadeAtualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEspecialidade(@PathVariable Long id) {
        especialidadeService.deletarEspecialidade(id);
        return ResponseEntity.ok().build();
    }
}


