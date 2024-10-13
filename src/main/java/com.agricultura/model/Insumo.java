package com.agricultura.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "insumos")
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipo;
    private String nombre;

    @Column(name = "cantidad_utilizada")
    private double cantidadUtilizada;

    @Column(name = "fecha_aplicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAplicacion;

    private String proveedor;

    @Column(name = "lote_o_numero_serie")
    private String loteONumeroSerie;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(double cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getLoteONumeroSerie() {
        return loteONumeroSerie;
    }

    public void setLoteONumeroSerie(String loteONumeroSerie) {
        this.loteONumeroSerie = loteONumeroSerie;
    }

    public Plantacion getPlantacion() {
        return plantacion;
    }

    public void setPlantacion(Plantacion plantacion) {
        this.plantacion = plantacion;
    }
}
