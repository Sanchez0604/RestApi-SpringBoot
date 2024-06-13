package com.jpedro.schedule.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String crm;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "medico_horas", joinColumns = @JoinColumn(name = "medico_id"))
    @Column(name = "hora")
    private List<LocalTime> horas;

    private List<Long> especialidadeId;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<LocalTime> getHoras() {
        return horas;
    }

    public void setHoras(List<LocalTime> horas) {
        this.horas = horas;
    }

    public List<Long> getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(Long especialidadeId) {
        this.especialidadeId.add(especialidadeId);
    }
}
