/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.consultorio.admin.repository;

import com.example.consultorio.admin.modelo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>{
    
    public Admin findByUsername(String username);

    public Admin findByUsernameAndRole(String username, String Admin);

    public Admin findByUsernameAndPassword(String username, String password);

    public boolean existsByUsernameAndPassword(String username, String password);

    public boolean existsByUsername(String username);
    
}
