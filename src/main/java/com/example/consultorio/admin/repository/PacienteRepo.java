/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.consultorio.admin.repository;

import com.example.consultorio.admin.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Long>{
    
    public Paciente findByUsername(String username);

    public Paciente findByUsernameAndRole(String username, String Paciente);

    public Paciente findByUsernameAndPassword(String username, String password);

    public boolean existsByUsernameAndPassword(String username, String password);

    public void deleteByNombre(String nombre);

    public void deleteByEmail(String email);

    public void deleteByDni(String dni);
    
}
