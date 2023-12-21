//Stock Account Management
//a. Desc -> Write a program to read in Stock Names, Number of Share, Share Price.
//Print a Stock Report with the total value of each Stock and the total value of Stock.
//b. I/P -> N number of Stocks, for Each Stock Read In the Share Name, Number of Share, and Share Price
//c. Logic -> Calculate the value of each stock and the total value
//d. O/P -> Print the Stock Report.
//e. Hint -> Create Stock and Stock Portfolio Class holding the list of Stocks read
// from the input file. Have functions in the Class to calculate the value of each
//stock and the value of total stocks.
import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    private String stockName;
    private int numberOfShares;
    private double sharePrice;

    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }
    public double calculateStockValue() {
        return numberOfShares * sharePrice;
    }
    public String getStockName() {
        return stockName;
    }
}
class StockPortfolio {
    private ArrayList<Stock> stocks;
    public StockPortfolio() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void printStockReport() {
        double totalPortfolioValue = 0.0;

        System.out.println("Stock Report:");
        for (Stock stock : stocks) {
            double stockValue = stock.calculateStockValue();
            totalPortfolioValue += stockValue;

            System.out.println("Stock Name: " + stock.getStockName());
            //System.out.println("Number of Shares: " + stock.numberOfShares);
            //System.out.println("Share Price: $" + stock.sharePrice);
            System.out.println("Stock Value: $" + stockValue);
            System.out.println("------");
        }

        System.out.println("Total Portfolio Value: $" + totalPortfolioValue);
    }
}

class StockManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of stocks: ");
        int numStocks = scanner.nextInt();
        scanner.nextLine();

        StockPortfolio stockPortfolio = new StockPortfolio();

        for (int i = 0; i < numStocks; i++) {
            System.out.println("\nEnter details for Stock " + (i + 1) + ":");
            System.out.print("Enter Stock Name: ");
            String stockName = scanner.nextLine();
            System.out.print("Enter Number of Shares: ");
            int numberOfShares = scanner.nextInt();
            System.out.print("Enter Share Price: $");
            double sharePrice = scanner.nextDouble();

            Stock stock = new Stock(stockName, numberOfShares, sharePrice);
            stockPortfolio.addStock(stock);
        }
        stockPortfolio.printStockReport();

        scanner.close();
    }
}
