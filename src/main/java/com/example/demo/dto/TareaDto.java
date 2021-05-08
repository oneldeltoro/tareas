package com.example.demo.dto;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiOperation(value = "Tarea Modelo DTO")
public class TareaDto {
    Integer identificador;
    String descripcion;
    Date fechaCreacio;
    Boolean vigente;
}
