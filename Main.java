import java.util.Scanner;

int findProductIndex(int[] productCodes, int code, int productCount) {
    // linear search: return the index, or -1 if not found

    for(int i=0; i<productCount;i++)
    {
        if(productCodes[i]==code)
        {
            return i;
        }
    }
    return -1;
}

int addProduct(int[] productCodes, String[] productNames, double[] prices,
               int[] stockQuantities, int[] soldQuantities,
               int productCount, int MAX_PRODUCTS, Scanner scanner) {
     // validate, store at productCount, return the (possibly) new count
    int code = 0;
    if(productCount>=MAX_PRODUCTS)
    {
        System.out.println("Error: Store is full! Cannot add more products.");
        return productCount;
    }
    if(findProductIndex(productCodes,code,productCount)!=-1)
    {
        System.out.println("Error: Product code already exists!");
        return productCount;
    }


    System.out.println("Enter the product code: ");
    code = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Enter the product name: ");
    String name= scanner.nextLine();
    if(name.trim().isEmpty())
    {
        System.out.println("Error: Product name cannot be empty!");
        return productCount;
    }

    System.out.println("Enter the product price: ");
    double price = scanner.nextDouble();
    scanner.nextLine();
    if(price<0)
    {
        System.out.println("Error: Price must be greater than 0!");
        return productCount;
    }

    System.out.println("Enter the initial stock: ");
    int stock= scanner.nextInt();
    scanner.nextLine();
    if(stock<0)
    {
        System.out.println("Error: Stock quantity cannot be negative!");
        return productCount;
    }

    productCodes[productCount]=code;
    productNames[productCount]=name;
    prices[productCount]=price;
    stockQuantities[productCount]=stock;
    soldQuantities[productCount]=0;
    productCount++;

    System.out.println("✓ Product added successfully!");
    return productCount;

}

void displayAllProducts(int[] productCodes, String[] productNames, double[] prices,
                        int[] stockQuantities, int[] soldQuantities, int productCount) {
    // formatted table
    if (productCount==0)
    {
        System.out.println("Error:No products in the System.!");
        return;
    }
    System.out.printf("%-8s %-20s %10s %8s %8s%n", "Code", "Name", "Price", "Stock", "Sold");
    System.out.println("================================================================");

    for (int i = 0; i < productCount; i++) {

        System.out.printf("%-8d %-20s %10.2f %8d %8d%n", productCodes[i], productNames[i], prices[i], stockQuantities[i], soldQuantities[i]);
    }

    System.out.println("================================================================");
    System.out.println("Total Products: " + productCount);
}

void sellProduct(int[] productCodes, double[] prices, int[] stockQuantities,
                 int[] soldQuantities, int productCount, Scanner scanner) {

    System.out.print("Enter product code: ");
    int code = scanner.nextInt();
    scanner.nextLine();

    int index = findProductIndex(productCodes, code, productCount);
    if (index == -1) {
        System.out.println("Error: Product not found!");
        return;
    }

    System.out.print("Enter quantity: ");
    int quantity = scanner.nextInt();
    scanner.nextLine();

    if (quantity <= 0) {
        System.out.println("Error: Quantity must be greater than 0!");
        return;
    }

    if (quantity > stockQuantities[index]) {
        System.out.println("Error: Only " + stockQuantities[index] + " units available in stock!");
        return;
    }

    double total = prices[index] * quantity;

    // Update stock and sold quantities
    stockQuantities[index] -= quantity;
    soldQuantities[index] += quantity;

    System.out.println("✓ Sale successful!");

    System.out.printf("Total Price: $%.2f%n", total);
    System.out.println("Remaining Stock: " + stockQuantities[index] + " units");
}

void restockProduct(int[] productCodes, double[] prices, int[] stockQuantities,
                    int[] soldQuantities, int productCount,Scanner scanner){

    System.out.print("Enter product code: ");
    int code = scanner.nextInt();
    scanner.nextLine();

    int index = findProductIndex(productCodes, code, productCount);
    if (index == -1) {
        System.out.println("Error: Product not found!");
        return;
    }

    System.out.print("Enter quantity: ");
    int quantity = scanner.nextInt();
    scanner.nextLine();

    if (quantity <= 0) {
        System.out.println("Error: Quantity must be greater than 0!");
        return;
    }
    stockQuantities[index] += quantity;
    System.out.println("✓ Product restocked successfully! New stock: " + stockQuantities[index]+"units");
}

void searchProduct(int[] productCodes, String[] productNames,double[] prices, int[] stockQuantities,
                   int[] soldQuantities, int productCount,Scanner scanner){
    System.out.print("Enter product code: ");
    int code = scanner.nextInt();
    scanner.nextLine();

    int index = findProductIndex(productCodes, code, productCount);
    if (index == -1) {
        System.out.println("Error: Product not found!");
        return;
    }

    double revenue = prices[index]*soldQuantities[index];
    System.out.println("Product Found:");
    System.out.println("==================");
    System.out.println("Code:"+productCodes[index]);
    System.out.println("Name:"+productNames[index]);
    System.out.println("Price:"+prices[index]);
    System.out.println("Stock:"+stockQuantities[index]+"units");
    System.out.println("Sold:"+soldQuantities[index]+"units");
    System.out.println("Total Revenue from this product: $"+revenue);
    System.out.println("==================");
}

