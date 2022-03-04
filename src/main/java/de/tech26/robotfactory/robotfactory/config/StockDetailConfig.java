package de.tech26.robotfactory.robotfactory.config;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "stocks")
@Configuration
public class StockDetailConfig {

  private Map<String, StockDetail> products;

  public Map<String, StockDetail> getProducts() {
    return products;
  }

  public void setProducts(
    Map<String, StockDetail> products) {
    this.products = products;
  }

  public static class StockDetail {

    private double price;
    private int availableStock;
    private String part;

    public double getPrice() {
      return price;
    }

    public void setPrice(double price) {
      this.price = price;
    }

    public int getAvailableStock() {
      return availableStock;
    }

    public void setAvailableStock(int availableStock) {
      this.availableStock = availableStock;
    }

    public String getPart() {
      return part;
    }

    public void setPart(String part) {
      this.part = part;
    }
  }
}
