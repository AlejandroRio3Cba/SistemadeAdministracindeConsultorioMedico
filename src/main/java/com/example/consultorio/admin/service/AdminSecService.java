/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.service;

import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.AdminSecundario;
import com.example.consultorio.admin.repository.AdminSecRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminSecService {
    
    @Autowired
    private AdminSecRepo adminSecRepo;
    
    public AdminSecundario crearAdminSec(AdminSecundario adminSecundario) throws UserException{
        try {
            return adminSecRepo.save(adminSecundario);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el Admin Secundario. Por favor, inténtalo de nuevo más tarde.", "crearAdminSec");
        }
       
    }
    
    
    
    public void eliminarAdminSec(Long idPer) throws UserException{
        try {
            adminSecRepo.deleteById(idPer);
        } catch (Exception e) {
           throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el Admin Secundario. Por favor, inténtalo de nuevo más tarde.", "eliminarAdminSec");
        }
    }
    
    public void eliminarAdminSecPorNombre(String nombre) throws UserException{
        try {
            adminSecRepo.deleteByNombre(nombre);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.", "eliminarPaciente");
        }
    }
    
    
    
    public void eeliminarAdminSecPorEmail(String email) throws UserException{
        try {
            adminSecRepo.deleteByEmail(email);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.", "eliminarPaciente");
        }
    }
    
    public void eliminarAdminSecPorDni(String dni) throws UserException{
        try {
            adminSecRepo.deleteByDni(dni);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.", "eliminarPaciente");
        }
    }
    
    public AdminSecundario consultarAdminSec(Long idPer) throws UserException{
        try {
            return adminSecRepo.findById(idPer).orElse(null);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al consultar el Admin Secundario. Por favor, inténtalo de nuevo más tarde.", "consultarAdminSec");
        }
        
    }
    
    public AdminSecundario editarAdminSec(AdminSecundario idPer) throws UserException{
        try {
            return adminSecRepo.save(idPer);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al editar el Admin Secundario. Por favor, inténtalo de nuevo más tarde.", "editarAdminSec");
        }
        
    }
    
}
