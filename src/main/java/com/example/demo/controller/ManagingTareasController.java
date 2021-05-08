package com.example.demo.controller;


import com.example.demo.dto.TareaDto;
import com.example.demo.service.TareaServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/tarea")
@Slf4j
@Api(value = "Microservicio Tarea", description = "Estas API garantizan la manipulacion de las tareas")
public class ManagingTareasController {
    @Autowired
    TareaServices tareaServices;

    @RequestMapping(value="/heartbeat",method = RequestMethod.GET)
    @ApiOperation(value = "Obtener estado de salud", notes = "Retorna un mensaje para comprobar el estado de salud del microservicio" )
    public ResponseEntity<String> heartbeat() {
        log.debug("obteniendo estado de salud del servicio");
        return ResponseEntity.ok("Microservicio Tarea esta en funcionamiento");
    }

    @RequestMapping(value="/all",method = RequestMethod.GET)
    @ApiOperation(value = "Obtener listado de tareas", notes = "Retorna una lista de tareas" )
    public ResponseEntity<List<TareaDto>> getAllTareas() {
        log.debug("invocando servicio para obtener listado de tareas");
        List<TareaDto> tareas = tareaServices.listarTareas();
        return new ResponseEntity(tareas, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "Obtener tarea", notes = "Retorna una tarea por Id" )
    public ResponseEntity<TareaDto> getTarea( @ApiParam(value = "ID de la tarea a buscar", required = true)
                                                  @PathVariable(name = "id") Integer identificador) {
        log.debug("invocando servicio para obtener una tarea");
        TareaDto tarea = tareaServices.getTarea(identificador);
        return new ResponseEntity(tarea, HttpStatus.OK);
    }

    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ApiOperation(value = "Guardar tarea", notes = "Almacena una tarea" )
    public ResponseEntity postTarea( @ApiParam(value = "Datos de la tarea a guardar", required = true)@RequestBody TareaDto tareaDto) {
        log.debug("invocando servicio para almacenar tarea");
        TareaDto stored = tareaServices.addTarea(tareaDto);
        return new ResponseEntity(stored, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.PUT)
    @ApiOperation(value = "Modificar tarea", notes = "Almacena una tarea modificada" )
    public ResponseEntity<TareaDto> putTarea( @ApiParam(value = "Datos de la tarea a actualizar", required = true)@RequestBody TareaDto tareaDto) {
        log.debug("invocando servicio para modificar una tarea");
        TareaDto stored = tareaServices.addTarea(tareaDto);
        return new ResponseEntity(stored, HttpStatus.OK);
    }


    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "Elimina una tarea", notes = "Elimina una tarea por Id" )
    public ResponseEntity deleteTarea(@ApiParam(value = "ID de la tarea a eliminar", required = true)
                                          @PathVariable(name = "id") Integer identificador) {
        log.debug("invocando servicio para eliminar una tarea");
        tareaServices.deleteTareas(identificador);
        return ResponseEntity.noContent().build();
    }


}
