package de.tech26.robotfactory.robotfactory.constants.enums;

import de.tech26.robotfactory.robotfactory.exceptions.CategoryNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Components {
  FACE(Arrays.asList("A", "B", "C")),
  MATERIAL(Arrays.asList("I", "J")),
  ARMS(Arrays.asList("D", "E")),
  MOBILITY(Arrays.asList("F", "G", "H"));

  public final List<String> code;

  private Components(List<String> code) {
    this.code = code;
  }

  public static List<Components> getEnumNames() {
    ArrayList<Components> enumValues = new ArrayList<>();
    Components[] values = Components.values();
    for (int i = 0; i < values.length; i++) {
      enumValues.add(values[i]);
    }
    return enumValues;
  }

  public static List<String> getEnumValues() {
    ArrayList<String> enumValues = new ArrayList<>();
    getEnumNames().forEach(
      name -> name.code.forEach(
        e -> enumValues.add(e)));
    return enumValues;
  }

  public static String getEnumNameByValue(String value) {
    List<Components> enumNames = getEnumNames();
    for (int i = 0; i < enumNames.size(); i++) {
      if (enumNames.get(i).code.contains(value)) return enumNames.get(i).name();
    }
    throw new CategoryNotFoundException("One or more category of parts not found", ErrorCode.CATEGORY_NOT_FOUND);
  }
}
