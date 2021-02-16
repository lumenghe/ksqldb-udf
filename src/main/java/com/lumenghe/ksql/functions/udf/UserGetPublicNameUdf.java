package com.lumenghe.ksql.functions.udf;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * An example UDF that operates on two scalars.
 *
 * Usage in KSQL: `user_get_public_name(col1, col2)`.
 */
@UdfDescription(
    name = "user_get_public_name",
    description = "user object get public name",
    version = "0.1.0",
    author = "lumenghe"
)
public class UserGetPublicNameUdf {
  @Udf(description = "user get public name from two Strings")
  public String user_get_public_name(
	@UdfParameter(value = "login", description = "user login")
	final String login,
  @UdfParameter(value = "fullname", description = "user fullname")
  final String fullname,
  @UdfParameter(value = "preferences", description = "user preferences")
  final String preferences) {

    String name = fullname.trim();

    if (name == null || name == "") {
      return login;
    } else if (name.indexOf(":")!=-1) {
      return name;
    }

    name = name.replace(":", " ").trim();

    if (name == null || name == "") {
      return login;
    }

    if (preferences != null) {
      return preferences;
    }

    return name;
  }

}
