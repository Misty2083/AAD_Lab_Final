package withoutOOP.activitySelectionProblem;

public class ASP {
    public static void printMaxActivities(String items[], int s[], int f[], int n) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (f[j] > f[j+1]) {
                    int tempF = f[j];
                    f[j] = f[j+1];
                    f[j+1] = tempF;
                    int tempS = s[j];
                    s[j] = s[j+1];
                    s[j+1] = tempS;
                    String tempItem = items[j];
                    items[j] = items[j+1];
                    items[j+1] = tempItem;
                }
            }
        }
        System.out.println("Following activities are selected");
        int i = 0;
        System.out.print(items[i] + " ");
        for (int j = 1; j < n; j++) {
            if (s[j] >= f[i]) {
                System.out.print(items[j] + " ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        String items[] = {"A1", "A2", "A3", "A4", "A5"};
        int s[] = {2, 1, 4, 5, 7};
        int f[] = {4, 5, 6, 8, 9};
        int n = s.length;
        printMaxActivities(items, s, f, n);
    }
}