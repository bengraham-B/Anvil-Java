import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateFunction {
    Date date;

    public DateFunction(Date date){
        this.date = date;
    }

    // Breaks down the Date data type, and returns day, month and year as integers.
    public static int[] breakDownDate(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int day = localDate.getDayOfMonth();
        int month = localDate.getMonthValue(); // Month is 1-based
        int year = localDate.getYear();

        return new int[]{day, month, year}; //
    }

    // Allows user to input a date and save it as a 'Date' data type
    public static Date customDate(int day, int month, int year) {
        // Create a LocalDate object using the provided parameters
        LocalDate localDate = LocalDate.of(year, month, day);

        // Convert LocalDate to Date
        Date dateObject = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return dateObject;
    }
}
