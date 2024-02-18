import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesCategoriser {

    public  void SalesReport(String CarModelFilename,String carmodel) throws FileNotFoundException {
        Map<Integer, Integer> yearllyreport = new HashMap<>();
        Map<LocalDate,Integer> monthlyreport = FileService.ReadingtheFile(CarModelFilename);

       yearllyreport.put(monthlyreport.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry -> entry.getKey().getYear(), Collectors.summingInt(Map.Entry::getValue))));

        yearllyreport.entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        String bestMonth = monthlyreport.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .flatMap(entry -> Optional.ofNullable(entry.getKey().format(DateTimeFormatter.ofPattern("yyyy-MM"))))
                .orElse("N/A");
        //String maximumMonthanothermethod = monthlyreport.entrySet().stream().reduce(Integer::max).get();
        String worstMonth = monthlyreport.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .flatMap(entry -> Optional.ofNullable(entry.getKey().format(DateTimeFormatter.ofPattern("yyyy-MM"))))
                .orElse("N/A");

        System.out.println(carmodel + " Yearly Sales Report \n");
        System.out.println("The best month for " + carmodel + " was: " + bestMonth);
        System.out.println("The worst month for " + carmodel + " was: " + worstMonth);
        System.out.println();

    }




}
