/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.controller;

import com.example.consultorio.admin.exceptions.ErrorResponse;
import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.Licenciado;
import com.example.consultorio.admin.modelo.Persona;
import com.example.consultorio.admin.service.LicenciadoService;
import com.example.consultorio.admin.validations.UserValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/licenciados")
public class LicenciadoController {
    
    @Autowired
    private  LicenciadoService licenciadoService;
    
    @Autowired
    private UserValidation userValidation;
    
    
    @PostMapping("/licenciado/registro")
    public ResponseEntity<?> crearRegistroParcial(@Valid @RequestBody Persona persona) {
        try {
            // Realizar las validaciones necesarias antes de crear el registro parcial
            userValidation.validarCamposRegistroTerapeuta(persona);

            // Crear un objeto Persona con los campos proporcionados en el formulario
            Persona personaRegistrada = licenciadoService.crearRegistroParcial(persona);

            return ResponseEntity.ok(personaRegistrada);
        } catch (UserException e) {
            // Manejar la respuesta de error
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }
    
    
//    @PostMapping("/licenciado/registro")
//    public ResponseEntity<?> crearLicenciado(@Valid @RequestBody Licenciado licenciado) {
//       try {
//            // Realizar las validaciones necesarias antes de crear el AdminSecundario
//            userValidation.validarCamposComunes(licenciado);
//           
//            Licenciado nuevoLicenciado = licenciadoService.crearLicenciado(licenciado);
//            return ResponseEntity.ok(nuevoLicenciado);
//        } catch (UserException e) {
//            // Manejar la respuesta de error
//            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
//            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
//        }
//    }
    
    @PutMapping("/licenciado/editar/{idPer}")
    public ResponseEntity<?> editarLicenciado(@Valid @PathVariable Long idPer, @RequestBody Licenciado licenciado) {
        try {
        licenciado.setIdPer(idPer);
        Licenciado licenciadoEditado = licenciadoService.editarLicenciado(licenciado);
        return ResponseEntity.ok(licenciadoEditado);
    } catch (UserException e) {
        // Manejar la respuesta de error y devolver un ResponseEntity con el objeto ErrorResponse en el cuerpo
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
    }
    
    @DeleteMapping("/licenciado/eliminar/{idPer}")
    public ResponseEntity<?> eliminarLicenciado(@Valid @PathVariable Long idPer) {
        try {
        licenciadoService.eliminarLicenciado(idPer);
        return ResponseEntity.noContent().build();
    } catch (UserException e) {
        // Manejar la respuesta de error y devolver un ResponseEntity con el objeto ErrorResponse en el cuerpo
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
    }
    
    @DeleteMapping("/licenciado/eliminar/{nombre}")
    public ResponseEntity<?> eliminarLicenciadoPorNombre(@Valid @PathVariable String nombre) {
        try {
            licenciadoService.eliminarLicenciadoPorNombre(nombre);
            return ResponseEntity.noContent().build();
        } catch (UserException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }

    @DeleteMapping("/licenciado/eliminar/{email}")
    public ResponseEntity<?> eliminarLicenciadoEmail(@Valid @PathVariable String email) {
        try {
            licenciadoService.eliminarLicenciadoEmail(email);
            return ResponseEntity.noContent().build();
        } catch (UserException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }
    
    @DeleteMapping("/licenciado/eliminar/{dni}")
    public ResponseEntity<?> eliminarLicenciadoPorDni(@Valid @PathVariable String dni) {
        try {
            licenciadoService.eliminarLicenciadoPorDni(dni);
            return ResponseEntity.noContent().build();
        } catch (UserException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }
    
    @GetMapping("/licenciado/consultar/{idPer}")
    public ResponseEntity<?> consultarLicenciado(@Valid @PathVariable Long idPer) {
        try {
        Licenciado licenciado = licenciadoService.consultarLicenciado(idPer);
        return ResponseEntity.ok(licenciado);
    } catch (UserException e) {
        // Manejar la respuesta de error y devolver un ResponseEntity con el objeto ErrorResponse en el cuerpo
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
    
}
    
}
