package de.tech26.robotfactory.robotfactory.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import de.tech26.robotfactory.robotfactory.domain.response.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(InvalidDataException.class)
  @ResponseStatus(BAD_REQUEST)
  public Error handleInvalidDataException(InvalidDataException exception) {
    Error error = new Error(exception.getMessage(), BAD_REQUEST, exception.getErrorCode());
    return error;
  }

  @ExceptionHandler(UnprocessableEntityException.class)
  @ResponseStatus(UNPROCESSABLE_ENTITY)
  public Error handleUnprocessableEntityException(UnprocessableEntityException exception) {
    Error error = new Error(exception.getMessage(), UNPROCESSABLE_ENTITY, exception.getErrorCode());
    return error;
  }

  @ExceptionHandler(StockAvailabilityException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Error handleStockException(StockAvailabilityException exception) {
    Error error = new Error(exception.getMessage(), NOT_FOUND, exception.getErrorCode());
    return error;
  }

  @ExceptionHandler(CategoryNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Error handleCategoryNotFOundException(CategoryNotFoundException exception) {
    Error error = new Error(exception.getMessage(), NOT_FOUND, exception.getErrorCode());
    return error;
  }
}
