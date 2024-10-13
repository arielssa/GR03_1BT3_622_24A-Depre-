package com.agricultura.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "plantaciones")
public class Plantacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ubicacion;
    private double extension;
    private String producto;
    private String variedad;

    @Column(name = "etapa_actual")
    private String etapaActual;

    @Column(name = "fecha_cultivo")
    @Temporal(TemporalType.DATE)
    private Date fechaCultivo;

    @ManyToOne
    @JoinColumn(name = "agricultor_cedula")
    private Agricultor agricultor;

    @OneToMany(mappedBy = "plantacion", cascade = CascadeType.ALL)
    private Set<Etapa> etapas;

    @OneToMany(mappedBy = "plantacion", cascade = CascadeType.ALL)
    private Set<Insumo> insumos;

    // Getters y Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getExtension() {
        return extension;
    }

    public void setExtension(double extension) {
        this.extension = extension;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getEtapaActual() {
        return etapaActual;
    }

    public void setEtapaActual(String etapaActual) {
        this.etapaActual = etapaActual;
    }

    public Date getFechaCultivo() {
        return fechaCultivo;
    }

    public void setFechaCultivo(Date fechaCultivo) {
        this.fechaCultivo = fechaCultivo;
    }

    public Agricultor getAgricultor() {
        return agricultor;
    }

    public void setAgricultor(Agricultor agricultor) {
        this.agricultor = agricultor;
    }

    public Set<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(Set<Etapa> etapas) {
        this.etapas = etapas;
    }

    public Set<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(Set<Insumo> insumos) {
        this.insumos = insumos;
    }
}
