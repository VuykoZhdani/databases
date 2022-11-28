package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.SolarPanel;
import ua.lviv.iot.dto.ClientDto;
import ua.lviv.iot.dto.SolarPanelDto;
import ua.lviv.iot.dto.assembler.SolarPanelDtoAssembler;
import ua.lviv.iot.service.SolarPanelService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/solarPanels")
public class SolarPanelController {
    @Autowired
    private SolarPanelService solarPanelService;
    @Autowired
    private SolarPanelDtoAssembler solarPanelDtoAssembler;

    @GetMapping(value = "/{solarPanelId}")
    public ResponseEntity<SolarPanelDto> getSolarPanel(@PathVariable Integer solarPanelId) {
        SolarPanel solarPanel = solarPanelService.findById(solarPanelId);
        SolarPanelDto solarPanelDto = solarPanelDtoAssembler.toModel(solarPanel);
        return new ResponseEntity<>(solarPanelDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<SolarPanelDto>> getAllSolarPanels() {
        List<SolarPanel> solarPanels = solarPanelService.findAll();
        CollectionModel<SolarPanelDto> solarPanelDtos = solarPanelDtoAssembler.toCollectionModel(solarPanels);
        return new ResponseEntity<>(solarPanelDtos, HttpStatus.OK);
    }

    @GetMapping(value = "ipAddresses/{ipAddressId}")
    public ResponseEntity<CollectionModel<SolarPanelDto>> getSolarPanelsByIpAddressesId(@PathVariable Integer ipAddessId) {
        List<SolarPanel> solarPanels = solarPanelService.findSolarPanelsByIpAddressId(ipAddessId);
        Link selfLink =
                linkTo(methodOn(SolarPanelController.class).getSolarPanelsByIpAddressesId(ipAddessId)).withSelfRel();
        CollectionModel<SolarPanelDto> solarPanelDtos = solarPanelDtoAssembler.toCollectionModel(solarPanels, selfLink);
        return new ResponseEntity<>(solarPanelDtos, HttpStatus.OK);
    }
    @PostMapping(value = "/{ipAddressId}/{solarSystemId}")
    public ResponseEntity<SolarPanelDto> addSolarPanelWithIpAddressAndSolarSystem(@RequestBody SolarPanel solarPanel,
                                                              @PathVariable Integer ipAddressId,
                                                                              @PathVariable Integer solarSystemId) {
        SolarPanel newSolarPanel = solarPanelService.create(solarPanel, ipAddressId,solarSystemId);
        SolarPanelDto solarPanelDto = solarPanelDtoAssembler.toModel(newSolarPanel);
        return new ResponseEntity<>(solarPanelDto, HttpStatus.CREATED);
    }
    @PostMapping(value = "")
    public ResponseEntity<SolarPanelDto> addSolarPanel(@RequestBody SolarPanel solarPanel) {
        SolarPanel newSolarPanel = solarPanelService.create(solarPanel);
        SolarPanelDto solarPanelDto = solarPanelDtoAssembler.toModel(newSolarPanel);
        return new ResponseEntity<>(solarPanelDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{solarPanelId}")
    public ResponseEntity<?> updateSolarPanel(@RequestBody SolarPanel uSolarPanel,
                                               @PathVariable Integer solarPanelId) {
        solarPanelService.update(solarPanelId, uSolarPanel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{solarPanelId}")
    public ResponseEntity<?> deleteSolarPanel(@PathVariable Integer solarPanelId) {
        solarPanelService.delete(solarPanelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
