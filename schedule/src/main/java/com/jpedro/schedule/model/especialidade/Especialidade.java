package com.jpedro.schedule.model.especialidade;
import com.jpedro.schedule.model.Medico;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    private List<Long> medicoId;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Long> getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(List<Long> medicoId) {
        this.medicoId = medicoId;
    }
}
