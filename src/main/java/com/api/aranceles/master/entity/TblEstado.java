package com.api.aranceles.master.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TBL_ESTADO", schema = "PAYMENTS")
public class TblEstado {
    @Id
    @Column(name = "ESTADO_ID", nullable = false)
    @SequenceGenerator(name = "TBL_ESTADO_SEQ", sequenceName = "SEQ_ESTADO", allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO_ESTADO", nullable = false)
    private Long codigoEstado;

    @Column(name = "NOMBRE_ESTADO", length = 60)
    private String nombreEstado;

    @Column(name = "FECHA_REGISTRO")
    private LocalDate fechaRegistro;

    @ColumnDefault("'1'")
    @Column(name = "ESTADO", nullable = false)
    private Boolean estado = false;

}