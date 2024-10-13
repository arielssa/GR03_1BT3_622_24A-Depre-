package com.agricultura.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "etapas")
public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String etapa;

    @Column(name = "fecha_cambio")
    @Temporal(TemporalType.DATE)
    private Date fechaCambio;

    private String observacion;

    @ManyToOne
    @JoinColumn(name = "plantacion_id")
    private Plantacion plantacion;

    // Getters y Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Plantacion getPlantacion() {
        return plantacion;
    }

    public void setPlantacion(Plantacion plantacion) {
        this.plantacion = plantacion;
    }
}
