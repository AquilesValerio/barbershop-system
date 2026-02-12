package com.barbershop.barbershop.api.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class StandardError {

    private Instant timeStamp;
    private Integer status;
    private String error;
    private String path;

    private List<String> errors = new ArrayList<>();

    public StandardError() {
    }

    public StandardError(Instant timeStamp, Integer status, String error, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public StandardError(Instant timeStamp, Integer status, List<String> errors, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.errors = errors;
        this.path = path;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
