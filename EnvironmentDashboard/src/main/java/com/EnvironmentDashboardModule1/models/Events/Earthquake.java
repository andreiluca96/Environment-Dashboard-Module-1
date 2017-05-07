package com.EnvironmentDashboardModule1.models.Events;

import javax.persistence.Entity;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
public class Earthquake extends Event {
    private Double richterDegree;

    private Double mercalliDegree;

    private Integer depth;

    public Double getRichterDegree() {
        return this.richterDegree;
    }

    public void setRichterDegree(Double richterDegree) {
        validateNonNegativeValue(richterDegree);
        this.richterDegree = richterDegree;
    }

    public Double getMercalliDegree() {
        return this.mercalliDegree;
    }

    public void setMercalliDegree(Double mercalliDegree) {
        validateNonNegativeValue(mercalliDegree);
        this.mercalliDegree = mercalliDegree;
    }

    public Integer getDepth() {
        return this.depth;
    }

    public void setDepth(Integer depth) {
        validateNonNegativeValue(depth);
        this.depth = depth;
    }

}
