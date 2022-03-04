package de.tech26.robotfactory.robotfactory.domain.request;

import java.util.List;

public class OrderRequest {

//  @NotNull(message = "Not a valid value")
  private List<String> components;

  public List<String> getComponents() {
    return components;
  }
}
