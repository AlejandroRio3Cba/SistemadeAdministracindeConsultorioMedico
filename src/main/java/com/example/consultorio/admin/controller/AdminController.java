/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.controller;

import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.Admin;
import com.example.consultorio.admin.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private  AdminService adminService;
    
    
    
    @PutMapping("/{Id}/editar")
    public ResponseEntity<Admin> editarAdmin(@Valid @PathVariable Long id, @RequestBody Admin admin) throws UserException {
        admin.setIdPer(id);
        Admin adminEditado = adminService.editarAdmin(admin);
        if (adminEditado != null) {
            return ResponseEntity.ok(adminEditado);
        } else {
            // Manejar la respuesta de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    
    @GetMapping("/{Id}/consultar")
    public ResponseEntity<Admin> consultarAdmin(@Valid @PathVariable Long id) throws UserException {
        Admin admin = adminService.consultarAdmin(id);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            // Manejar la respuesta de error
            return ResponseEntity.notFound().build();
        }
    }
    
}
