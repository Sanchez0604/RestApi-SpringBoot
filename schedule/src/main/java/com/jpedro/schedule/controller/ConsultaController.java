package com.jpedro.schedule.controller;

import com.jpedro.schedule.model.Consulta;
import com.jpedro.schedule.repository.ConsultaRepository;
import com.jpedro.schedule.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public Consulta criar (@RequestBody Consulta consulta) {
        return consultaRepository.save(consulta);
    }
    @GetMapping
    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable Long id, @RequestBody Consulta Consulta) {
        Consulta consultaAtualizado = consultaService.atualizarConsulta(id, Consulta);
        return ResponseEntity.ok(consultaAtualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.ok().build();
    }
}