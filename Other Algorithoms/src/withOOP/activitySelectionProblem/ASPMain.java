package withOOP.activitySelectionProblem;

import java.util.ArrayList;
import java.util.Collections;

public class ASPMain {

    public static void main(String[] args) {
        ArrayList<ActivitySelectionProblem> list = new ArrayList<>();
        
        ActivitySelectionProblem activity1 = new ActivitySelectionProblem();
        activity1.setActivity("A1");
        activity1.setStart(1);
        activity1.setFinish(4);
        
        ActivitySelectionProblem activity2 = new ActivitySelectionProblem();
        activity2.setActivity("A2");
        activity2.setStart(3);
        activity2.setFinish(5);
        
        ActivitySelectionProblem activity3 = new ActivitySelectionProblem();
        activity3.setActivity("A3");
        activity3.setStart(0);
        activity3.setFinish(6);
        
        ActivitySelectionProblem activity4 = new ActivitySelectionProblem();
        activity4.setActivity("A4");
        activity4.setStart(5);
        activity4.setFinish(7);
        
        list.add(activity1);
        list.add(activity2);
        list.add(activity3);
        list.add(activity4);
        
        Collections.sort(list, new ASPComparator());
        
        ArrayList<ActivitySelectionProblem> selectedActivities = activitySelection(list);
        
        System.out.println("Selected Activities:");
        for (ActivitySelectionProblem problem : selectedActivities) {
            System.out.println(problem.getActivity() + ": [" + problem.getStart() + ", " + problem.getFinish() + "]");
        }
    }
    
    public static ArrayList<ActivitySelectionProblem> activitySelection(ArrayList<ActivitySelectionProblem> activities) {
        ArrayList<ActivitySelectionProblem> selected = new ArrayList<>();
        
        selected.add(activities.get(0));
        int lastFinish = activities.get(0).getFinish();
        
        for (int i = 1; i < activities.size(); i++) {
            ActivitySelectionProblem current = activities.get(i);
            if (current.getStart() >= lastFinish) {
                selected.add(current);
                lastFinish = current.getFinish();
            }
        }
        
        return selected;
    }
}