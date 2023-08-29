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
public class ErrorResponse {
    
    private HttpStatus statusCode;
    private String message;
    private String cause;

    public ErrorResponse(HttpStatus statusCode, String message, String cause) {
        this.statusCode = statusCode;
        this.message = message;
        this.cause = cause;
}
    
}
