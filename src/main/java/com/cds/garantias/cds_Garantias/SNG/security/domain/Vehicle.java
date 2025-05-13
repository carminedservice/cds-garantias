package com.cds.garantias.cds_Garantias.SNG.security.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Vehicle {

    @JsonProperty("Plate")
    private String plate;

    @JsonProperty("Year")
    private int year;

    @JsonProperty("DatePlate")
    private String datePlate;

    @JsonProperty("SaleDate")
    private String saleDate;

    @JsonProperty("SaleTime")
    private String saleTime;

    @JsonProperty("ConstructorWarrantyEnd")
    private String constructorWarrantyEnd;

    @JsonProperty("Brand")
    private String brand;

    @JsonProperty("Model")
    private String model;

    @JsonProperty("VIN")
    private String vin;

    @JsonProperty("KW")
    private int kw;

    @JsonProperty("FuelType")
    private int fuelType;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("TotalKmToDate")
    private String totalKmToDate;

    @JsonProperty("Displacement")
    private int displacement;

    @JsonProperty("KmBetweenMaintenance")
    private String kmBetweenMaintenance;

    @JsonProperty("MonthsBetweenMaintenance")
    private String monthsBetweenMaintenance;

    @JsonProperty("RealKm")
    private String realKm;

    @JsonProperty("CarriesOver5People")
    private boolean carriesOver5People;

    @JsonProperty("HasAutomaticGearbox")
    private boolean hasAutomaticGearbox;

    @JsonProperty("HasTurbo")
    private boolean hasTurbo;

    @JsonProperty("Is4x4")
    private boolean is4x4;

    @JsonProperty("IsCommercial")
    private boolean isCommercial;
    
    @Override
    public String toString() {
        return "Vehicle{" +
                "plate='" + plate + '\'' +
                ", year=" + year +
                ", datePlate='" + datePlate + '\'' +
                ", saleDate='" + saleDate + '\'' +
                ", saleTime='" + saleTime + '\'' +
                ", constructorWarrantyEnd='" + constructorWarrantyEnd + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", kw=" + kw +
                ", fuelType=" + fuelType +
                ", type='" + type + '\'' +
                ", totalKmToDate='" + totalKmToDate + '\'' +
                ", displacement=" + displacement +
                ", kmBetweenMaintenance='" + kmBetweenMaintenance + '\'' +
                ", monthsBetweenMaintenance='" + monthsBetweenMaintenance + '\'' +
                ", realKm='" + realKm + '\'' +
                ", carriesOver5People=" + carriesOver5People +
                ", hasAutomaticGearbox=" + hasAutomaticGearbox +
                ", hasTurbo=" + hasTurbo +
                ", is4x4=" + is4x4 +
                ", isCommercial=" + isCommercial +
                '}';
    }
}
