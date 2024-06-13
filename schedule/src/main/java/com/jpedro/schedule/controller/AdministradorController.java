package com.jpedro.schedule.controller;

import com.jpedro.schedule.model.Administrador;
import com.jpedro.schedule.repository.AdministradorRepository;
import com.jpedro.schedule.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public Administrador criar (@RequestBody Administrador Administrador) {
        return administradorRepository.save(Administrador);
    }
    @GetMapping
    public List<Administrador> listar() {
        return administradorRepository.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Administrador> atualizarAdministrador(@PathVariable Long id, @RequestBody Administrador Administrador) {
        Administrador AdministradorAtualizado = administradorService.atualizarAdministrador(id, Administrador);
        return ResponseEntity.ok(AdministradorAtualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAdministrador(@PathVariable Long id) {
        administradorService.deletarAdministrador(id);
        return ResponseEntity.ok().build();
    }
}