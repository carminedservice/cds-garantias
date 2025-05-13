package com.cds.garantias.cds_Garantias.SNG.security.domain.valueObjects;

public class SecurityPayload {
    private long time;
    private String key;
    private String username;
    private String password;
    private String hash;

    public SecurityPayload(String key, String username, String password, String hash) {
        this.time = System.currentTimeMillis() / 1000;
        this.key = key;
        this.username = username;
        this.password = password;
        this.hash = hash;
    }

    public long getTime() {
        return time;
    }

    public String getKey() {
        return key;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHash() {
        return hash;
    }
}
