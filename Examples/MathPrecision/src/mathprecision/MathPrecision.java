/**
This DZone article has a good discussion of
https://dzone.com/articles/bigdecimal-gotchas

This program demonstrates the different results when
computing values using double vs. BigDecimal
...in particular, if the value cannot be accurately
represented in a double data type...

Reference:
Industry standard for representing floating-point numbers in computers
https://en.wikipedia.org/wiki/IEEE_754-1985


*/
import java.math.BigDecimal;

public class MathPrecision {
  public static void main(String[] args) {
    // Literal values are treated as Doubles
    // outputs: 11.399999999999999
    System.out.println("5.8 + 5.6=" + (5.8 + 5.6) );

    BigDecimal x = new BigDecimal(5.8);
    BigDecimal y = new BigDecimal(5.6);
    // BigDecimal translates the literal double values into th exact decimal representation of the double's binary floating-point value
    // outputs: 11.39999999999999946709294817992486059665679931640625
    System.out.println("BigDecimal(5.8) + BigDecimal(5.6)=" + x.add(y));

    BigDecimal x2 = new BigDecimal("5.8");
    BigDecimal y2 = new BigDecimal("5.6");
    // BigDecimal translates the literal double values into th exact decimal representation of the double's binary floating-point value
    // outputs: 11.4
    System.out.println("BigDecimal(\"5.8\") + BigDecimal(\"5.6\")=" + x2.add(y2));

  }
}
