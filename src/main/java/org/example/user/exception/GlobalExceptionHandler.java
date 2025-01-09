package org.example.user.exception;

import org.example.user.dto.respone.ApiRespone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiRespone> handlingRuntimeException(RuntimeException e) {
        ApiRespone resp = new ApiRespone();
        resp.setCode(ErrorCode.UNCATEORIZED_EXCEPTION.getCode());
        resp.setMessage(ErrorCode.UNCATEORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(resp);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiRespone> handlingAppException(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        ApiRespone resp = new ApiRespone();

        resp.setCode(errorCode.getCode());
        resp.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(resp);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiRespone> handlingMethodArgumentNotValidException( MethodArgumentNotValidException e) {
        String enumkey = e.getFieldError().getDefaultMessage();

        ErrorCode errorCode = ErrorCode.KEY_INVALID;

        try{
        errorCode = ErrorCode.valueOf(enumkey);
        }catch (IllegalArgumentException exception){

        }

        ApiRespone resp = new ApiRespone();
        resp.setCode(errorCode.getCode());
        resp.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(resp);
    }
}
