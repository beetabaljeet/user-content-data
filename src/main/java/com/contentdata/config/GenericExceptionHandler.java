package com.contentdata.config;

import com.contentdata.dto.ErrorBO;
import com.contentdata.dto.ResponseBO;
import com.contentdata.rest.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


    @ControllerAdvice
    public class GenericExceptionHandler  {

        @Autowired
        private GenericController genericController;

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ResponseBO<Object>> getException(Exception ex, WebRequest request) {


            //temporary run time exception handler
            if(ex instanceof RuntimeException){
                RuntimeException exception = (RuntimeException) ex;
                List<ErrorBO> errors = new ArrayList<>();
                errors.add(new ErrorBO("something went wrong",String.valueOf(34)));
                return genericController.sendFailure(null, errors, 501);
            }
            else {

                ErrorBO error = ErrorBO.builder().errorCode(String.valueOf(01))
                        .errorMessage(ex.getMessage()).build();
                return genericController.sendFailure(null, Collections.singletonList(error),500);
            }

        }

    }

