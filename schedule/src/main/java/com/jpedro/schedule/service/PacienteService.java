package com.jpedro.schedule.service;

import com.jpedro.schedule.model.Paciente;
import com.jpedro.schedule.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente atualizarPaciente(Long id, Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNome(pacienteAtualizado.getNome());
                    paciente.setCpf(pacienteAtualizado.getCpf());
                    paciente.setEmail(pacienteAtualizado.getEmail());
                    paciente.setSenha(pacienteAtualizado.getSenha());
                    return pacienteRepository.save(paciente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado com ID: " + id));
    }
    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}

