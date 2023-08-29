/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.controller;

import com.example.consultorio.admin.exceptions.ErrorResponse;
import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.Paciente;
import com.example.consultorio.admin.service.PacienteService;
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
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private PacienteService pacienteService;
    
    @Autowired
    private UserValidation userValidation;
    
    
     
    
    @PostMapping("/paciente/registro")
    public ResponseEntity<?> crearPaciente(@Valid @RequestBody Paciente paciente) {
        
         try {
            // Realizar las validaciones necesarias antes de crear el AdminSecundario
            userValidation.validarCamposComunes(paciente);

            Paciente nuevoPaciente = pacienteService.crearPaciente(paciente);
            return ResponseEntity.ok(nuevoPaciente);
        } catch (UserException e) {
            // Manejar la respuesta de error
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }
    
    @PutMapping("/paciente/editar/{idPer}")
    public ResponseEntity<?> editarPaciente(@Valid @PathVariable Long idPer, @RequestBody Paciente paciente)  {
        try {
        paciente.setIdPer(idPer);
        Paciente pacienteEditado = pacienteService.editarPaciente(paciente);
        return ResponseEntity.ok(pacienteEditado);
    } catch (UserException e) {
        // Manejar la respuesta de error y devolver un ResponseEntity con el objeto ErrorResponse en el cuerpo
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
    }
    
    @DeleteMapping("/paciente/eliminar/{idPer}")
    public ResponseEntity<?> eliminarPacientePorId(@Valid @PathVariable Long idPer)  {
        try {
        pacienteService.eliminarPacientePorId(idPer);
        return ResponseEntity.noContent().build();
    } catch (UserException e) {
        // Manejar la respuesta de error y devolver un ResponseEntity con el objeto ErrorResponse en el cuerpo
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
    }
    
    @DeleteMapping("/paciente/eliminar/{nombre}")
    public ResponseEntity<?> eliminarPacientePorNombre(@Valid @PathVariable String nombre) {
        try {
            pacienteService.eliminarPacientePorNombre(nombre);
            return ResponseEntity.noContent().build();
        } catch (UserException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }

    @DeleteMapping("/paciente/eliminar/{email}")
    public ResponseEntity<?> eliminarPacientePorEmail(@Valid @PathVariable String email) {
        try {
            pacienteService.eliminarPacientePorEmail(email);
            return ResponseEntity.noContent().build();
        } catch (UserException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }
    
    @DeleteMapping("/paciente/eliminar/{dni}")
    public ResponseEntity<?> eliminarPacientePorDni(@Valid @PathVariable String dni) {
        try {
            pacienteService.eliminarPacientePorDni(dni);
            return ResponseEntity.noContent().build();
        } catch (UserException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
        }
    }
    
//    @DeleteMapping("/paciente/eliminar")
//    public ResponseEntity<?> eliminarPorCriterios(@RequestParam(required = false) Long id,
//                                     @RequestParam(required = false) String nombre,
//                                     @RequestParam(required = false) String email,
//                                     @RequestParam(required = false) String dni) {
//        try {
//            pacienteService.eliminarPorCriterios(id, nombre, email, dni);
//            return ResponseEntity.noContent().build();
//        } catch (UserException e) {
//            ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
//            return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
//        }
//    }
    
    @GetMapping("/paciente/consultar/{idPer}")
    public ResponseEntity<?> consultarPaciente(@Valid @PathVariable Long idPer)  {
        try {
        Paciente paciente = pacienteService.consultarPaciente(idPer);
        return ResponseEntity.ok(paciente);
    } catch (UserException e) {
        // Manejar la respuesta de error y devolver un ResponseEntity con el objeto ErrorResponse en el cuerpo
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode(), e.getMessage(), e.getCausa());
        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
    }
    
    
}
    

