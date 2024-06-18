package com.api.aranceles.master.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TBL_ALUMNO_TUTOR", schema = "PAYMENTS")
public class TblAlumnoTutor {
    @Id
    @Column(name = "ALUMNO_TUTOR_ID", nullable = false)
    @SequenceGenerator(name = "TBL_ALUMNO_TUTOR_SEQ", sequenceName = "SEQ_ALUMNO_TUTOR", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ALUMNO_ID", nullable = false)
    private TblAlumno alumno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "TUTOR_ID", nullable = false)
    private TblTutor tutor;

    @Column(name = "FECHA_REGISTRO")
    private LocalDate fechaRegistro;

    @Column(name = "ESTADO", nullable = false)
    private Long estado;

}