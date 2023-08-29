/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.consultorio.admin.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserException extends Exception{
    
    private HttpStatus statusCode;
    private String causa;

    public UserException(HttpStatus status, String message, String causa) {
        super(message);
        this.causa = causa;
        this.statusCode = status;
    }
    
}
