/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.validations;

import com.example.consultorio.admin.exceptions.DataIntegrityException;
import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.Persona;
import com.example.consultorio.admin.repository.PersonaRepo;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {
    
    @Autowired
    private PersonaRepo personaRepo;
    
    
    public void validarCamposRegistroTerapeuta(Persona persona) throws UserException {
        if (persona.getNombre().isEmpty() || persona.getApellido().isEmpty()
                || persona.getUsername().isEmpty() || persona.getPassword().isEmpty()) {
            throw new UserException(HttpStatus.BAD_REQUEST, "Por favor, completa los campos obligatorios antes de continuar.", "validarCamposRegistroTerapeuta");
        }
    }
    public void validarCamposOpcionales(Persona persona) throws UserException {
        validarDireccion(persona.getDireccion());
        validarTelefono(persona.getTelefono());
        validarDni(persona.getDni());
        validarEmail(persona.getEmail());
        validarUsername(persona.getUsername());
        validarPassword(persona.getPassword());
    }
    
//    public void validarCamposComunes(Persona persona) throws UserException {
////        validarNombre(persona.getNombre());
//        validarDireccion(persona.getDireccion());
//        validarTelefono(persona.getTelefono());
//        validarDni(persona.getDni());
//        validarEmail(persona.getEmail());
////        validarUsernameUnico(persona.getUsername());
////        validarUsername(persona.getUsername());
////        validarPassword(persona.getPassword());
//        validarCamposRegistro(persona);
//
//    }

    public void validarCamposRegistro(Persona persona) throws UserException {
        if (persona.getNombre().isEmpty() || persona.getApellido().isEmpty() || persona.getDireccion().isEmpty()
                || persona.getDni().isEmpty() || persona.getEmail().isEmpty() || persona.getPassword().isEmpty()
                || persona.getTelefono().isEmpty() || persona.getUsername().isEmpty()) {
            throw new UserException(HttpStatus.BAD_REQUEST, "Por favor, completa todos los campos obligatorios antes de continuar.", "validarCamposRegistro");
        }
    }

    public void validarNombre(String nombre) throws UserException {
        if (nombre == null) {
        throw new UserException(HttpStatus.BAD_REQUEST, "El nombre no puede ser nula.", "validarDireccion");
    }
        
        // Validación de caracteres permitidos (letras mayúsculas y minúsculas, y posiblemente espacios)
        if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El nombre contiene caracteres no permitidos.", "validar  caracteres permitidos,Nombre");
        }
        //Validar longitud
        if (nombre.length() < 4 || nombre.length() > 30) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El nombre debe tener entre 4 y 30 caracteres.", "validar longitud,Nombre");
        }

    }

    public void validarApellido(String apellido) throws UserException {
        if (apellido == null) {
        throw new UserException(HttpStatus.BAD_REQUEST, "El apellido no puede ser nula.", "validarDireccion");
    }
        // Validación de caracteres permitidos (letras mayúsculas y minúsculas, y posiblemente espacios)
        if (!apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El apellido contiene caracteres no permitidos.", "validar caracteres permitidos,Apellido");
        }

        if (apellido.length() < 4 || apellido.length() > 30) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El apellido debe tener entre 4 y 30 caracteres.", "validar longitud,Apellido");
        }
    }

    public void validarDireccion(String direccion) throws UserException {
    if (direccion == null) {
        throw new UserException(HttpStatus.BAD_REQUEST, "La dirección no puede ser nula.", "validarDireccion");
    }

    // Validación de longitud adecuada
    if (direccion.length() < 5 || direccion.length() > 100) {
        throw new UserException(HttpStatus.BAD_REQUEST, "La dirección debe tener entre 5 y 100 caracteres.", "validar longitu,Direccion");
    }

    // Validación de caracteres permitidos (letras, números, espacios y caracteres especiales)
    if (!direccion.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s\\-\\,\\.]+$")) {
        throw new UserException(HttpStatus.BAD_REQUEST, "La dirección contiene caracteres no permitidos.", "validar caracteres permitidos,Direccion");
    }
}

    public void validarTelefono(String telefono) throws UserException {
        if (telefono == null) {
        throw new UserException(HttpStatus.BAD_REQUEST, "El telefono no puede ser nula.", "validarDireccion");
    }
        
        // Validación de formato válido de número de teléfono
        if (!telefono.matches("^\\+?[0-9\\s-]+$")) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El formato del número de teléfono no es válido.", "validar formato,Telefono");
        }

        // Validación de longitud adecuada para números de teléfono
        if (telefono.replaceAll("[\\s-]", "").length() < 5 || telefono.replaceAll("[\\s-]", "").length() > 20) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El número de teléfono debe tener entre 5 y 20 dígitos.", "validar longitu,Telefono");
        }
    }

    public void validarDni(String dni) throws UserException {
        if (dni == null) {
        throw new UserException(HttpStatus.BAD_REQUEST, "El DNI no puede ser nulo.", "validarDireccion");
    }
        
        // Expresión regular para validar que el DNI contenga solo números y tenga exactamente 8 dígitos
        if (dni.length() != 8) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El DNI debe tener 8 caracteres.", "validar longitud y caracteres,DNI");
        }

        if (personaRepo.existsByDni(dni)) {
            throw new DataIntegrityException(HttpStatus.CONFLICT, "Ya existe un usuario con el mismo DNI.", "DataIntegrityException,DNI unico");
        }
        if (!dni.matches("^[0-9A-Za-z]+$")) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El formato del DNI no es válido.", "validar formato,DNI");
        }

    }

    public void validarEmail(String email) throws UserException {
        if (email == null) {
        throw new UserException(HttpStatus.BAD_REQUEST, "El Email no puede ser nulo.", "validarDireccion");
    }
        
        // Expresión regular para validar el email
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El formato de correo electrónico es inválido. Asegúrate de ingresar una dirección válida.", "validarEmail");
        }

        if (personaRepo.existsByEmail(email)) {
            throw new DataIntegrityException(HttpStatus.CONFLICT, "Ya existe un usuario con el mismo email.", "DataIntegrityException,Email unico");
        }
    }


    public void validarUsername(String username) throws UserException {
        if (username == null) {
        throw new UserException(HttpStatus.BAD_REQUEST, "El Username no puede ser nulo.", "validarDireccion");
    }
        
        
        // Validación de longitud mínima y máxima
        if (username.length() < 4 || username.length() > 20) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El nombre de usuario debe contener entre 4 y 20 caracteres.", "validar longitud Username");
        }
        // Validación de caracteres permitidos (letras, números, guiones bajos)
        if (!Pattern.matches("^[a-zA-Z0-9_]+$", username)) {
            throw new UserException(HttpStatus.BAD_REQUEST, "El nombre de usuario solo puede contener letras, números y guiones bajos.", "validar caracteres permitidos Username");
        }
        //validar username unico
        if (personaRepo.existsByUsername(username)) {
            throw new DataIntegrityException(HttpStatus.CONFLICT, "El usuario ya esta en uso.", "DataIntegrityException, username unico");
        }

    }

    public void validarPassword(String password) throws UserException {
        if (password == null) {
        throw new UserException(HttpStatus.BAD_REQUEST, "El contraseña no puede ser nulo.", "validarDireccion");
    }
        
        if (password.length() < 8 || password.length() > 30) {
            throw new UserException(HttpStatus.BAD_REQUEST, "La contraseña debe tener entre 8 y 30 caracteres.", "validar longitud,Password");
        }

        // Validación de caracteres especiales (al menos un símbolo)
        if (!Pattern.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*", password)) {
            throw new UserException(HttpStatus.BAD_REQUEST, "La contraseña debe contener al menos un carácter especial.", "validarPassword");
        }

        // Validación de letras mayúsculas y minúsculas
        if (!Pattern.matches(".*[a-z]+.*", password) || !Pattern.matches(".*[A-Z]+.*", password)) {
            throw new UserException(HttpStatus.BAD_REQUEST, "La contraseña debe contener al menos una letra mayúscula y una letra minúscula.", "validarPassword");
        }

        // Validación de números
        if (!Pattern.matches(".*[0-9]+.*", password)) {
            throw new UserException(HttpStatus.BAD_REQUEST, "La contraseña debe contener al menos un número.", "validarPassword");
        }
    }

//        // Comparación de contraseña y confirmación de contraseña
//        if (!contrasena.equals(confirmacionContrasena)) {
//            throw new UserException(HttpStatus.BAD_REQUEST, "La contraseña debe tener entre 8 y 30 caracteres.", "validarContrasena");
//        }
}
    
    
    
    

