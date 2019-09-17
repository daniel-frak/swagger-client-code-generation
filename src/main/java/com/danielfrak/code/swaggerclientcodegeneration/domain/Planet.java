package com.danielfrak.code.swaggerclientcodegeneration.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(description = "A standard planet")
public class Planet {

    @ApiModelProperty("Uniquely identifies the planet")
    private final Long id;

    @ApiModelProperty("A human-readable name")
    private final String name;

    @ApiModelProperty("Whether or not life can survive on the surface")
    private final boolean isHabitable;

    public Planet(Long id, String name, boolean isHabitable) {
        this.id = id;
        this.name = name;
        this.isHabitable = isHabitable;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isHabitable() {
        return isHabitable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return isHabitable == planet.isHabitable &&
                Objects.equals(id, planet.id) &&
                Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, isHabitable);
    }
}
