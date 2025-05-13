package com.cds.garantias.cds_Garantias.SNG.security.application.GenerateSecurity;

import com.cds.garantias.cds_Garantias.SNG.security.domain.Vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerateSecurityRequest {
    @JsonProperty("Vehicle")
    private Vehicle vehicle;


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
