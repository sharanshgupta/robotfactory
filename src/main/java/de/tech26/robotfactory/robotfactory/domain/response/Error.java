package de.tech26.robotfactory.robotfactory.domain.response;

import org.springframework.http.HttpStatus;

public class Error {

  private String message;
  private HttpStatus statusCode;
  private String errorCode;

  public Error(String message, HttpStatus statusCode, String errorCode) {
    this.message = message;
    this.statusCode = statusCode;
    this.errorCode = errorCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public HttpStatus getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(HttpStatus statusCode) {
    this.statusCode = statusCode;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
}
