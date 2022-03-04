package de.tech26.robotfactory.robotfactory.services;

import de.tech26.robotfactory.robotfactory.config.StockDetailConfig;
import de.tech26.robotfactory.robotfactory.config.StockDetailConfig.StockDetail;
import de.tech26.robotfactory.robotfactory.constants.enums.ErrorCode;
import de.tech26.robotfactory.robotfactory.domain.request.OrderRequest;
import de.tech26.robotfactory.robotfactory.exceptions.StockAvailabilityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

  @Autowired
  private StockDetailConfig stockDetailConfig;

  public void checkStockAvailability(String code) {
    StockDetail stockDetail = stockDetailConfig.getProducts().get(code);
    if (stockDetail.getAvailableStock() == 0) {
      throw new StockAvailabilityException("Product out of stock - " + code, ErrorCode.STOCK_UNAVAILABLE);
    }
  }

  public double getCost(OrderRequest orderRequest) {
    double cost = 0;

    for (int i = 0; i < orderRequest.getComponents().size(); i++) {
      String code = orderRequest.getComponents().get(i);
      cost += stockDetailConfig.getProducts()
        .get(code)
        .getPrice();
      adjustStock(code);
    }
    return cost;
  }

  private void adjustStock(String code) {
    StockDetail stockDetail = stockDetailConfig.getProducts().get(code);
    stockDetail.setAvailableStock(stockDetail.getAvailableStock() - 1);
    stockDetailConfig.getProducts().put(code, stockDetail);
  }
}
