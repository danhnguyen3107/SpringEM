package com.code.project.projectv1.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserErrorResponse {
    private int status;
    private String message;

}
