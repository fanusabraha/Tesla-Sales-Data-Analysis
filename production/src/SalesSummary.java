import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesSummary {

    public  void SalesReport(String carModelFilename,String carModel) throws FileNotFoundException {

        System.out.println(carModel + " Yearly Sales Report \n");

        Map<Integer, Integer> yearlyReport = new HashMap<>();
        Map<LocalDate,Integer> monthlyReport = FileService.readingTheFile(carModelFilename);

       yearlyReport.putAll(monthlyReport.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry -> entry.getKey().getYear(), Collectors.summingInt(Map.Entry::getValue))));

        yearlyReport.entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        String bestMonth = monthlyReport.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .flatMap(entry -> Optional.ofNullable(entry.getKey().format(DateTimeFormatter.ofPattern("yyyy-MM"))))
                .orElse("N/A");
        //String maximumMonthanothermethod = monthlyReport.entrySet().stream().reduce(Integer::max).get();
        String worstMonth = monthlyReport.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .flatMap(entry -> Optional.ofNullable(entry.getKey().format(DateTimeFormatter.ofPattern("yyyy-MM"))))
                .orElse("N/A");

        System.out.println(carModel + " Yearly Sales Report \n");
        System.out.println("The best month for " + carModel + " was: " + bestMonth);
        System.out.println("The worst month for " + carModel + " was: " + worstMonth);
        System.out.println();

    }




}
