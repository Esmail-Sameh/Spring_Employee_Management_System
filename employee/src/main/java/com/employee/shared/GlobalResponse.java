package com.employee.shared;

import lombok.Getter;

import java.util.List;

@Getter
public class GlobalResponse<T> {

    public final static String SUCCESS = "success";
    public final static String ERROR = "error";
    private final String status;
    private final T data;
    private final List<ErrorItem> errors;

    /// // Error Const /////
    public GlobalResponse(List<ErrorItem> errors) {
        this.status = ERROR;
        this.data = null;
        this.errors = errors;
    }

    /// // Success Const /////
    public GlobalResponse(T data) {
        this.status = SUCCESS;
        this.errors = null;
        this.data = data;
    }

    public record ErrorItem(String message) {
    }


}


/*
 *
 * {
 *  status: Success,
 *  error: null
 *  data: [{},{}] , {}
 * }
 *
 * {
 *  status: Error,
 *  error: [{}]
 *  data: null
 * }
 *
 *
 *
 * */
