/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.controller;

import com.example.consultorio.admin.exceptions.ErrorResponse;
import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.AdminSecundario;
import com.example.consultorio.admin.service.AdminSecService;
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

@RequestMapping("/AdminSec")
public class AdminSecController {
    
    private  AdminSecService adminSecService;
    @Autowired
    private UserValidation userValidation;
    
    
    @PostMapping("/adminSec/registro")
    public ResponseEntity<AdminSecundario> crearAdminSec(@Valid @RequestBody AdminSecundario adminSecundario) {
       try {
            // Realizar las validaciones necesarias antes de crear el AdminSecundario
            userValidation.validarCamposComunes(adminSecundario);

            AdminSecundario nuevoAdminSec = adminSecService.crearAdminSec(adminSecundario);
            return ResponseEntity.ok(nuevoAdminSec);
        } catch (UserException e) {
            // Manejar la respuesta de error
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
    
    @PutMapping("/adminSec/editar/{idPer}")
    public ResponseEntity<?> editarAdminSec(@Valid @PathVariable Long idPer, @RequestBody AdminSecundario adminSecundario) {
        try {
        adminSecundario.setIdPer(idPer);
        AdminSecundario adminSecEditado = adminSecService.editarAdminSec(adminSecundario);
        return ResponseEntity.ok(adminSecEditado);
    } catch (UserException e) {
        // Manejar la respuesta de error y devolver un ResponseEntity con el objeto ErrorResponse en el cuerpo
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
    }
    
    @DeleteMapping("/adminSec/eliminar/{idPer}")
    public ResponseEntity<?> eliminarAdminSec(@Valid @PathVariable Long idPer) {
        try {
        adminSecService.eliminarAdminSec(idPer);
        return ResponseEntity.noContent().build();
    } catch (UserException e) {
        // Manejar la respuesta de error y devolver un ResponseEntity con el objeto ErrorResponse en el cuerpo
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
    }
    
    @DeleteMapping("/adminSec/eliminar/{nombre}")
    public ResponseEntity<?> eliminarAdminSecPorNombre(@Valid @PathVariable String nombre) {
        try {
            adminSecService.eliminarAdminSecPorNombre(nombre);
            return ResponseEntity.noContent().build();
        } catch (UserException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }

    @DeleteMapping("/adminSec/eliminar/{email}")
    public ResponseEntity<?> eeliminarAdminSecPorEmail(@Valid @PathVariable String email) {
        try {
            adminSecService.eeliminarAdminSecPorEmail(email);
            return ResponseEntity.noContent().build();
        } catch (UserException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }
    
    @DeleteMapping("/adminSec/eliminar/{dni}")
    public ResponseEntity<?> eliminarAdminSecPorDni(@Valid @PathVariable String dni) {
        try {
            adminSecService.eliminarAdminSecPorDni(dni);
            return ResponseEntity.noContent().build();
        } catch (UserException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }
    
    @GetMapping("/adminSec/consultar/{idPer}")
    public ResponseEntity<?> consultarAdminSec(@Valid @PathVariable Long idPer) {
        try {
        AdminSecundario adminSecundario = adminSecService.consultarAdminSec(idPer);
        return ResponseEntity.ok(adminSecundario);
    } catch (UserException e) {
        // Manejar la respuesta de error y devolver un ResponseEntity con el objeto ErrorResponse en el cuerpo
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
    }
    
}