void showLowStockAlert ( int[] productCodes, String[] productNames, int[] stockQuantities, int productCount)
{
    if (productCount == 0) {
        System.out.println("✓ All products are well stocked!");
        return;
    }

    int lowStockCount = 0;

    System.out.printf("%-8s %-20s %8s%n", "Code", "Name", "Stock");
    System.out.println("==========================================");

    for (int i = 0; i < productCount; i++) {

        if (stockQuantities[i] < 5) {

            System.out.printf("%-8d %-20s %8d%n", productCodes[i], productNames[i], stockQuantities[i]);
            lowStockCount++;
        }
    }

    if (lowStockCount == 0) {
        System.out.println("✓ All products are well stocked!");

    }
    else {
        System.out.println("Total Low Stock Items: " + lowStockCount);
    }

}

void calculateInventoryValue(double[] prices, int[] stockQuantities, int productCount) {

    if (productCount == 0) {
        System.out.println("No products in the system.");
        return;
    }

    double totalValue = 0;

    for (int i = 0; i < productCount; i++)
    {
        totalValue += prices[i] * stockQuantities[i];
    }
    System.out.printf("Total Inventory Value: $%.2f%n", totalValue);

}

void showSalesReport(int[] productCodes, String[] productNames, double[] prices, int[] soldQuantities, int productCount)
{
    int totalUnitsSold = 0;
    double totalRevenue = 0;

    for (int i = 0; i < productCount; i++)
    {
        totalUnitsSold += soldQuantities[i];
        totalRevenue += prices[i] * soldQuantities[i];
    }

    // Avoid division by zero
    if (totalUnitsSold == 0)
    {
        System.out.println("No sales recorded yet.");
        return;
    }

    double averageSaleValue = totalRevenue / totalUnitsSold;

    System.out.println();
    System.out.println("■ SALES REPORT ■");

    System.out.println("================================================================");
    System.out.println("Total Units Sold: " + totalUnitsSold + " units");
    System.out.printf("Total Revenue: $%.2f%n", totalRevenue);
    System.out.printf("Average Sale Value: $%.2f%n", averageSaleValue);
    System.out.println();
    System.out.println("Product-wise Sales:");

    for (int i = 0; i < productCount; i++)
    {
        double revenue = prices[i] * soldQuantities[i];
        System.out.printf("%d. %s (Code: %d): %d units sold, Revenue: $%.2f%n", i + 1,productNames[i],productCodes[i],soldQuantities[i],revenue);
    }
    System.out.println("================================================================");

}

void showBestSeller(int[] productCodes,String[] productNames,double[] prices, int[] stockQuantities, int[] soldQuantities, int productCount)
{

    if (productCount == 0)
    {
        System.out.println("No sales recorded yet.");
        return;
    }

    int bestIndex = -1;
    int highestSold = 0;

    for (int i = 0; i < productCount; i++)
    {
        if (soldQuantities[i] > highestSold) {

            highestSold = soldQuantities[i];
            bestIndex = i;
        }
    }

    if (bestIndex == -1) {
        System.out.println("No sales recorded yet.");
        return;
    }
    System.out.println();
    System.out.println("Best Selling Product:");
    System.out.println("==========================");
    System.out.println("Code: " + productCodes[bestIndex]);
    System.out.println("Name: " + productNames[bestIndex]);
    System.out.printf("Price: $%.2f%n", prices[bestIndex]);
    System.out.println("Stock: " + stockQuantities[bestIndex] + " units");
    System.out.println("Sold: " + soldQuantities[bestIndex] + " units");
    System.out.println("==========================");

}


void main() {
    final int MAX_PRODUCTS = 100;
    int productCount=0;
    int choice;
    int[] productCodes = new int[MAX_PRODUCTS];
    String[] productNames = new String[MAX_PRODUCTS];
    double[] prices = new double[MAX_PRODUCTS];
    int[] stockQuantities = new int[MAX_PRODUCTS];
    int[] soldQuantities = new int[MAX_PRODUCTS];

    Scanner sc = new Scanner(System.in);

    do{
        System.out.println("===== STORE MANAGEMENT SYSTEM =====");
        System.out.println("1. Add New Product");
        System.out.println("2. Display All Products");
        System.out.println("3. Sell Product");
        System.out.println("4. Restock Product");
        System.out.println("5. Search Product by Code");
        System.out.println("6. Show Low Stock Alert (quantity < 5)");
        System.out.println("7. Calculate Total Inventory Value");
        System.out.println("8. Show Sales Report");
        System.out.println("9. Show Best Selling Product");
        System.out.println("0. Exit");
        System.out.println("====================================");
        System.out.println("Enter your choice:");
        choice = sc.nextInt();
        switch (choice)
        {
            case 1:
                productCount = addProduct(productCodes,productNames,prices,stockQuantities,soldQuantities,productCount,MAX_PRODUCTS,sc);
                break;
            case 2:
                displayAllProducts(productCodes,productNames,prices,stockQuantities,soldQuantities,productCount);
                break;

            case 3:
                sellProduct(productCodes,prices,stockQuantities,soldQuantities,productCount,sc);
                break;
            case 4:
                restockProduct(productCodes,prices,stockQuantities,soldQuantities,productCount,sc);
                break;
            case 5:
                searchProduct(productCodes,productNames,prices,stockQuantities,soldQuantities,productCount,sc);
                break;
            case 6:
                showLowStockAlert(productCodes, productNames, stockQuantities, productCount);
                break;
            case 7:
                calculateInventoryValue(prices, stockQuantities, productCount);
                break;
            case 8:
                showSalesReport(productCodes, productNames, prices, soldQuantities, productCount);
                break;
            case 9:
                showBestSeller(productCodes, productNames, prices, stockQuantities, soldQuantities, productCount);
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Error:Invalid choice!");
                break;
        }
    }while(choice !=0);
    sc.close();
    return;

}
