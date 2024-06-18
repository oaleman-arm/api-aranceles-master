package com.api.aranceles.master.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TBL_ALUMNO", schema = "PAYMENTS")
public class TblAlumno {
    @Id
    @Column(name = "ALUMNO_ID", nullable = false)
    @SequenceGenerator(name = "TBL_ALUMNO_SEQ", sequenceName = "SEQ_ALUMNO", allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO_ALUMNO", nullable = false, length = 60)
    private String codigoAlumno;

    @Column(name = "APELLIDO", nullable = false, length = 60)
    private String apellido;

    @Column(name = "NOMBRE", nullable = false, length = 60)
    private String nombre;

    @Column(name = "FECHA_REGISTRO")
    private LocalDate fechaRegistro;

    @Column(name = "ESTADO", nullable = false)
    private Long estado;

    @OneToMany(mappedBy = "alumno")
    private Set<TblAlumnoTutor> tblAlumnoTutors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "alumno")
    private Set<TblVenta> tblVentas = new LinkedHashSet<>();

}