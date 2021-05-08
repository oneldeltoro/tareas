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
@Data
@NoArgsConstructor
@AllArgsConstructor
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


}
