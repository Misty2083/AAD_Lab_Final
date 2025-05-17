package withOOP.fractionalknapsackproblem;

import java.util.Arrays;

public class FKP {
    private static double getMaxValue(ItemValue[] arr, int capacity) {
        Arrays.sort(arr, new FKPComparator());
        double totalValue = 0d;
        for (ItemValue i : arr) {
            int curWt = i.getWeight();
            int curVal = i.getProfit();
            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;
                System.out.println("Item " + i.getObject() + ": Profit=" + curVal + ", Weight=" + curWt + ", Fraction=1.0");
            } else {
                double fraction = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                capacity = (int)(capacity - (curWt * fraction));
                System.out.println("Item " + i.getObject() + ": Profit=" + curVal + ", Weight=" + curWt + ", Fraction=" + fraction);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        ItemValue[] arr = { new ItemValue(), new ItemValue(), new ItemValue(), new ItemValue() };
        arr[0].setObject(1);
        arr[0].setProfit(50);
        arr[0].setWeight(5);
        arr[1].setObject(2);
        arr[1].setProfit(80);
        arr[1].setWeight(10);
        arr[2].setObject(3);
        arr[2].setProfit(100);
        arr[2].setWeight(20);
        arr[3].setObject(4);
        arr[3].setProfit(60);
        arr[3].setWeight(15);
        int capacity = 30;
        double maxValue = getMaxValue(arr, capacity);
        System.out.println(maxValue);
    }
}