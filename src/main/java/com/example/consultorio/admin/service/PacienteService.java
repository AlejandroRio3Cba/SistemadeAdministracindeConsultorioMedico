/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.service;

import com.example.consultorio.admin.exceptions.UserException;
import com.example.consultorio.admin.modelo.Paciente;
import com.example.consultorio.admin.repository.PacienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepo pacienteRepo;
    
    
    
    public Paciente crearPaciente(Paciente paciente) throws UserException{
        try {
            return pacienteRepo.save(paciente);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el paciente. Por favor, inténtalo de nuevo más tarde.", "crearPaciente");
        }
        
    }
    
    
    
    public void eliminarPacientePorId(Long idPer) throws UserException{
        try {
            pacienteRepo.deleteById(idPer);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.", "eliminarPaciente");
        }
    }
    
    public void eliminarPacientePorNombre(String nombre) throws UserException{
        try {
            pacienteRepo.deleteByNombre(nombre);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.", "eliminarPaciente");
        }
    }
    
    
    
    public void eliminarPacientePorEmail(String email) throws UserException{
        try {
            pacienteRepo.deleteByEmail(email);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.", "eliminarPaciente");
        }
    }
    
    public void eliminarPacientePorDni(String dni) throws UserException{
        try {
            pacienteRepo.deleteByDni(dni);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el paciente. Por favor, inténtalo de nuevo más tarde.", "eliminarPaciente");
        }
    }
    
    public void eliminarPorCriterios(Long id, String nombre, String email, String dni ) throws UserException {
        if (id != null) {
            eliminarPacientePorId(id);
        }
        if (nombre != null) {
            eliminarPacientePorNombre(nombre);
        }
        if (email != null) {
            eliminarPacientePorEmail(email);
        }
        if (dni != null) {
            eliminarPacientePorDni(dni);
        }
    }
    
    public Paciente consultarPaciente(Long idPer) throws UserException{
        try {
            return pacienteRepo.findById(idPer).orElse(null);
        } catch (Exception e) {
            throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "El paciente no se encuentra en la base de datos.", "consultarPaciente");
        }
        
    }
    
    public Paciente editarPaciente(Paciente idPer) throws UserException{
        try {
            return pacienteRepo.save(idPer);
        } catch (Exception e) {
           throw new UserException(HttpStatus.INTERNAL_SERVER_ERROR, "Ingrese los datos del Paciente.", "editarPaciente");
        }
        
    }
}
