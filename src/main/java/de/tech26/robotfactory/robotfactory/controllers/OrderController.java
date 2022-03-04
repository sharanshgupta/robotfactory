package de.tech26.robotfactory.robotfactory.controllers;

import de.tech26.robotfactory.robotfactory.domain.request.OrderRequest;
import de.tech26.robotfactory.robotfactory.domain.order.OrderDetail;
import de.tech26.robotfactory.robotfactory.logging.AppLogger;
import de.tech26.robotfactory.robotfactory.services.OrderService;
import de.tech26.robotfactory.robotfactory.services.ValidationService;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  private ValidationService validationService;

  @Autowired
  private OrderService orderService;

  @PostMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public OrderDetail submitOrder(@RequestBody OrderRequest orderRequest) {

    AppLogger.logger.log(Level.INFO, "Submit order request received", orderRequest.getComponents().toString());

    // Check if req is valid
    validationService.validateOrderRequest(orderRequest);

    // Process order if valid req else error out
    return orderService.submitOrder(orderRequest);
  }
}
