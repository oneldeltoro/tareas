package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TareaDto {
    Integer identificador;
    String descripcion;
    Date fechaCreacio;
    Boolean vigente;
}
