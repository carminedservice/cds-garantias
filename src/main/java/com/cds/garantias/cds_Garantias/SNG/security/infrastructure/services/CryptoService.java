package com.cds.garantias.cds_Garantias.SNG.security.infrastructure.services;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.util.Base64;

@Service
public class CryptoService {
    private final PublicKeyLoader publicKeyLoader;

    public CryptoService(PublicKeyLoader publicKeyLoader) {
        this.publicKeyLoader = publicKeyLoader;
    }

    public String sha256(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String encryptWithPublicKey(String data) throws Exception {

        PublicKey publicKey = publicKeyLoader.loadPublicKey();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
