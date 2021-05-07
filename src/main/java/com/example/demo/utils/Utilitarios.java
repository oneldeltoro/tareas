package com.example.demo.utils;

import com.example.demo.domains.Tarea;
import com.example.demo.model.dto.TareaDto;
import com.google.common.base.Preconditions;
import org.springframework.util.ObjectUtils;

public class Utilitarios {
    private Utilitarios() {
        throw new IllegalAccessError("Utility class");
    }

    public static Tarea convertToTarea(TareaDto elemDto) {
        Preconditions.checkArgument(elemDto.getIdentificador() == null, "La tarea no puede contener campos vacíos o nulos");
        Preconditions.checkArgument(elemDto.getDescripcion() == null, "La tarea no puede contener campos vacíos o nulos");
        Preconditions.checkArgument(elemDto.getVigente() == null, "La tarea no puede contener campos vacíos o nulos");
        return Tarea.builder()
                .identificador(ObjectUtils.isEmpty(elemDto.getIdentificador()) ? null : elemDto.getIdentificador())
                .descripcion(ObjectUtils.isEmpty(elemDto.getDescripcion()) ? null : elemDto.getDescripcion())
                .descripcion(ObjectUtils.isEmpty(elemDto.getDescripcion()) ? null : elemDto.getDescripcion())
                .vigente(ObjectUtils.isEmpty(elemDto.getVigente()) ? null : elemDto.getVigente())
                .build();
    }

    public static TareaDto convertToTareaDto(Tarea elem) {
        return TareaDto.builder()
                .identificador(ObjectUtils.isEmpty(elem.getIdentificador()) ? null : elem.getIdentificador())
                .descripcion(ObjectUtils.isEmpty(elem.getDescripcion()) ? null : elem.getDescripcion())
                .descripcion(ObjectUtils.isEmpty(elem.getDescripcion()) ? null : elem.getDescripcion())
                .vigente(ObjectUtils.isEmpty(elem.getVigente()) ? null : elem.getVigente())
                .build();
    }
}
