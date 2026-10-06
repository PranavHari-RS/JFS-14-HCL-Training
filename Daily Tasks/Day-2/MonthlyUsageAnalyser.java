public class MonthlyUsageAnalyser {

    public static void main(String[] args) {

        int[] monthlyUsage = {
            120, 150, 180, 200,
            175, 220, 250, 230,
            190, 210, 240, 260
        };

        long total = 0;
        int maximum = monthlyUsage[0];
        int minimum = monthlyUsage[0];

        for (int usage : monthlyUsage) {

            total += usage;

            if (usage > maximum) {
                maximum = usage;
            }

            if (usage < minimum) {
                minimum = usage;
            }
        }

        double average = (double) total / monthlyUsage.length;

        char grade = average >= 200
                ? 'A'
                : average >= 150
                ? 'B'
                : 'C';

        long totalCost = 0;

        for (int usage : monthlyUsage) {

            long cost;

            if (usage <= Constants.SLAB_1_LIMIT) {
                cost = usage * Constants.SLAB_1_RATE;
            } else if (usage <= Constants.SLAB_2_LIMIT) {
                cost = usage * Constants.SLAB_2_RATE;
            } else {
                cost = usage * Constants.SLAB_3_RATE;
            }

            totalCost += cost;
        }

        int[][] houses = {
            {120, 150, 180, 200, 175, 220, 250},
            {100, 140, 170, 190, 160, 210, 230},
            {200, 220, 250, 230, 240, 260, 280}
        };

        System.out.println("Monthly Usage Analyser");
        System.out.println("----------------------");

        System.out.println("Total Usage   : " + total);
        System.out.println("Average Usage : " + average);
        System.out.println("Maximum Usage : " + maximum);
        System.out.println("Minimum Usage : " + minimum);
        System.out.println("Grade         : " + grade);
        System.out.println("Total Cost    : " + totalCost);

        System.out.println("\nHouse Usage:");

        for (int i = 0; i < houses.length; i++) {

            long houseTotal = 0;

            for (int j = 0; j < houses[i].length; j++) {
                houseTotal += houses[i][j];
            }

            System.out.println(
                "House " + (i + 1) +
                " Total: " + houseTotal
            );
        }
    }
}