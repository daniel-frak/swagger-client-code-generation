package com.danielfrak.code.swaggerclientcodegeneration.controllers;

import com.danielfrak.code.swaggerclientcodegeneration.domain.Planet;
import com.danielfrak.code.swaggerclientcodegeneration.domain.PlanetRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Planets")
@RestController
@RequestMapping("planets")
public class PlanetController {

    private final PlanetRepository repository;

    public PlanetController(PlanetRepository repository) {
        this.repository = repository;
    }

    @ApiOperation("Returns a list of all available planets")
    @GetMapping
    public ResponseEntity<List<Planet>> findAllPlanets() {
        return ResponseEntity.ok(repository.findAll());
    }

    @ApiOperation("Returns information about a particular planet")
    @GetMapping("{id}")
    public ResponseEntity<Planet> findPlanet(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
