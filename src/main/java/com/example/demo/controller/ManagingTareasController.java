package com.example.demo.controller;

import com.example.demo.assemblers.TareaModeAssembler;
import com.example.demo.model.dto.TareaDto;
import com.example.demo.service.TareaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/v1/tarea", produces = MediaTypes.HAL_JSON_VALUE)
public class ManagingTareasController {
    @Autowired
    TareaServices tareaServices;

    @Autowired(required=true)
    private TareaModeAssembler tareaModeAssembler;


    @GetMapping("/all")
    public ResponseEntity<List<EntityModel<TareaDto>>> getAllTareas() {
        List<TareaDto> tareas = tareaServices.listarTareas();
        return new ResponseEntity(tareas.stream()
                .map(gateway -> tareaModeAssembler.toModel(gateway))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<TareaDto>> getTarea(@PathVariable(name = "id") Integer identificador) {
        TareaDto tarea = tareaServices.getTarea(identificador);
        return ResponseEntity.ok(tareaModeAssembler.toModel(tarea));
    }

    @PostMapping()
    public ResponseEntity postTarea(@RequestBody TareaDto tareaDto) {
        TareaDto stored = tareaServices.addTarea(tareaDto);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stored.getIdentificador()).toUri())
                .build();
    }

    @PutMapping()
    public ResponseEntity<EntityModel<TareaDto>> putTarea(@RequestBody TareaDto tareaDto) {
        TareaDto stored = tareaServices.addTarea(tareaDto);
        return ResponseEntity.ok(tareaModeAssembler.toModel(stored));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTarea(@PathVariable(name = "id") Integer identificador) {
        tareaServices.deleteTareas(identificador);
        return ResponseEntity.noContent().build();
    }


}
