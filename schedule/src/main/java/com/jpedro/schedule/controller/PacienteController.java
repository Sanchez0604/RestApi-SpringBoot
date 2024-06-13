package com.jpedro.schedule.controller;

import com.jpedro.schedule.model.Paciente;
import com.jpedro.schedule.repository.PacienteRepository;
import com.jpedro.schedule.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente criar (@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    @GetMapping
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente pacienteAtualizado = pacienteService.atualizarPaciente(id, paciente);
        return ResponseEntity.ok(pacienteAtualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.ok().build();
    }
}


