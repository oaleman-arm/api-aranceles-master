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
@Table(name = "TBL_ARANCEL", schema = "PAYMENTS")
public class TblArancel {
    @Id
    @Column(name = "ARANCEL_ID", nullable = false)
    @SequenceGenerator(name = "TBL_ARANCEL_SEQ", sequenceName = "SEQ_ARANCEL", allocationSize = 1)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 60)
    private String nombre;

    @Column(name = "PRECIO")
    private Double precio;

    @Column(name = "OPCIONAL")
    private Boolean opcional;

    @Column(name = "FECHA_REGISTRO")
    private LocalDate fechaRegistro;

    @Column(name = "ESTADO", nullable = false)
    private Long estado;

    @OneToMany(mappedBy = "arancel")
    private Set<TblDetalleVenta> tblDetalleVentas = new LinkedHashSet<>();

}