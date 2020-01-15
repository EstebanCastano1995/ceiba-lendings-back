package com.ceiba.lendings.infraestructura.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.List;

public class ApiError {

        private HttpStatus status;
        private String message;
        private List<String> errors;

        public ApiError(HttpStatus status, String message, List<String> errors) {
            super();
            this.status = status;
            this.message = message;
            List<String> errorsClone=errors;
            this.errors = errorsClone;
        }

        public ApiError(HttpStatus status, String message, String error) {
            super();
            this.status = status;
            this.message = message;
            errors = Arrays.asList(error);
        }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        List<String> errorsClone=this.errors;
        return errorsClone;
    }

    public void setErrors(List<String> errors) {
        List<String> errorsClone=errors;
        this.errors = errorsClone;
    }
}
