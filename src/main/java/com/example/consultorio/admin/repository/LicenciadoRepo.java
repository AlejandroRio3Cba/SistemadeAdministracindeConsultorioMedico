/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.consultorio.admin.repository;

import com.example.consultorio.admin.modelo.Licenciado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenciadoRepo extends JpaRepository<Licenciado, Long>{
    
    public Licenciado findByUsername(String username);

    public Licenciado findByUsernameAndRole(String username, String Licenciado);

    public Licenciado findByUsernameAndPassword(String username, String password);

    public boolean existsByUsernameAndPassword(String username, String password);

    public void deleteByNombre(String nombre);

    public void deleteByEmail(String email);

    public void deleteByDni(String dni);
    
}
