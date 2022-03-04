package de.tech26.robotfactory.robotfactory.domain.order;

public class OrderDetail {

  private final String orderId;
  private final double total;

  private OrderDetail(OrderDetailBuilder orderDetailBuilder) {
    this.orderId = orderDetailBuilder.orderId;
    this.total = orderDetailBuilder.total;
  }

  public String getOrderId() {
    return orderId;
  }

  public double getTotal() {
    return total;
  }

  public static class OrderDetailBuilder {
    private String orderId;
    private double total;

    public OrderDetailBuilder orderId(String orderId) {
      this.orderId = orderId;
      return this;
    }

    public OrderDetailBuilder total(double total) {
      this.total = total;
      return this;
    }

    public OrderDetail build() {
      OrderDetail orderDetail = new OrderDetail(this);
      return orderDetail;
    }
  }
}
