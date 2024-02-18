import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FileService {

    public static final Map<String, Integer> everyMonth = new HashMap<>();
    static {
        everyMonth.put("Jan", 1);
        everyMonth.put("Feb", 2);
        everyMonth.put("Mar", 3);
        everyMonth.put("Apr", 4);
        everyMonth.put("May", 5);
        everyMonth.put("Jun", 6);
        everyMonth.put("Jul", 7);
        everyMonth.put("Aug", 8);
        everyMonth.put("Sep", 9);
        everyMonth.put("Oct", 10);
        everyMonth.put("Nov", 11);
        everyMonth.put("Dec", 12);
    }

    public static  Map <LocalDate, Integer> readingTheFile(String fileReader) throws FileNotFoundException {
        Map<LocalDate,Integer> monthlyReport= new HashMap<>();
        try {
            BufferedReader reader= new BufferedReader(new FileReader(fileReader));
            reader.lines()
                    .skip(1)
                    .map(line->line.split(","))
                    .forEach(data->{

                        String dateData = data[0];
                        String yearMonth[] = dateData.split("-");

                        int month = everyMonth.get(yearMonth[0]);
                        int year = Integer.parseInt("20" + yearMonth[1]);
                        int yearlySales = Integer.parseInt(data[1]);

                LocalDate date = LocalDate.of(year,month,1);
                monthlyReport.merge(date, yearlySales,Integer::sum);

            });

        }
        finally {

        }

    return monthlyReport;}
}
