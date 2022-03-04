package de.tech26.robotfactory.robotfactory.services;

import de.tech26.robotfactory.robotfactory.constants.enums.Components;
import de.tech26.robotfactory.robotfactory.constants.enums.ErrorCode;
import de.tech26.robotfactory.robotfactory.domain.request.OrderRequest;
import de.tech26.robotfactory.robotfactory.exceptions.InvalidDataException;
import de.tech26.robotfactory.robotfactory.exceptions.UnprocessableEntityException;
import de.tech26.robotfactory.robotfactory.logging.AppLogger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

  public void validateOrderRequest(OrderRequest orderRequest) {

    AppLogger.logger.log(Level.INFO, "Validation started");

    List<String> components = orderRequest.getComponents();
    Set<String> requestEnums = new HashSet<>();

    // Check for size of list
    if (components.size() != 4)
      throw new InvalidDataException("Invalid number of configurable parts", ErrorCode.INVALID_DATA);

    List<String> enumValues = Components.getEnumValues();

    // Check for valid configurable parts
    for (String component : components) {
      if (!enumValues.contains(component)) {
        throw new UnprocessableEntityException("Not a valid configurable part", ErrorCode.UNPROCESSABLE_ENTITY);
      }
      requestEnums.add(Components.getEnumNameByValue(component));
    }

    // Check for multiple configurable part of same category
    if (requestEnums.size() != 4)
      throw new UnprocessableEntityException("Must have only one configurable part per category", ErrorCode.UNPROCESSABLE_ENTITY);

    AppLogger.logger.log(Level.INFO, "Validation completed");

  }

}
