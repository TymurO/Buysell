package com.example.buysell.exception;

import lombok.Data;

import java.util.Date;

@Data
public class AppError {

    private Integer status;

    private String message;

    private Date timestamp;

    public AppError(Integer status, String message) {
        this.status = status;
        this.message = message;
        timestamp = new Date();
    }
}
