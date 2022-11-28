package com.lviv.iot.controller.many_to_many;

import com.lviv.iot.domain.many_to_many.SolarSystemClient;
import com.lviv.iot.dto.assembler.many_to_many.SolarSystemClientDtoAssembler;
import com.lviv.iot.dto.many_to_many.SolarSystemClientDto;
import com.lviv.iot.service.impl.StoredProceduresService;
import com.lviv.iot.service.many_to_many.SolarSystemClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solarSystemClient")
public class SolarSystemClientController {
    private final SolarSystemClientService solarSystemClientService;
    private final SolarSystemClientDtoAssembler solarSystemClientDtoAssembler;

    @Autowired
    private StoredProceduresService storedProceduresService;
    @Autowired
    public SolarSystemClientController(SolarSystemClientService solarSystemClientService,
                       SolarSystemClientDtoAssembler solarSystemClientDtoAssembler) {
        this.solarSystemClientService = solarSystemClientService;
        this.solarSystemClientDtoAssembler = solarSystemClientDtoAssembler;
    }

    @GetMapping("/")
    public CollectionModel<SolarSystemClientDto> getAllSolarSystemClient(){
        return solarSystemClientDtoAssembler.toCollectionModel(solarSystemClientService.findAll());
    }

    @GetMapping("/{id}")
    public CollectionModel<SolarSystemClientDto> getSolarSystemClientById(@PathVariable int id){
        return solarSystemClientDtoAssembler.toCollectionModel(solarSystemClientService.getSolarSystemClientByClientId(id));
    }

    @PostMapping("/")
    public SolarSystemClientDto createSolarSystemClient(@RequestBody SolarSystemClient solarSystemClient){
        return solarSystemClientDtoAssembler.toModel(solarSystemClientService.create(solarSystemClient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSolarSystemClient(@PathVariable int id,
                                                 @RequestBody SolarSystemClient solarSystemClient){
        solarSystemClientService.update(id, solarSystemClient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSolarSystemClient(@PathVariable int id){
        solarSystemClientService.delete(id);
    }


    @PostMapping(value = "/insert-into/solar-system-client")
    public ResponseEntity<String> insertIntoSolarSystemClient(@RequestBody SolarSystemClientDto solarSystemClientDto) {
        return new ResponseEntity<>(solarSystemClientService.insertIntoSolarSystemClient(
                solarSystemClientDto.getSolarSystemId(), solarSystemClientDto.getClientSurname()), HttpStatus.OK);
    }
}

