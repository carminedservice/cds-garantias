package com.cds.garantias.cds_Garantias.SNG.security.application.GenerateSecurity;

import com.cds.garantias.cds_Garantias.SNG.security.domain.valueObjects.SecurityPayload;
import com.cds.garantias.cds_Garantias.SNG.security.infrastructure.services.CryptoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GenerateSecurityUseCase {

    private final ObjectMapper objectMapper;
    private final CryptoService cryptoService;

    @Value("${security.key}")
    private String key;

    @Value("${security.username}")
    private String username;

    @Value("${security.password}")
    private String password;

    public GenerateSecurityUseCase(ObjectMapper objectMapper, CryptoService cryptoService) {
        this.objectMapper = objectMapper;
        this.cryptoService = cryptoService;
    }

    public GenerateSecurityResponse execute(GenerateSecurityRequest request) throws Exception {
        String preloadJson = objectMapper.writeValueAsString(request);
        String hash = cryptoService.sha256(preloadJson);

        SecurityPayload payload = new SecurityPayload(
                key,
                username,
                password,
                hash
        );
        String securityJson = objectMapper.writeValueAsString(payload);

        String encrypted = cryptoService.encryptWithPublicKey(securityJson);
        return new GenerateSecurityResponse(preloadJson, encrypted);
    }
}