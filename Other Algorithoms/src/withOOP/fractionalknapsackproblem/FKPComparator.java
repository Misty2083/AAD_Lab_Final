package withOOP.fractionalknapsackproblem;

import java.util.Comparator;

public class FKPComparator implements Comparator<ItemValue> {
    public int compare(ItemValue item1, ItemValue item2) {
        double cpr1 = new Double(item1.getProfit() / item1.getWeight());
        double cpr2 = new Double(item2.getProfit() / item2.getWeight());
        if (cpr1 < cpr2)
            return 1;
        else
            return -1;
    }
}