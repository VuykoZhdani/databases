package com.lviv.iot.controller;

import com.lviv.iot.domain.SolarBattery;
import com.lviv.iot.dto.SolarBatteryDto;
import com.lviv.iot.dto.assembler.SolarBatteryDtoAssembler;
import com.lviv.iot.service.SolarBatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/api/solarBatteries")
public class SolarBatteryController {
    @Autowired
    private SolarBatteryService solarBatteryService;
    @Autowired
    private SolarBatteryDtoAssembler solarBatteryDtoAssembler;

    @GetMapping(value = "/{solarBatteryId}")
    public ResponseEntity<SolarBatteryDto> getSolarBattery(@PathVariable Integer solarBatteryId) {
        SolarBattery solarBattery = solarBatteryService.findById(solarBatteryId);
        SolarBatteryDto solarBatteryDto = solarBatteryDtoAssembler.toModel(solarBattery);
        return new ResponseEntity<>(solarBatteryDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<SolarBatteryDto>> getAllSolarBatteries() {
        List<SolarBattery> solarBatteries = solarBatteryService.findAll();
        CollectionModel<SolarBatteryDto> solarBatteryDtos = solarBatteryDtoAssembler.toCollectionModel(solarBatteries);
        return new ResponseEntity<>(solarBatteryDtos, HttpStatus.OK);
    }



    @PostMapping(value = "/{ipAddressId}/{solarSystemId}")
    public ResponseEntity<SolarBatteryDto> addSolarBatteryWithIpAddressAndSolarSystem(@RequestBody SolarBattery solarBattery,
                                                                                  @PathVariable Integer ipAddressId,
                                                                                  @PathVariable Integer solarSystemId) {
        SolarBattery newSolarBattery = solarBatteryService.create(solarBattery, ipAddressId,solarSystemId);
        SolarBatteryDto solarBatteryDto = solarBatteryDtoAssembler.toModel(newSolarBattery);
        return new ResponseEntity<>(solarBatteryDto, HttpStatus.CREATED);
    }


    @PutMapping(value = "/{solarBatteryId}/{ipAddressId}/{solarSystemId}")
    public ResponseEntity<?> updateSolarBatteryWithIpAddressAndSolarSystem(@RequestBody SolarBattery uSolarBattery,
                                                                         @PathVariable Integer solarBatteryId,
                                                                     @PathVariable Integer ipAddressId,
                                                                         @PathVariable Integer solarSystemId) {
        solarBatteryService.update( solarBatteryId,uSolarBattery,ipAddressId,solarSystemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{solarBatteryId}")
    public ResponseEntity<?> deleteSolarBattery(@PathVariable Integer solarBatteryId) {
        solarBatteryService.delete(solarBatteryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
