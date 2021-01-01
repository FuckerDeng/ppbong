package com.df.ppbong.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebResult;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R globalException(MethodArgumentNotValidException e,BindingResult result){
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String,String> errors = new HashMap<>();
        fieldErrors.forEach((error)->{
            String field = error.getField();
            String msg = error.getDefaultMessage();
            errors.put(field,msg);
        });
        System.out.println(1);
        return R.ERROR().setData(errors);
    }
}
