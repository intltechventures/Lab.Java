/**
This DZone article has a good discussion of double vs. BigDecimal precision
https://dzone.com/articles/bigdecimal-gotchas

This program demonstrates the different results when computing values using double vs. BigDecimal
...in particular, if the value cannot be accurately
represented in a double data type...

Reference:
Industry standard for representing floating-point numbers in computers
https://en.wikipedia.org/wiki/IEEE_754-1985

Java SE 8, BigDecimal
https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html
- "Immutable, arbitrary-precision signed decimal numbers. A BigDecimal consists of an arbitrary precision integer unscaled value and a 32-bit integer scale."
- "When the precision setting is not 0, the rules of BigDecimal arithmetic are broadly compatible with selected modes of operation of the arithmetic defined in ANSI X3.274-1996 and ANSI X3.274-1996/AM 1-2000 (section 7.4)"

Java SE Tutorial, data types
https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
see: double
- "The double data type is a double-precision 64-bit IEEE 754 floating point."

Java SE 8, Double
https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html
- "The Double class wraps a value of the primitive type double in an object. An object of type Double contains a single field whose type is double."


Also see:
Java SE 8, Number
https://docs.oracle.com/javase/8/docs/api/java/lang/Number.html

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
