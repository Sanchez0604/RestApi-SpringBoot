package com.jpedro.schedule.service;

import com.jpedro.schedule.model.Administrador;
import com.jpedro.schedule.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador atualizarAdministrador(Long id, Administrador AdministradorAtualizado) {
        return administradorRepository.findById(id)
                .map(Administrador -> {
                    Administrador.setNome(AdministradorAtualizado.getNome());
                    Administrador.setCpf(AdministradorAtualizado.getCpf());
                    Administrador.setEmail(AdministradorAtualizado.getEmail());
                    Administrador.setSenha(AdministradorAtualizado.getSenha());
                    return administradorRepository.save(Administrador);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador não encontrado com ID: " + id));
    }
    public void deletarAdministrador(Long id) {administradorRepository.deleteById(id);
    }
}

