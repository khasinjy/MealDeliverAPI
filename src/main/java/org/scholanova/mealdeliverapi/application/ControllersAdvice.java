package org.scholanova.mealdeliverapi.application;
import org.scholanova.mealdeliverapi.application.controllers.*;
import org.scholanova.mealdeliverapi.domain.Client.ClientNonTrouveException;
import org.scholanova.mealdeliverapi.domain.Commande.CommandeNonTrouveeException;
import org.scholanova.mealdeliverapi.domain.Commande.CommandeVideException;
import org.scholanova.mealdeliverapi.domain.Livreur.Exception.LivreurDejaEnRouteException;
import org.scholanova.mealdeliverapi.domain.Livreur.Exception.LivreurNonTrouveException;
import org.scholanova.mealdeliverapi.domain.Menu.Exception.MenuChoixIndisponibleException;
import org.scholanova.mealdeliverapi.domain.Menu.Exception.MenuMauvaisTypeException;

import org.scholanova.mealdeliverapi.domain.Restaurant.Exception.ProduitNonDisponibleException;
import org.scholanova.mealdeliverapi.domain.Restaurant.Exception.RestaurantNonTrouveException;
import org.scholanova.mealdeliverapi.domain.Restaurant.RestoContient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes =  {RestaurantController.class, MenuController.class,
        ProduitController.class, RestoContientController.class, CommandeController.class})
public class ControllersAdvice {

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(RestaurantNonTrouveException.class)
        @ResponseBody
        ErrorInfo
        handleRestaurantNonTrouveException(HttpServletRequest req, Exception ex) {
                return new ErrorInfo(req.getRequestURL().toString(), ex);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MenuMauvaisTypeException.class)
        @ResponseBody
        ErrorInfo
        handleMenuMauvaisTypeException(HttpServletRequest req, Exception ex) {
            return new ErrorInfo(req.getRequestURL().toString(), ex);
        }

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(MenuChoixIndisponibleException.class)
        @ResponseBody
        ErrorInfo
        handleMenuChoixIndisponibleException(HttpServletRequest req, Exception ex) {
                return new ErrorInfo(req.getRequestURL().toString(), ex);
        }

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(ProduitNonDisponibleException.class)
        @ResponseBody
        ErrorInfo
        handleProduitNonDisponibleException(HttpServletRequest req, Exception ex) {
                return new ErrorInfo(req.getRequestURL().toString(), ex);
        }

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(CommandeNonTrouveeException.class)
        @ResponseBody
        ErrorInfo
        handleCommandeNonTrouveeException(HttpServletRequest req, Exception ex) {
                return new ErrorInfo(req.getRequestURL().toString(), ex);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(CommandeVideException.class)
        @ResponseBody
                ErrorInfo
        handleCCommandeVideException(HttpServletRequest req, Exception ex) {
                return new ErrorInfo(req.getRequestURL().toString(), ex);
        }

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(ClientNonTrouveException.class)
        @ResponseBody
        ErrorInfo
        handleClientNonTrouveException(HttpServletRequest req, Exception ex) {
                return new ErrorInfo(req.getRequestURL().toString(), ex);
        }

        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(LivreurNonTrouveException.class)
        @ResponseBody
        ErrorInfo
        handleLivreurNonTrouveException(HttpServletRequest req, Exception ex) {
                return new ErrorInfo(req.getRequestURL().toString(), ex);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(LivreurDejaEnRouteException.class)
        @ResponseBody
        ErrorInfo
        handleLivreurDejaEnRouteException(HttpServletRequest req, Exception ex) {
                return new ErrorInfo(req.getRequestURL().toString(), ex);
        }


}
