package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    private CityService service;

    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(){
        List<CityDTO> cityDTOList = service.findAll();
        return ResponseEntity.ok(cityDTOList);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
