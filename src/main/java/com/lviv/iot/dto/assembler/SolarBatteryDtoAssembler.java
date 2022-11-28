package com.lviv.iot.dto.assembler;

import com.lviv.iot.dto.SolarBatteryDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.lviv.iot.controller.SolarBatteryController;
import com.lviv.iot.domain.SolarBattery;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class SolarBatteryDtoAssembler implements RepresentationModelAssembler<SolarBattery, SolarBatteryDto> {@Override
public SolarBatteryDto toModel(SolarBattery entity) {
    SolarBatteryDto solarBatteryDto = SolarBatteryDto.builder()
            .id(entity.getId())
            .ipAddressId(entity.getIpAddress().getId())
            .model(entity.getModel())
            .capacity(entity.getCapacity())
            .operatingTemperature(entity.getOperatingTemperature())
            .solarSystemId(entity.getSolarSystem().getId())
            .build();
    Link selfLink =
            linkTo(methodOn(SolarBatteryController.class).getSolarBattery(solarBatteryDto.getId())).withSelfRel();
    solarBatteryDto.add(selfLink);
    return solarBatteryDto;
}

    @Override
    public CollectionModel<SolarBatteryDto> toCollectionModel(Iterable<? extends SolarBattery> entities) {
        CollectionModel<SolarBatteryDto> solarBatteryDtos =
                RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SolarBatteryController.class).getAllSolarBatteries()).withSelfRel();
        solarBatteryDtos.add(selfLink);
        return solarBatteryDtos;
    }

    public CollectionModel<SolarBatteryDto> toCollectionModel(Iterable<? extends SolarBattery> entities, Link link) {
        CollectionModel<SolarBatteryDto> solarBatteryDtos =
                RepresentationModelAssembler.super.toCollectionModel(entities);
        solarBatteryDtos.add(link);
        return solarBatteryDtos;
    }
}
