import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FileService {

    public static final Map<String, Integer> Everymonth= new HashMap<>();
    static {
        Everymonth.put("Jan", 1);
        Everymonth.put("Feb", 2);
        Everymonth.put("Mar", 3);
        Everymonth.put("Apr", 4);
        Everymonth.put("May", 5);
        Everymonth.put("Jun", 6);
        Everymonth.put("Jul", 7);
        Everymonth.put("Aug", 8);
        Everymonth.put("Sep", 9);
        Everymonth.put("Oct", 10);
        Everymonth.put("Nov", 11);
        Everymonth.put("Dec", 12);
    }

    public static  Map <LocalDate, Integer> ReadingtheFile(String filename) throws FileNotFoundException {
        Map<LocalDate,Integer> monthlyreport= new HashMap<>();
        try {
            BufferedReader reader= new BufferedReader(new FileReader(filename));
            reader.lines()
                    .skip(1)
                    .map(line->line.split(","))
                    .forEach(data->{

                        String dateData = data[0];
                        String yearmonth[] = dateData.split("-");

                        int year = Integer.parseInt("20" + yearmonth[0]);
                        int month = Integer.parseInt(yearmonth[1]);
                        int yearlySales = Integer.parseInt(data[1]);

                LocalDate date = LocalDate.of(year,month,1);
                monthlyreport.merge(date,month,Integer::sum);

            });

        }
        finally {

        }

    return monthlyreport;}
}
