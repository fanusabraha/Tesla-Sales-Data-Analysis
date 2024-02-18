import java.io.IOException;

public class SalesReportApplication {
    public static void main(String[] args) throws IOException {

        SalesSummary teslareport= new SalesSummary();
        teslareport.SalesReport("model3.csv","model3");
        teslareport.SalesReport("modelS.csv","modelS");
        teslareport.SalesReport("modelX.csv","modelX");


    }
}







  /*      int sumall = data.stream()
                .mapToInt(array-> Integer.parseInt(array[1]))
                .sum();
        */





























