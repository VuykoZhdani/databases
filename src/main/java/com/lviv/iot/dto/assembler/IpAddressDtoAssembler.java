package com.lviv.iot.dto.assembler;

import com.lviv.iot.dto.IpAddressDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.lviv.iot.controller.IpAddressController;
import com.lviv.iot.domain.IpAddress;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IpAddressDtoAssembler implements RepresentationModelAssembler<IpAddress, IpAddressDto> {

    @Override
    public IpAddressDto toModel(IpAddress entity) {
        IpAddressDto ipAddressDto =IpAddressDto.builder()
                .id(entity.getId())
                .ipAddress(entity.getIpAddress())
                .build();
        Link selfLink = linkTo(methodOn(IpAddressController.class).getIpAddress(ipAddressDto.getId())).withSelfRel();
        ipAddressDto.add(selfLink);
        return ipAddressDto;
    }

    @Override
    public CollectionModel<IpAddressDto> toCollectionModel(Iterable<? extends IpAddress> entities) {
        CollectionModel<IpAddressDto> ipAddressDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(IpAddressController.class).getAllIpAddresses()).withSelfRel();
        ipAddressDtos.add(selfLink);
        return ipAddressDtos;
    }
}
