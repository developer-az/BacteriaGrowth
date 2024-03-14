import java.util.Scanner;

public class BacteriaGrowth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the initial amount of bacteria:");
        int initialBacteria = scanner.nextInt();

        System.out.println("Enter the time in minutes it takes for the bacteria to double:");
        int doublingTime = scanner.nextInt();

        System.out.println("Do you want to find out how long it will take for the culture to reach a certain number of bacteria? (yes/no)");
        String response = scanner.next();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the target number of bacteria:");
            int targetBacteria = scanner.nextInt();

            double time = calculateTime(initialBacteria, doublingTime, targetBacteria);
            System.out.println("It will take approximately " + time + " minutes for the culture to reach " + targetBacteria + " bacteria.");
        }

        double k = Math.log(2) / doublingTime;
        System.out.println("The parameters of the function P(t) = Ae^(kt) = B(2^(t/C)) are:");
        System.out.println("A = " + initialBacteria);
        System.out.println("k = " + k);
        System.out.println("B = " + initialBacteria);
        System.out.println("C = " + doublingTime);
    }

    public static double calculateTime(int initialBacteria, int doublingTime, int targetBacteria) {
        return doublingTime * (Math.log((double) targetBacteria / initialBacteria) / Math.log(2));
    }
}
