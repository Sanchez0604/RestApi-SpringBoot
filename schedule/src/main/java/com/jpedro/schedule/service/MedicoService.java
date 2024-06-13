package com.jpedro.schedule.service;

import jakarta.persistence.EntityManager;
import com.jpedro.schedule.model.Medico;
import com.jpedro.schedule.model.especialidade.Especialidade;
import com.jpedro.schedule.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.PersistenceContext;
import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Medico atualizarMedico(Long id, Medico medicoAtualizado) {
        return medicoRepository.findById(id)
                .map(medico -> {
                    medico.setNome(medicoAtualizado.getNome());
                    medico.setCrm(medicoAtualizado.getCrm());
                    medico.setHoras(medicoAtualizado.getHoras());
                    medico.setEspecialidadeId(medicoAtualizado.getEspecialidadeId());
                    return medicoRepository.save(medico);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado com ID: " + id));
    }

    @Transactional
    public void deletarMedico(Long id) {
        medicoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Especialidade> listarEspecialidades(Long id) {
        String jpql = "SELECT e FROM Especialidade e WHERE e.medicoId = :id";
        return entityManager.createQuery(jpql, Especialidade.class)
                .setParameter("id", id)
                .getResultList();
    }
}
