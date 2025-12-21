class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.offer(num);
        }
        else minHeap.offer(num);

        // Adjust the order of elements
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size()+1){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        double median;

        if(maxHeap.size() == minHeap.size()){
            // Bug of integer division            V <---- solved using double
            median = ((double)maxHeap.peek() + (double)minHeap.peek())/2;
        }
        else if(maxHeap.size() > minHeap.size()) median = maxHeap.peek();
        else median = minHeap.peek();

        return median;
    }
}


/* Intuition : 
-----------------
Median is always calculated for the sorted stream 
and sorted stream can be divided into two logical parts

Runtime min and max by heaps reduces overhead of sorting for each stream element
Improving time complexity from O(n*n*Log(n)) to O(n*Log(n))


Approach:
------------

Stream = [1,3,4,2,6,5]

Sorting = [1,2,3,4,5,6]
                |        <-- logical partition

maxHeap = [1, 2, 3]  | [4, 5, 6] = minHeap

median = (3+4)/2 = 3.5

*/


/*
Brute Force:
-------------
1) Maintain list for stream element
2) sort list at each insertion and calculate median based on even odd length 


Why Brute force gives TLE
------------------------

Constraints allow up to 5 * 10⁴ total calls to addNum and findMedian.

Worst case scenario
You keep calling findMedian after many insertions.

Example
After 1 insertion you sort 1 element
After 2 insertions you sort 2 elements
After 3 insertions you sort 3 elements
...
After 50000 insertions you sort 50000 elements

Total work becomes roughly
1 log 1 + 2 log 2 + 3 log 3 + ... + n log n

This grows close to O(n² log n) overall, which is far too slow and results in TLE.


class MedianFinder {
    List<Double> list;

    public MedianFinder() {
        list =  new ArrayList<>();
    }
    
    public void addNum(int num) {
        double n = (double)num;
        list.add(n);
    }
    
    public double findMedian() {
        Collections.sort(list);
        int n = list.size();

        double median;
        int mid = n/2;
        if(n%2 == 0){
            median = (list.get(mid-1) + list.get(mid))/2;
        }
        else {
            median = list.get(mid);
        }

        return median;
    }
}


*/


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */