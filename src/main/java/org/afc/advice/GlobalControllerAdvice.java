package org.afc.advice;

import org.afc.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({Exception.class})
    public Response handleNotFoundException(Exception exception) {
        Response fail = Response.FAIL();
        fail.setMsg("页面找不到。。。");
        return fail;
    }
}
