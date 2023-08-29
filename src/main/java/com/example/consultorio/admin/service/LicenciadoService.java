/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.service;

import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.Licenciado;
import com.example.consultorio.admin.modelo.Persona;
import com.example.consultorio.admin.repository.LicenciadoRepo;
import com.example.consultorio.admin.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LicenciadoService {
    
    @Autowired
    private LicenciadoRepo licenciadoRepo;
    
    @Autowired
    private PersonaRepo personaRepo;
    
    
    public Persona crearRegistroParcial(Persona persona) throws UserException {
        try {
            // Crear y guardar el registro parcial en la base de datos
            return personaRepo.save(persona);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el registro parcial. Por favor, inténtalo de nuevo más tarde.", "crearRegistroParcial");
        }
    }
    
    
    
//    public Licenciado crearLicenciado(Licenciado licenciado) throws UserException{
//        try {
//            return licenciadoRepo.save(licenciado);
//        } catch (Exception e) {
//           throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el licenciado. Por favor, inténtalo de nuevo más tarde.", "crearLicenciado");
//        }
//        
//    }
    
    
    
    public void eliminarLicenciado(Long idPer) throws UserException{
        try {
            licenciadoRepo.deleteById(idPer);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el licenciado. Por favor, inténtalo de nuevo más tarde.", "eliminarLicenciado");
        }
    }
    
    public void eliminarLicenciadoPorNombre(String nombre) throws UserException{
        try {
            licenciadoRepo.deleteByNombre(nombre);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.", "eliminarPaciente");
        }
    }
    
    
    
    public void eliminarLicenciadoEmail(String email) throws UserException{
        try {
            licenciadoRepo.deleteByEmail(email);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.", "eliminarPaciente");
        }
    }
    
    public void eliminarLicenciadoPorDni(String dni) throws UserException{
        try {
            licenciadoRepo.deleteByDni(dni);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.", "eliminarPaciente");
        }
    }
    
    public Licenciado consultarLicenciado(Long idPer) throws UserException{
        try {
            return licenciadoRepo.findById(idPer).orElse(null);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al consultar el licenciado. Por favor, inténtalo de nuevo más tarde.", "consultarLicenciado");
        }
       
    }
    
    public Licenciado editarLicenciado(Licenciado idPer) throws UserException{
        try {
            return licenciadoRepo.save(idPer);
        } catch (Exception e) {
           throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al editar el licenciado. Por favor, inténtalo de nuevo más tarde.", "editarLicenciado");
        }
        
    }
    
}
