package com.cds.garantias.cds_Garantias.SNG.security.infrastructure.api.controllers;

import com.cds.garantias.cds_Garantias.SNG.security.application.GenerateSecurity.GenerateSecurityRequest;
import com.cds.garantias.cds_Garantias.SNG.security.application.GenerateSecurity.GenerateSecurityResponse;
import com.cds.garantias.cds_Garantias.SNG.security.application.GenerateSecurity.GenerateSecurityUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/garantias/sng")
public class GarantiasSNGController {

    private final GenerateSecurityUseCase useCase;

    public GarantiasSNGController(GenerateSecurityUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/generate-security")
    public ResponseEntity<GenerateSecurityResponse> generate(@RequestBody GenerateSecurityRequest request) {
        try {
            GenerateSecurityResponse response = useCase.execute(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

}
