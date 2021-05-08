package com.example.demo.service;


import com.example.demo.domains.Tarea;
import com.example.demo.dto.TareaDto;
import com.example.demo.repository.TareasRepository;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.utils.Utilitarios.convertToTarea;
import static com.example.demo.utils.Utilitarios.convertToTareaDto;


@Service
@Slf4j
public class TareaServices {
    @Autowired
    TareasRepository tareasRepository;

    public TareaDto addTarea(TareaDto dto) {
        log.info("Almacenando tarea con id: {}", dto.getIdentificador());
        TareaDto ent=null;
        try {
             ent = convertToTareaDto(tareasRepository.save(convertToTarea(dto)));
        }catch (Exception e){
            log.error("fallo el almacenamiento");
        }
        return ent;
    }

    @SneakyThrows
    public TareaDto editarTareas(TareaDto dto) {
        log.info("editando tarea con id: {}", dto.getIdentificador());
        if (tareasRepository.existsById(dto.getIdentificador())) {
            return convertToTareaDto(tareasRepository.save(convertToTarea(dto)));
        } else {
            log.error("No puede modificar una tarea con id:{} que no existe", dto.getIdentificador());
            throw new NotFoundException("No puede modificar una tarea que  no existe");
        }
    }


    public List<TareaDto> listarTareas() {
        log.info("obteniendo lista de tareas con id: {}");
        List<Tarea> listaTareas = tareasRepository.findAll();
        return listaTareas.stream().map(tarea -> convertToTareaDto(tarea)).collect(Collectors.toList());
    }

    @SneakyThrows
    public TareaDto getTarea(Integer identificador) {
        log.info("obteniendo tarea con id: {}", identificador);
        if (tareasRepository.existsById(identificador)) {
            Optional<Tarea> tarea = tareasRepository.findById(identificador);
            return tarea.map(task -> convertToTareaDto(task)).orElse(null);
        } else {
            log.error("No puede modificar una tarea con id:{} que no existe", identificador);
            throw new NotFoundException("No puede obtener una tarea que  no existe");
        }

    }

    public void deleteTareas(Integer identificador) {
        log.info("eliminando tarea con id: {}", identificador);
        tareasRepository.deleteById(identificador);
    }


}
