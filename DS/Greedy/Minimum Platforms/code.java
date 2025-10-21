import java.util.*;

class Solution {
    static class Train {
        int arrival, departure;
        Train(int a, int d) {
            this.arrival = a;
            this.departure = d;
        }
    }

    public int minPlatform(int[] arr, int[] dep) {
        int n = arr.length;
        List<Train> trains = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            trains.add(new Train(arr[i], dep[i]));
        }
        
        // Sort by arrival time
        trains.sort(Comparator.comparingInt(t -> t.arrival));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // stores departure times
        int maxPlatforms = 0;
        
        for (Train train : trains) {
            // Free up platforms for trains that have departed
            while (!minHeap.isEmpty() && minHeap.peek() < train.arrival) {
                minHeap.poll();
            }
            
            // Allocate platform for this train
            minHeap.offer(train.departure);
            
            // Track max platforms used
            maxPlatforms = Math.max(maxPlatforms, minHeap.size());
        }
        
        return maxPlatforms;
    }
}


// class Solution {
//     public int minPlatform(int arr[], int dep[]) {
//         Arrays.sort(arr);
//         Arrays.sort(dep);
        
//         int count=0;
//         int maxCount=0;
        
//         int i=0;
//         int j=0;
        
//         while(i<arr.length){
//             if(arr[i]<=dep[j]){
//                 count++;
//                 i=i+1;
//             } else {
//                 count--;
//                 j=j+1;
//             }
            
//             maxCount=Math.max(count, maxCount);
//         }
        
//         return maxCount;
//     }
// }
