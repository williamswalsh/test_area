import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.apache.commons.lang.StringUtils.isNotBlank;

public class DateTesting {

    public static void main(String[] args) {
        Date paymentDate = new Date();
        LocalDate startDate = paymentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int number = 13;
        LocalDate endDate = LocalDate.of(startDate.getYear(), startDate.getMonthValue() + number, startDate.getDayOfMonth());

        System.out.println("Payment Date: " + paymentDate);
        System.out.println("ZoneId.systemDefault(): " + ZoneId.systemDefault());
        System.out.println("startDate: " + startDate);
        System.out.println("endDate: " + endDate);


    }

    public String getChargePeriodInDays() throws Exception {
        Date paymentDate=new Date(2021, 1, 1);
        String accessTimePeriod="12m";

        LocalDate startDate = paymentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate;
        if(paymentDate != null && isNotBlank(accessTimePeriod)) {
            long days = 0;
            int number = Integer.parseInt(accessTimePeriod.replaceAll("\\D+", ""));
            switch (accessTimePeriod.charAt(accessTimePeriod.length() - 1)) {
                case 'd':
                    days = number;
                    break;
                case 'w':
                    days = number * 7L;
                    break;
                case 'm':
                    days = DAYS.between(startDate, startDate.plusMonths(number));
                    break;
                case 'y':
                    days = DAYS.between(startDate, startDate.plusYears(number));
                    break;
                default:
                    return "";
            }
        }
        throw new Exception();
    }
}
