package de.tech26.robotfactory.robotfactory.repositories;

/*
 *DISCLAIMER*
 Using the class as an in memory storage using Hashmap without using any dependency or library.
 Hence this storage will remain intact till applications life. Once app is stopped, this storage will be lost
*/

import de.tech26.robotfactory.robotfactory.domain.order.OrderDetail;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

  public static Map<String, OrderDetail> orderMap;

  static {
    orderMap = new HashMap<>();
  }
}
