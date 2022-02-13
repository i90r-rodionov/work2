package org.homework.igorr.api.advice;

import lombok.extern.slf4j.Slf4j;
import org.homework.igorr.core.dto.common.RequestDto;
import org.homework.igorr.core.dto.common.ResponseDto;
import org.homework.igorr.core.dto.common.ResponseStatusDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice("org.homework.igorr.api.controller")
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseDto handleConstraintException(ConstraintViolationException e, WebRequest request) {
        LOG.warn("Constraint violated", e);
        return new ResponseDto(getRqId(request), ResponseStatusDto.error(e));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseDto handleCommonException(Exception e, WebRequest request) {
        LOG.warn("Unhandled exception", e);
        return new ResponseDto(getRqId(request), ResponseStatusDto.error(e));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //return super.handleExceptionInternal(ex, body, headers, status, request);
        LOG.error("Internal exception", ex);
        ResponseDto dto = new ResponseDto(getRqId(body, request), ResponseStatusDto.error(ex));
        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getRqId(Object body, WebRequest request) {
        if (body instanceof RequestDto) {
            return ((RequestDto) body).getRqId();
        }
        return getRqId(request);
    }

    private static String getRqId(WebRequest request) {
        Object rqId = request.getAttribute("REQUEST_UUID_ATTRIBUTE", RequestAttributes.SCOPE_REQUEST);
        return (String) rqId;
    }

}

