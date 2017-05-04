package com.EnvironmentDashboardModule1.models.Events;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
public class Earthquake extends Event {
    private Double richterDegree;

    private Double mercalliDegree;

    private Integer depth;

    public Double getRichterDegree() {
        return richterDegree;
    }

    public void setRichterDegree(Double richterDegree) {
        validateDegree(richterDegree);
        this.richterDegree = richterDegree;
    }

    public Double getMercalliDegree() {
        return mercalliDegree;
    }

    public void setMercalliDegree(Double mercalliDegree) {
        validateDegree(mercalliDegree);
        this.mercalliDegree = mercalliDegree;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        validateDepth(depth);
        this.depth = depth;
    }

    //Dragos -> validate richter and mercalli degree
    private void validateDegree(Double degreeValue) {
        if (degreeValue < 0){
            throw new IllegalArgumentException(Double.toString(degreeValue));
        }
    }

    //Dragos -> validate depth
    private void validateDepth(Integer depth) {
        if(depth < 0){
            throw new IllegalArgumentException(Integer.toString(depth));
        }
    }
}
