package com.cds.garantias.cds_Garantias.SNG.security.application.GenerateSecurity;

public class GenerateSecurityResponse {
    private String preload;
    private String security;

    public GenerateSecurityResponse(String preload, String security) {
        this.preload = preload;
        this.security = security;
    }

    public String getPreload() {
        return preload;
    }

    public String getSecurity() {
        return security;
    }
}