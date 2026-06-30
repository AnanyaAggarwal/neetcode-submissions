class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 1) {
            return 1;
        }

        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> fleet = new Stack<>();
        int fleetCount = 0;

        for (int i = 0; i < n; i++) {
            int currPos = cars[i][0];
            int currSpeed = cars[i][1];
            double currTime = (double)(target - currPos) / currSpeed;
            if (fleet.isEmpty() || currTime > fleet.peek()) {
                fleet.push(currTime);
                fleetCount++;
            }
        }

        return fleetCount;
    }
}
