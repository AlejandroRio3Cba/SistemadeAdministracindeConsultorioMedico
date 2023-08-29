/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.consultorio.admin.repository;

import com.example.consultorio.admin.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Long>{
    
    public Persona findByUsername(String username);

    public boolean existsByDni(String dni);

    public boolean existsByEmail(String email);

    public boolean existsByUsername(String username);
    
}
