package com.EnvironmentDashboardModule1.models;

import javax.persistence.*;

/**
 * Created by Luca Andrei on 5/3/2017.
 */

public class Location {
    private Double latitude;

    private Double longitude;

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
