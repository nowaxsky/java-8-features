package dateAndTimeApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

  public static final String DATE_FORMAT = "yyyy-MM-dd";
  public static final String DATE_FORMAT_SLASH = "yyyy/MM/dd";
  private static final String[] FORMAT_ARRAY = {DATE_FORMAT, DATE_FORMAT_SLASH};

  public static LocalDate toLocalDate(String dateStr) {
    DateArrayFormatter formatter = new DateArrayFormatter(FORMAT_ARRAY);
    return formatter.parse(dateStr);
  }

  public static String localDateToString(LocalDate date) {
    return date.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
  }
}
