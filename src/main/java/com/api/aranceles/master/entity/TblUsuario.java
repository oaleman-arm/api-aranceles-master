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
@Table(name = "TBL_USUARIO", schema = "PAYMENTS")
public class TblUsuario {
    @Id
    @Column(name = "USUARIO_ID", nullable = false)
    @SequenceGenerator(name = "TBL_USUARIO_SEQ", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    private Long id;

    @Column(name = "APELLIDO", nullable = false, length = 60)
    private String apellido;

    @Column(name = "NOMBRE", nullable = false, length = 60)
    private String nombre;

    @Column(name = "DIRECCION", nullable = false, length = 400)
    private String direccion;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;

    @Column(name = "CORREO", length = 60)
    private String correo;

    @Column(name = "NOMBRE_USUARIO", nullable = false, length = 60)
    private String nombreUsuario;

    @Column(name = "PASSWORD", nullable = false, length = 60)
    private String password;

    @Column(name = "FECHA_REGISTRO")
    private LocalDate fechaRegistro;

    @Column(name = "ESTADO", nullable = false)
    private Long estado;

    @OneToMany(mappedBy = "usuario")
    private Set<TblVenta> tblVentas = new LinkedHashSet<>();

}