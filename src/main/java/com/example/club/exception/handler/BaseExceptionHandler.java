package com.example.club.exception.handler;

import com.example.club.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler({BindException.class})
    public ModelAndView handleValidationExceptions(BindException ex, Model model) {
        StringBuilder str = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> str.append(((FieldError) error).getField())
                .append(" ")
                .append(error.getDefaultMessage())
                .append("; "));

        model.addAttribute("message", str.toString());
        return new ModelAndView("error");
    }

    @ExceptionHandler(BadRequestException.class)
    public ModelAndView handleBaseException(BadRequestException e, Model model) {
        log.error("handleBaseException()", e);
        model.addAttribute("message", e.getMessage());
        return new ModelAndView("error");
    }
}
