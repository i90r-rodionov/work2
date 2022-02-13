package org.homework.igorr.core.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.exception.ExceptionUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStatusDto {

    private ResponseStatusCode statusCode;
    private String errorMessage;
    private String stackTrace;

    public static ResponseStatusDto success() {
        return new ResponseStatusDto(ResponseStatusCode.SUCCESS, null, null);
    }

    public static ResponseStatusDto error(Throwable ex) {
        String message = ExceptionUtils.getRootCauseMessage(ex);
        String stackTrace = ExceptionUtils.getStackTrace(ex);
        return new ResponseStatusDto(ResponseStatusCode.ERROR, message, stackTrace);
    }

}
