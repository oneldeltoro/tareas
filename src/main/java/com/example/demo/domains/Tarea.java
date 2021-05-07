package com.example.demo.domains;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
