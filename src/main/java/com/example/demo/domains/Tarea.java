package com.example.demo.domains;

import io.swagger.annotations.ApiOperation;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 *
 */
@Entity
@Table(name = "tareas")
@EqualsAndHashCode
@Builder
@ApiOperation(value = "Tarea Modelo")
public class Tarea {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    Integer identificador;
    @NotBlank
    @Column
    String descripcion;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    Date fechaCreacio;
    @Column
    Boolean vigente;


    public Tarea() {

    }

    public Tarea(@NotBlank Integer identificador, @NotBlank String descripcion, Date fechaCreacio, Boolean vigente) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.fechaCreacio = fechaCreacio;
        this.vigente = vigente;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacio() {
        return fechaCreacio;
    }

    public void setFechaCreacio(Date fechaCreacio) {
        this.fechaCreacio = fechaCreacio;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }
}
