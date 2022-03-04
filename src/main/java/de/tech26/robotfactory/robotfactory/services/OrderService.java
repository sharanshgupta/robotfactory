package de.tech26.robotfactory.robotfactory.services;

import de.tech26.robotfactory.robotfactory.domain.order.OrderDetail.OrderDetailBuilder;
import de.tech26.robotfactory.robotfactory.domain.request.OrderRequest;
import de.tech26.robotfactory.robotfactory.domain.order.OrderDetail;
import de.tech26.robotfactory.robotfactory.logging.AppLogger;
import de.tech26.robotfactory.robotfactory.repositories.OrderRepository;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private StockService stockService;

  public OrderDetail submitOrder(OrderRequest orderRequest) {

    AppLogger.logger.log(Level.INFO, "Received submit order request");

    // Check stock availability of all products
    orderRequest.getComponents().forEach(c -> stockService.checkStockAvailability(c));

    return createOrder(orderRequest);
  }

  private OrderDetail createOrder(OrderRequest orderRequest) {

    AppLogger.logger.log(Level.INFO, "Creating order");

    OrderDetail orderDetail = new OrderDetailBuilder()
      .orderId("Order-" + (OrderRepository.orderMap.size() + 1))
      .total(stockService.getCost(orderRequest))
      .build();

    OrderRepository.orderMap.put(orderDetail.getOrderId(), orderDetail);

    AppLogger.logger.log(Level.INFO, "Order persisted to repository - " + orderDetail.getOrderId());

    return orderDetail;
  }
}
