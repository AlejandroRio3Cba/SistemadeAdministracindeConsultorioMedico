/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.consultorio.admin.repository;

import com.example.consultorio.admin.modelo.AdminSecundario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminSecRepo extends  JpaRepository<AdminSecundario, Long>{
    
    
    public AdminSecundario findByUsername(String username);

    public void deleteByNombre(String nombre);

    public void deleteByEmail(String email);

    public void deleteByDni(String dni);
    
}
