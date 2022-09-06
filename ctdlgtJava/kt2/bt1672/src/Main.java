import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[][] accounts = { {1, 5}, {7, 3}, {3, 5}};
        display(accounts);
        System.out.println("Wealth lớn nhất là: " + maximumWealth(accounts));

    }

    public static int maximumWealth(int[][] accounts) {
        int s=accounts[0].length;
        ArrayList<Integer> mw = new ArrayList<>();
        for (int[] account : accounts) {
            int sum = 0;
            for (int j = 0; j < s; j++) {
                sum += account[j];
            }
            mw.add(sum);
        }

        return Collections.max(mw);
    }

    public static void display(int a[][]) {
        for (char row = 0; row < a.length; row++) {
            for (char col = 0; col < a[row].length; col++) {
                System.out.print(a[row][col] + " ");
            }

            System.out.println();
        }
    }
}


