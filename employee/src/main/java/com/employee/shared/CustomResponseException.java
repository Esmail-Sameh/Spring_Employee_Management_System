package com.employee.shared;

public class CustomResponseException extends RuntimeException {
    private int code;
    private String message;

    public CustomResponseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CustomResponseException ResourceNotFound(String message) {
        return new CustomResponseException(404, message);
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public CustomResponseException badRequest(String message) {
        return new CustomResponseException(400, message);
    }

}
