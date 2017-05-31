package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;

import com.EnvironmentDashboardModule1.models.Events.TerroristAttack;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;

/**
 * Created by daioanei on 5/4/2017.
 */

public class TerroristAttackBuilder extends EventBuilder{

    private Integer numberOfTerrorists;

    public TerroristAttackBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public TerroristAttackBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public TerroristAttackBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public TerroristAttackBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public TerroristAttackBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public TerroristAttackBuilder setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }

    public TerroristAttackBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public TerroristAttackBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public TerroristAttackBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public TerroristAttackBuilder setNumberOfTerrorists(Integer numberOfTerrorists) {
        validateNonNegativeValue(numberOfTerrorists);
        this.numberOfTerrorists = numberOfTerrorists;
        return this;
    }

    public TerroristAttackBuilder setUserId(String userId) {
        validateString(userId);
        this.userId = userId;
        return this;
    }

    public TerroristAttack getTerroristAttack(){
        TerroristAttack terroristAttack = new TerroristAttack();

        terroristAttack.setUserId(userId);
        terroristAttack.setLatitude(latitude);
        terroristAttack.setLongitude(longitude);
        terroristAttack.setDescription(description);
        terroristAttack.setEndingTime(endingTime);
        terroristAttack.setHints(hints);
        terroristAttack.setName(name);
        terroristAttack.setRadius(radius);
        terroristAttack.setSeverity(severity);
        terroristAttack.setStartingTime(startingTime);
        terroristAttack.setNumberOfTerrorists(numberOfTerrorists);

        return terroristAttack;
    }

}
