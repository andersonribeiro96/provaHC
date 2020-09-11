package com.hospitaldocoracao.hc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idAtendimento;

    @Column
    private String descricao;

    @Column
    private String sintomas;

    @OneToOne
    private Paciente paciente;

    @Column
    private String nomeMedico;

    @Column
    private String crm;

}
