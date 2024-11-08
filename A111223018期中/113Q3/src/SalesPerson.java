import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.ArrayList;

public class SalesPerson {
    private String id;
    private String name;
    private double grossSales;
    private double commissionRate;

    private Order[] orderArray = new Order[3];
    private int orderCount = 0;

    public SalesPerson(String id, String name) {
        this(id, name, 0.01);
    }

    public SalesPerson(String id, String name, double commissionRate) {
        this.id = id;
        this.name = name;
        this.grossSales = getGrossSales();
        this.commissionRate = commissionRate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate < 0 || commissionRate > 1) {
            System.out.println("獎金比例必須在 0 到 1 之間！");
        } else {
            this.commissionRate = commissionRate;
        }
    }

    public void setOrderArray(String itemName, double itemPrice, int amount) {
        if (orderCount == orderArray.length) {
            // 若訂單陣列已滿，將陣列長度加倍
            Order[] newOrderArray = new Order[orderArray.length * 2];
            System.arraycopy(orderArray, 0, newOrderArray, 0, orderArray.length);
            orderArray = newOrderArray;
        }
        orderArray[orderCount] = new Order(itemName, itemPrice, amount);
        orderCount++;
    }

    public double getGrossSales() {
        double totalSales = 0;
        for (int i = 0; i < orderCount; i++) {
            totalSales += orderArray[i].getTotalPrice();
        }
        return totalSales;
    }

    
    public String getOrders() {
        StringBuilder ordersInfo = new StringBuilder();
        if (orderCount == 0) {
            ordersInfo.append("沒有訂單記錄。");
        } else {
            for (int i = 0; i < orderCount; i++) {
                ordersInfo.append(String.format("產品名稱：%s, 價格：%.2f, 數量：%d, 總價：%.2f%n",
                        orderArray[i].getProductName(), orderArray[i].getPrice(),
                        orderArray[i].getQuantity(), orderArray[i].getTotalPrice()));
            }
        }
        return ordersInfo.toString();
    }
    
    public double salary() {
        return getGrossSales() * commissionRate;
    }

    public String toString() {
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.1f%n獎金比例：%.2f%n薪資：%.1f%n",
                this.id, this.name, this.grossSales, this.commissionRate, salary() );
    }
}
