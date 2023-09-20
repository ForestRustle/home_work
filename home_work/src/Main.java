
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.util.Calendar.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите дату в формате 31.12.2020");
        Scanner scanner = new Scanner(System.in);
        String inputFirstDate = scanner.nextLine();

        SimpleDateFormat firstDateFormat = new SimpleDateFormat("dd.MM.yyyy");

        try {

            Date date1 = firstDateFormat.parse(inputFirstDate);
            DateFormat firstDateOutputFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(firstDateOutputFormat.format(date1));//после форматирования
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);

            //увеличение на 45 дней
            calendar.add(Calendar.DAY_OF_YEAR, 45);
            Date newDate = calendar.getTime();
            System.out.println(firstDateOutputFormat.format(newDate));

            //Сдвиг даты на начало года
            calendar.set(Calendar.DAY_OF_YEAR, 1);
            Date startOfYear = calendar.getTime();
            System.out.println(firstDateOutputFormat.format(startOfYear));

            //Увеличение даты на 10 рабочих дней
            calendar.setTime(date1);
            int count = 0;
            while (count < 10) {
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    count++;
                }
            }
            Date dateIncreaseWorksDays = calendar.getTime();
            System.out.println(firstDateOutputFormat.format(dateIncreaseWorksDays));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Ввод второй даты
        System.out.println("Введите вторую дату в формате 31.12.2020");
        Scanner inputSecondDate = new Scanner(System.in);
        String secondDate = inputSecondDate.nextLine();
        SimpleDateFormat secondDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date1 = firstDateFormat.parse(inputFirstDate);
            Date date2 = secondDateFormat.parse(secondDate);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            int count = 0;
            while (calendar.getTime().before(date2)){
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY){
                    count++;
                }
                calendar.add(Calendar.DAY_OF_YEAR, 1);
            }
            System.out.println(count);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
