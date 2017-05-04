package com.EnvironmentDashboardModule1.DTO;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
public class CreatingEarthquakeDto extends CreatingEventDto {
    protected Double mercaliDegree;
    protected Double richterDegree;
    protected Integer depth;

    public Double getMercaliDegree() {
        return mercaliDegree;
    }

    public void setMercaliDegree(Double mercaliDegree) {
        this.mercaliDegree = mercaliDegree;
    }

    public Double getRichterDegree() {
        return richterDegree;
    }

    public void setRichterDegree(Double richterDegree) {
        this.richterDegree = richterDegree;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }
}
