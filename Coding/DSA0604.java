package Coding;

/**
 * 
 * **************UBER***************
 * Given an unsorted array of integers which represent time taken by any bus
 * (repesented by index i) to complete one trip. Given total number of trips n,
 * find min time taken by bus to complete all trips. There is not time interval
 * for any bus.
 */

public class DSA0604 {

    public static int minimumTimeTaken(int totalTrips, int[] cabTimeArray) {
        // find minimum time taken by any cab
        int time = getMinTime(cabTimeArray);
        int low = 1, high = totalTrips * time;
        int mid = -1;
        while (low < high) {
            mid = (low + high) / 2;
            // number of trips complted at any given time
            int numOfTripsCompleted = tripsCompleted(cabTimeArray, mid);
            if (numOfTripsCompleted >= totalTrips) {
                // if trips is more might be this is the min possile value
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private static int tripsCompleted(int[] cabTimeArray, int mid) {
        int trips = 0;
        for (int i = 0; i < cabTimeArray.length; i++) {
            // givenTime/num Of Trips by a cab
            trips += mid / cabTimeArray[i];
        }
        return trips;

    }

    private static int getMinTime(int[] cabTimeArray) {
        int result = cabTimeArray[0];

        for (int i = 1; i < cabTimeArray.length; i++) {
            result = Math.min(result, cabTimeArray[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7, 8 };
        System.out.println(minimumTimeTaken(10, array));
    }
}
