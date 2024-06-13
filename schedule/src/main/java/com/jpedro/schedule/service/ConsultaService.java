package com.jpedro.schedule.service;

import com.jpedro.schedule.model.Consulta;
import com.jpedro.schedule.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta atualizarConsulta(Long id, Consulta consultaAtualizado) {
        return consultaRepository.findById(id)
                .map(Consulta -> {
                    Consulta.setDataHora(consultaAtualizado.getDataHora());
                    Consulta.setStatus(consultaAtualizado.getStatus());
                    Consulta.setDescricao(consultaAtualizado.getDescricao());
                    Consulta.setMedico(consultaAtualizado.getMedico());
                    Consulta.setPaciente(consultaAtualizado.getPaciente());
                    return consultaRepository.save(Consulta);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrado com ID: " + id));
    }
    public void deletarConsulta(Long id) {consultaRepository.deleteById(id);
    }
}

