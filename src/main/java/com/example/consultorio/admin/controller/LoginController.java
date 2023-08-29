/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.controller;

import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.Login;
import com.example.consultorio.admin.service.LoginService;
import com.example.consultorio.admin.validations.LoginValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    @Autowired
    private LoginValidation loginValidation;
    
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody Login login) {
        try {
            loginValidation.validarCampos(login);
            loginValidation.validarUsername(login);
            loginValidation.validarUsuarioExistente(login);
            loginValidation.validarPassword(login);

            String role = loginService.login(login);
           switch (role) {
                case "ADMIN":
                    return ResponseEntity.ok("Bienvenido, eres un ADMIN");
                case "ADMIN_SECUNDARIO":
                    return ResponseEntity.ok("Bienvenido, eres un ADMIN SECUNDARIO");
                case "PACIENTE":
                    return ResponseEntity.ok("Bienvenido, eres un PACIENTE");
                case "LICENCIADO":
                    return ResponseEntity.ok("Bienvenido, eres un LICENCIADO");
                default:
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error, tus datos de inicio de sesión son inválidos");
            }
        } catch (UserException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }

        
    }
    
}
