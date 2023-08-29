/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.service;

import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.Admin;
import com.example.consultorio.admin.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepo adminRepo;
    

    
    public void eliminarAdmin(Long id)  throws UserException{
        try {
            adminRepo.deleteById(id);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el paciente. Por favor, inténtalo de nuevo más tarde.", "crearPaciente");
        }
    }
    
    
    
    public Admin consultarAdmin(Long id) throws UserException{
        try {
            return adminRepo.findById(id).orElse(null);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el paciente. Por favor, inténtalo de nuevo más tarde.", "crearPaciente");
        }
        
    }
    
    public Admin editarAdmin(Admin admin) throws UserException{
        try {
            return adminRepo.save(admin);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el paciente. Por favor, inténtalo de nuevo más tarde.", "crearPaciente");
        }
        
    }
    
}
