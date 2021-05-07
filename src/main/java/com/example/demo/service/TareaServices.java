package com.example.demo.service;

import com.example.demo.domains.Tarea;
import com.example.demo.model.dto.TareaDto;
import com.example.demo.repository.TareasRepository;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.utils.Utilitarios.convertToTarea;
import static com.example.demo.utils.Utilitarios.convertToTareaDto;

/**
 * <p> "Escriba su texto aquí"</p>
 * Author: Onel Del Toro Rodríguez <a href="mailto>:onel.deltoro@datys.cu">onel.deltoro@datys.cu</a>
 */

@Service
public class TareaServices {
    @Autowired
    TareasRepository tareasRepository;

    public TareaDto addTarea(TareaDto dto) {
        return convertToTareaDto(tareasRepository.save(convertToTarea(dto)));
    }

    @SneakyThrows
    public TareaDto editarTareas(TareaDto dto) {
        if (tareasRepository.existsById(dto.getIdentificador())) {
            return convertToTareaDto(tareasRepository.save(convertToTarea(dto)));
        } else
            throw new NotFoundException("No puede modificar una tarea que  no existe");
    }

    public List<TareaDto> listarTareas() {
        List<Tarea> listaTareas = tareasRepository.findAll();
        return listaTareas.stream().map(tarea -> convertToTareaDto(tarea)).collect(Collectors.toList());
    }

    @SneakyThrows
    public TareaDto getTarea(Integer identificador) {
        if (tareasRepository.existsById(identificador)) {
            Optional<Tarea> tarea = tareasRepository.findById(identificador);
            return tarea.map(task -> convertToTareaDto(task)).orElse(null);
        } else
            throw new NotFoundException("No puede obtener una tarea que no existe");

    }

    public void deleteTareas(Integer identificador) {
        tareasRepository.deleteById(identificador);
    }


}
