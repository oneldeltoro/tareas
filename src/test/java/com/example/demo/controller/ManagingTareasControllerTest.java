package com.example.demo.controller;


import com.example.demo.dto.TareaDto;
import com.example.demo.repository.TareasRepository;
import com.example.demo.service.TareaServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ManagingTareasControllerTest {
    @MockBean
    private TareaServices service;
    @MockBean
    private TareasRepository repository;

    @Test
    void getAllTareas() {
        List<TareaDto> tasks = generarTareas();
        Mockito.when(service.listarTareas()).thenReturn(generarTareas());
        assertThat(tasks.size(), is(1));
    }

    @Test
    void getTarea() {
        TareaDto task = generarTarea();
        Mockito.when(service.getTarea(Mockito.any())).thenReturn(task);
        assertThat(task.getIdentificador(), notNullValue());
    }

    @Test
    void postTarea() {
        TareaDto task = generarTarea();
        Mockito.when(service.addTarea(Mockito.any())).thenReturn(task);
        assertThat(task.getDescripcion(), notNullValue());
        assertThat(task.getFechaCreacio(), notNullValue());
        assertThat(task.getIdentificador(), notNullValue());
        assertThat(task.getVigente(), notNullValue());
    }

    @Test
    void putTarea() {
        TareaDto task = generarTarea();
        Mockito.when(service.addTarea(Mockito.any())).thenReturn(task);
        assertThat(task.getDescripcion(), notNullValue());
        assertThat(task.getFechaCreacio(), notNullValue());
        assertThat(task.getIdentificador(), notNullValue());
        assertThat(task.getVigente(), notNullValue());
    }

    @Test
    void deleteTarea() {
        TareaDto task = generarTarea();
        TareaServices mockImpl = mock(TareaServices.class);
        doNothing().when(mockImpl).deleteTareas(Mockito.any());
        mockImpl.deleteTareas(Mockito.any());
        verify(mockImpl, atLeastOnce()).deleteTareas(Mockito.any());


    }

    private List<TareaDto> generarTareas() {
        return Arrays.asList(generarTarea());
    }

    private TareaDto generarTarea() {
        TareaDto tarea = TareaDto.builder().identificador(123).descripcion("tarea test").fechaCreacio(new Date()).vigente(true).build();
        return tarea;
    }
}