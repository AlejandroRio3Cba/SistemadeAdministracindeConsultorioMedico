/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.validations;

import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.Login;
import com.example.consultorio.admin.modelo.Persona;
import com.example.consultorio.admin.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class LoginValidation {
    
    @Autowired
    private PersonaRepo personaRepo;

   public void validarCampos(Login login) throws UserException {
        if (login.getUsername().isEmpty() || login.getPassword().isEmpty()) {
            throw new UserException(HttpStatus.BAD_REQUEST, "Debes completar todos los campos.", "validarCampos");
        }
    }

    public void validarUsername(Login login) throws UserException {
        String username = login.getUsername();
        // Validación de longitud adecuada
        if (username.length() < 4 || username.length() > 20) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El usuario debe tener entre 4 y 20 caracteres.", "validarCampos");
            
        }

        // Validación de caracteres permitidos (letras, números, guiones bajos)
        if (!username.matches("^[a-zA-Z0-9_]+$")) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El usuario contiene caracteres no permitidos.", "validarCampos");
            
        }
    }

    public void validarUsuarioExistente(Login login) throws UserException {
        Persona persona = personaRepo.findByUsername(login.getUsername());
        if (persona == null) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El usuario no existe.", "validarUsuarioExistente");
        }
    }

    public void validarPassword(Login login) throws UserException {
        Persona persona = personaRepo.findByUsername(login.getUsername());
        if (persona == null || !persona.getPassword().equals(login.getPassword())) {
            throw new UserException(HttpStatus.BAD_REQUEST, "Contraseña incorrecta.", "validarPassword");
        }
    }
    
    
}
// falta validar password caracteres 