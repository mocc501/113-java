import java.util.Scanner;

public class SalesDepartment {
    public  static void main(String args[]) {
        SalesPerson[] salesTeam = new SalesPerson[3];
        SalesPerson sales1 = new SalesPerson("SE111", "周柏睿");
        SalesPerson sales2 = new SalesPerson("SE222", "黃敬宇");
        SalesPerson sales3 = new SalesPerson("SE333", "吳嘉文");
        salesTeam[0] = sales1;
        salesTeam[1] = sales2;
        salesTeam[2] = sales3;

        operation(salesTeam);
    }

    public static void operation(SalesPerson[] salesTeam) {
        SalesPerson targetSales;
        Scanner input = new Scanner(System.in);
        menu();

        while (input.hasNext()) {
            int choice = input.nextInt();
            try {
                switch (choice) {
                    case 1: // 設定獎金比例
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("請輸入獎金比例（0-1）：");
                            double commissionRate = input.nextDouble();
                            targetSales.setCommissionRate(commissionRate);
                        }
                        break;
                    case 2: // 新增訂單
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.print("請輸入產品名稱：");
                            String productName = input.next();
                            System.out.print("請輸入產品價格：");
                            double productPrice = input.nextDouble();
                            System.out.print("請輸入銷售數量：");
                            int quantity = input.nextInt();
                            targetSales.setOrderArray(productName, productPrice, quantity);
                        }
                        break;
                    case 3: // 薪資查詢
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.printf("薪資：%.1f%n", targetSales.salary());
                        }
                        break;
                    case 4: // 訂單查詢
                        targetSales = selectedSales(salesTeam);
                        if (targetSales != null) {
                            System.out.println("訂單清單：");
                            System.out.println(targetSales.getOrders());
                        }
                        break;
                    default:
                        System.out.println("選項錯誤，請重新輸入。");
                        break;
                }
            }
            catch (IllegalArgumentException ex) {
                System.out.print(ex.getMessage());
                menu();
                continue;
            }
            menu();
        }
        for (SalesPerson s : salesTeam)
            System.out.print(s.toString());
    }

    public static SalesPerson selectedSales(SalesPerson[] salesTeam) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入編號： ");
        String salesID = input.next();

        for (SalesPerson sales : salesTeam) {
            if (sales.getId().equals(salesID)) {
                return sales;
            }
        }

        System.out.println("編號輸入錯誤");
        return null;
    }

    public static void menu() {
        System.out.println("\n\nROC股份有限公司：");
        System.out.print("1.設定獎金比例\n2.新增訂單\n3.薪資查詢\n4.訂單查詢\n請輸入： ");
    }
}
