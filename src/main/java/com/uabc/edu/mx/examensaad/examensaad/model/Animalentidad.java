package com.uabc.edu.mx.examensaad.examensaad.model;

import javax.persistence.*;

@Entity
@Table(name="animal")
public class Animalentidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tipo")
    private String tipo;

    @Column(name="raza")
    private String raza;

    @Column(name="color")
    private String color;

    @Column(name="tipo_pelaje")
    private String tipo_pelaje;

    @Column(name="f_nacimiento")
    private String f_nacimiento;

    @Column(name="vacunas")
    private String vacunas;

    @Column(name="estado")
    private String estado;

    @Column(name="responsable")
    private String responsable;

    @Column(name="foto")
    private String foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo_pelaje() {
        return tipo_pelaje;
    }

    public void setTipo_pelaje(String tipo_pelaje) {
        this.tipo_pelaje = tipo_pelaje;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Animalentidad [id=" + id + ", tipo=" + tipo +
                ", raza=" + raza + ", color=" + color   + ", tipo_pelaje=" + tipo_pelaje + ", f_nacimiento=" + f_nacimiento +
                ", vacunas=" + vacunas + ", estado=" + estado + ", responsable=" + responsable +
                ", foto=" + foto + "]";
    }
}
