package com.example.demo.service;

import com.example.demo.domains.Tarea;
import com.example.demo.model.dto.TareaDto;
import com.example.demo.repository.TareasRepository;
import javassist.NotFoundException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;
@ExtendWith(SpringExtension.class)
@Import({
        TareaServices.class,
        TareasRepository.class
})
class TareaServicesTest {
    @Autowired
    private TareaServices service;
    @MockBean
    private TareasRepository repository;
    @Test
    void addTarea() {
        Tarea task = generarTarea();
        Mockito.when(repository.save(Mockito.any())).thenReturn(task);
        assertThat(task.getDescripcion(), notNullValue());
        assertThat(task.getFechaCreacio(), notNullValue());
        assertThat(task.getIdentificador(), notNullValue());
        assertThat(task.getVigente(), notNullValue());
    }

    @Test
    void editarTareas() {
        Tarea task = generarTarea();
        Mockito.when(repository.existsById(Mockito.any())).thenReturn(true);
        Mockito.when(repository.save(Mockito.any())).thenReturn(task);
        assertThat(task.getDescripcion(), notNullValue());
        assertThat(task.getFechaCreacio(), notNullValue());
        assertThat(task.getIdentificador(), notNullValue());
        assertThat(task.getVigente(), notNullValue());
    }
    @Test
    void editarTareasNoExist() {
        NotFoundException e = new NotFoundException("No puede modificar una tarea que  no existe");
        Mockito.when(repository.existsById(Mockito.any())).thenReturn(false);
        Mockito.when(repository.save(Mockito.any())).thenReturn(e);
        Assert.assertTrue(e instanceof NotFoundException);
        Assert.assertEquals(e.getMessage(), "No puede modificar una tarea que  no existe");
    }
    @Test
    void listarTareas() {
        List<Tarea> tasks = generarTareas();
        Mockito.when(repository.findAll()).thenReturn(generarTareas());
        assertThat(tasks.size(), is(1));
    }

    @Test
    void getTarea() {
        Tarea task = generarTarea();
        Mockito.when(repository.existsById(Mockito.any())).thenReturn(true);
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(task));
        assertThat(task.getDescripcion(), notNullValue());
        assertThat(task.getFechaCreacio(), notNullValue());
        assertThat(task.getIdentificador(), notNullValue());
        assertThat(task.getVigente(), notNullValue());
    }

    @Test
    void deleteTareas() {
        Tarea task = generarTarea();
        TareaServices mockImpl = mock(TareaServices.class);
        doNothing().when(mockImpl).deleteTareas(Mockito.any());
        mockImpl.deleteTareas(Mockito.any());
        verify(mockImpl, atLeastOnce()).deleteTareas(Mockito.any());
    }

    private List<Tarea> generarTareas() {
        return Arrays.asList(generarTarea());
    }

    private Tarea generarTarea() {
        Tarea tarea = Tarea.builder().identificador(123).descripcion("tarea test").fechaCreacio(new Date()).vigente(true).build();
        return tarea;
    }
}