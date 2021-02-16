package com.lumenghe.ksql.functions.udf;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(
    name = "reverse",
    description = "Example UDF that reverses an object",
    version = "0.1.0",
    author = "lumenghe"
)
public class ReverseUdf {
  @Udf(description = "Reverse a string")
  public String reverseString(
      @UdfParameter(value = "source", description = "the value to reverse")
      final String source
  ) {
    return new StringBuilder(source).reverse().toString();
  }

  @Udf(description = "Reverse an integer")
  public String reverseInt(
      @UdfParameter(value = "source", description = "the value to reverse")
      final Integer source
  ) {
    return new StringBuilder(source.toString()).reverse().toString();
  }

  @Udf(description = "Reverse a long")
  public String reverseLong(
      @UdfParameter(value = "source", description = "the value to reverse")
      final Long source
  ) {
    return new StringBuilder(source.toString()).reverse().toString();
  }

  @Udf(description = "Reverse a double")
  public String reverseDouble(
      @UdfParameter(value = "source", description = "the value to reverse")
      final Double source
  ) {
    return new StringBuilder(source.toString()).reverse().toString();
  }
}

