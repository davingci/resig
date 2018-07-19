
package org.davingci.resig.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GobalExceptionHandler {



    /**
     * 500 错误
     * @return
     */
    /**
    @ExceptionHandler(Exception.class)
    public String internalServerError() {
        return "/error/500";
    }
    **/

    /**
     * 404 错误
     * @return
     */
    /**
    @ExceptionHandler(NoHandlerFoundException.class)
    public String pageNotFound() {
        return "/error/404";
    }
    **/
}
