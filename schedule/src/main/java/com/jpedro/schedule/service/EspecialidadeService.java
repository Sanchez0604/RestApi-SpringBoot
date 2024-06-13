package com.jpedro.schedule.service;


import com.jpedro.schedule.model.especialidade.Especialidade;
import com.jpedro.schedule.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public Especialidade atualizarEspecialidade(Long id, Especialidade especialidadeAtualizado) {
        return especialidadeRepository.findById(id)
                .map(especialidade -> {
                    especialidade.setNome(especialidadeAtualizado.getNome());
                    especialidade.setDescricao(especialidadeAtualizado.getDescricao());
                    return especialidadeRepository.save(especialidade);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "especialidade não encontrado com ID: " + id));
    }
    public void deletarEspecialidade(Long id) {especialidadeRepository.deleteById(id);
    }
}

