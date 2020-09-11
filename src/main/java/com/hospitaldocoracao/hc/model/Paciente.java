package com.hospitaldocoracao.hc.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Paciente {

    @Id
    private Long cpf;

    @Column
    private String nomePaciente;

    @Column
    private String telefone;

    @Column
    private Boolean atendido;


}
