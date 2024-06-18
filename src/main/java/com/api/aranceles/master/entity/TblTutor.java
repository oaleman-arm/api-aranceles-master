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
@Table(name = "TBL_TUTOR", schema = "PAYMENTS")
public class TblTutor {
    @Id
    @Column(name = "TUTOR_ID", nullable = false)
    @SequenceGenerator(name = "TBL_TUTOR_SEQ", sequenceName = "SEQ_TUTOR", allocationSize = 1)
    private Long id;

    @Column(name = "APELLIDO", length = 60)
    private String apellido;

    @Column(name = "NOMBRE", length = 60)
    private String nombre;

    @Column(name = "DIRECCION", nullable = false, length = 400)
    private String direccion;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;

    @Column(name = "CORREO", length = 60)
    private String correo;

    @Column(name = "FECHA_REGISTRO")
    private LocalDate fechaRegistro;

    @Column(name = "ESTADO", nullable = false)
    private Long estado;

    @OneToMany(mappedBy = "tutor")
    private Set<TblAlumnoTutor> tblAlumnoTutors = new LinkedHashSet<>();

}