/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.service;

import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.Login;
import com.example.consultorio.admin.modelo.Persona;
import com.example.consultorio.admin.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    
    @Autowired
    private PersonaRepo personaRepo;
    

    public String login(Login login) throws UserException {
    Persona persona = personaRepo.findByUsername(login.getUsername());
    if (persona != null) {
        if (persona.getPassword().equals(login.getPassword())) {
            return persona.getRole();
        }
    }
    throw new UserException(HttpStatus.UNAUTHORIZED, "Error, Tus datos de inicio de sesión son inválidos", login.getUsername());

    

//    // Validar AdminSecundario
//    AdminSecundario adminSecundario = adminSecRepo.findByUsername(username);
//    if (adminSecundario != null) {
//        UserValidations.validateAdminSecundario(adminSecundario);
//        if (adminSecundario.getPassword().equals(password)) {
//            return adminSecundario.getRole();
//        } else {
//            throw new UserException(HttpStatus.UNAUTHORIZED, "Error, Tus datos de inicio de sesión son inválidos", login.getUsername());
//        }
//    }
//
//    // Validar Licenciado
//    Licenciado licenciado = licenciadoRepo.findByUsername(username);
//    if (licenciado != null) {
//        UserValidations.validateLicenciado(licenciado);
//        if (licenciado.getPassword().equals(password)) {
//            return licenciado.getRole();
//        } else {
//            throw new UserException(HttpStatus.UNAUTHORIZED, "Error, Tus datos de inicio de sesión son inválidos", login.getUsername());
//        }
//    }
//
//    // Validar Paciente
//    Paciente paciente = pacienteRepo.findByUsername(username);
//    if (paciente != null) {
//        UserValidations.validatePaciente(paciente);
//        if (paciente.getPassword().equals(password)) {
//            return paciente.getRole();
//        } else {
//            throw new UserException(HttpStatus.UNAUTHORIZED, "Error, Tus datos de inicio de sesión son inválidos", login.getUsername());
//        }
//    }
//
//    throw new UserException(HttpStatus.UNAUTHORIZED, "Error, Usuario no encontrado", username);
}
    
}
