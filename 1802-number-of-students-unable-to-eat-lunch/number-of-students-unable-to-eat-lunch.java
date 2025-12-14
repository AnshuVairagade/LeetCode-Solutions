class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        int n = sandwiches.length;

        for(int std : students){
            queue.offer(std);
        }

        for(int i=0; i<n; i++){
            int rot = 0;
            while(rot<n-i){
                int std = queue.poll();
                if(std == sandwiches[i]){
                    break;
                }
                queue.offer(std);
                rot++;
            }
            if(rot>=n-i) return queue.size();
        }

        return 0;
    }
}


/* Dry Run :

[1, 1, 0, 0, 1]
[0, 0, 0, 1, 1]

[1, 0, 0, 1, 1]
[0, 0, 0, 1, 1]

[0, 0, 1, 1, 1]
[0, 0, 0, 1, 1]

[0, 1, 1, 1]
[0, 0, 1, 1]

[1, 1, 1]
[0, 1, 1]

[1, 1, 1]
[0, 1, 1]

[1, 1, 1]
[0, 1, 1]


Condition : When they cannot eat => Student choice is different thant top sandwich

For a type of sandwich if total rotation >= queue.size() -> return queue.size()

*/
