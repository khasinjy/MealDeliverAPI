package org.scholanova.mealdeliverapi.application.Menu;
import org.scholanova.mealdeliverapi.domain.Menu.MenuMauvaisTypeException;
import org.scholanova.mealdeliverapi.application.ErrorInfo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes =  {MenuController.class})
public class MenuControllerAdvice {

        @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
        @ExceptionHandler(MenuMauvaisTypeException.class)
        @ResponseBody
        ErrorInfo
        handleMenuMauvaisTypeException(HttpServletRequest req, Exception ex) {
            return new ErrorInfo(req.getRequestURL().toString(), ex);
        }
}
