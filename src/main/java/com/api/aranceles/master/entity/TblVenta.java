package com.api.aranceles.master.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TBL_VENTA", schema = "PAYMENTS")
public class TblVenta {
    @Id
    @Column(name = "VENTA_ID", nullable = false)
    @SequenceGenerator(name = "TBL_VENTA_SEQ", sequenceName = "SEQ_VENTA", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ALUMNO_ID", nullable = false)
    private TblAlumno alumno;

    @Column(name = "NOMBRE_CLIENTE", length = 60)
    private String nombreCliente;

    @Column(name = "DESCRIPCION", length = 128)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private TblUsuario usuario;

    @Column(name = "FECHA_VENTA")
    private LocalDate fechaVenta;

    @Column(name = "DESCUENTO", nullable = false, precision = 9, scale = 2)
    private BigDecimal descuento;

    @Column(name = "SUBTOTAL", nullable = false, precision = 9, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "IVA", nullable = false, precision = 9, scale = 2)
    private BigDecimal iva;

    @Column(name = "TOTAL", nullable = false, precision = 9, scale = 2)
    private BigDecimal total;

    @Column(name = "ESTADO", nullable = false)
    private Long estado;

}