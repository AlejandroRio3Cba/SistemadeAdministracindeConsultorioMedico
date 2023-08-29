/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.modelo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPer;
//    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")
//    @NotNull
//    @Size(min = 4, max = 30)
    @Column(name = "nombre")
    private String nombre;
//    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")
//    @NotNull
//    @Size(min = 4, max = 30)
    @Column(name = "apellido")
    private String apellido;
//    @Pattern(regexp = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s\\-\\,\\.]+$")
//    @Size(min = 5, max = 100)
    @Column(name = "direccion")
    private String direccion;
//    @Pattern(regexp = "^\\+?[0-9\\s-]+$")
//    @Size(min = 5, max = 20)
    @Column(name = "telefono")
    private String telefono;
//    @Pattern(regexp = "^[0-9A-Za-z]+$")
//    @NotNull
//    @Size(min = 8, max = 8)
    @Column(name = "dni", unique = true)
    private String dni;
    
    @Email
//    @NotNull
    @Column(name = "email", unique = true)
    private String email;
//    @Pattern(regexp = "^[a-zA-Z0-9_]+$")
//    @NotNull
//    @Size(min = 4, max = 20)
    @Column(name = "user", unique = true)
    private String username;
//    @Pattern(regexp = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*")
//    @NotNull
//    @Size(min = 8, max = 30)
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role ;
}
