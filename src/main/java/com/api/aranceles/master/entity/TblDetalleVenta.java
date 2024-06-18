package com.api.aranceles.master.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "TBL_DETALLE_VENTA", schema = "PAYMENTS")
public class TblDetalleVenta {
    @Id
    @Column(name = "DETALLE_VENTA_ID", nullable = false)
    @SequenceGenerator(name = "TBL_DETALLE_VENTA_SEQ", sequenceName = "SEQ_DETALLE_VENTA", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "VENTA_ID", nullable = false)
    private TblVenta venta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ARANCEL_ID", nullable = false)
    private TblArancel arancel;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "PRECIO", nullable = false, precision = 6, scale = 2)
    private BigDecimal precio;

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