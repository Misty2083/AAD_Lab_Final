package withOOP.activitySelectionProblem;

import java.util.Comparator;

public class ASPComparator implements Comparator<ActivitySelectionProblem> {

    @Override
    public int compare(ActivitySelectionProblem o1, ActivitySelectionProblem o2) {
        return o1.getFinish() - o2.getFinish();
    }
}