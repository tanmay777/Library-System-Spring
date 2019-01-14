package com.example.library_system.DTOs;

public class ServerResponseDTOModel {
    public ServerResponseDTOModel(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    private String status;
    private Integer code;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}
