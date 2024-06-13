package com.jpedro.schedule.controller;

import com.jpedro.schedule.model.Medico;
import com.jpedro.schedule.model.especialidade.Especialidade;
import com.jpedro.schedule.repository.MedicoRepository;
import com.jpedro.schedule.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public Medico criar (@RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }
    @GetMapping
    public List<Medico> listar() {
        return medicoRepository.findAll();
    }
    @GetMapping("{medicoId}/especialidades")
    public List<Especialidade> listarEspecialidade(@PathVariable Long medicoId) {
        List<Especialidade> especialidades = medicoService.listarEspecialidades(medicoId);
        return especialidades;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizarMedico(@PathVariable Long id, @RequestBody Medico medico) {
        Medico medicoAtualizado = medicoService.atualizarMedico(id, medico);
        return ResponseEntity.ok(medicoAtualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.ok().build();
    }
}


