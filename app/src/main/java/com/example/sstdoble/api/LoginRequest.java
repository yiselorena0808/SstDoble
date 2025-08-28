package com.example.sstdoble.api;

public class LoginRequest {
    private String correo_electronico;
    private String contrasena;

    public LoginRequest(String correo, String password) {
        this.correo_electronico = correo;
        this.contrasena = password;
    }

    public String getCorreo() {
        return correo_electronico;
    }

    public String getPassword() {
        return contrasena;
    }
}
