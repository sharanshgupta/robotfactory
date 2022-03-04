package de.tech26.robotfactory.robotfactory.constants.enums;

public enum ErrorCode {
  CATEGORY_NOT_FOUND("001"),
  INVALID_DATA("002"),
  STOCK_UNAVAILABLE("003"),
  UNPROCESSABLE_ENTITY("004");

  private String code;

  ErrorCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
