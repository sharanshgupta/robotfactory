package de.tech26.robotfactory.robotfactory.exceptions;

import de.tech26.robotfactory.robotfactory.constants.enums.ErrorCode;

public class UnprocessableEntityException extends RuntimeException{

  private ErrorCode errorCode;

  public UnprocessableEntityException(String message, ErrorCode errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
    return errorCode.getCode();
  }
}
