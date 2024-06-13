package com.jpedro.schedule.repository;

import com.jpedro.schedule.model.especialidade.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {

}
