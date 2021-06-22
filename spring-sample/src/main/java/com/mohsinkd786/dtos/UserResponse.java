package com.mohsinkd786.dtos;

import lombok.Data;

@Data
public class UserResponse {
    private boolean status;
    private String error;
    private String message;
}
