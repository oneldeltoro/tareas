package com.example.demo.assemblers;

import com.example.demo.controller.ManagingTareasController;
import com.example.demo.domains.Tarea;
import com.example.demo.model.dto.TareaDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/**
 * <p> "Escriba su texto aquí"</p>
 * Author: Onel Del Toro Rodríguez <a href="mailto>:onel.deltoro@datys.cu">onel.deltoro@datys.cu</a>
 */

public class TareaModeAssembler implements SimpleRepresentationModelAssembler<TareaDto> {
    @Override
    public void addLinks(EntityModel<TareaDto> resource) {
        resource.add(
                linkTo(methodOn(ManagingTareasController.class).getTarea(resource.getContent().getIdentificador())).withSelfRel()

        );

    }

    @Override
    public void addLinks(CollectionModel<EntityModel<TareaDto>> resources) {

    }
}
