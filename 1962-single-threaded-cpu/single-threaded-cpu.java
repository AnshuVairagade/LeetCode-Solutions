class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];

        // shortest processing time waiting queue
        PriorityQueue<Task> pq = new PriorityQueue<>((t1,t2) -> {
            if(t1.processingTime == t2.processingTime){
                return t1.id - t2.id;
            }
            return t1.processingTime - t2.processingTime;
        });
        ArrayList<Task> taskList = new ArrayList<>();

        for(int i=0; i<n; i++){
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }

        // sort task with available time
        Collections.sort(taskList, (t1,t2) -> t1.enqueTime - t2.enqueTime);

        int i = 0;
        int endTime = taskList.get(0).enqueTime;
        
        // enqueu multiple starting tasks
        while(i<n && taskList.get(i).enqueTime == taskList.get(0).enqueTime){
            pq.offer(taskList.get(i));
            i++;
        }

        int j = 0;
        while(!pq.isEmpty()){
            // end previous and pick shortest from waiting queue
            Task currentTask = pq.poll();
            endTime = endTime + currentTask.processingTime;
            res[j++] = currentTask.id;
            System.out.println(currentTask.enqueTime);

            // equeue all available task
            while((i < n && taskList.get(i).enqueTime <= endTime)){
                System.out.println("    " + taskList.get(i).enqueTime);
                pq.offer(taskList.get(i));
                i++;
            }

            // restart time after idle period
            if(pq.isEmpty() && i < n){
                endTime = taskList.get(i).enqueTime;
                // FIX: Enqueue ALL tasks that become available at this time
                while(i < n && taskList.get(i).enqueTime == endTime){
                    pq.offer(taskList.get(i));
                    i++;
                }
            }
        }

        return res;
    }

}

class Task{
    int id;
    int enqueTime;
    int processingTime;

    public Task(int id, int enqueTime, int processingTime){
        this.id = id;
        this.enqueTime = enqueTime;
        this.processingTime = processingTime;
    }
}

/*

pointer : task
time : 1,2,3,4,....

Task become available at time "t"

[[1,2],[2,4],[3,2],[4,1]]

1) Sort tasks on the basis of enqueue time

[[1,2],[2,4],[3,2],[4,1]]

2) At every second: 
    if(time < task[enqueue]){
        i++;
        time++;
        continue;
    }

    enqueue current task into waiting queue

    if(task is executing):  -> endtime > time
        continue;
    else:
        pick the shortest task from the waiting queue
        endtime = time + task[processing]




Waiting queue -> poll() -> shortest time
    => PriorityQueue<int[]> : built for polling task with shortest processing



[[1,2],[2,4],[3,2],[4,1]]

time   = 1
i  = 0
pq     =


*/



/*

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];

        PriorityQueue<Task> pq = new PriorityQueue<>(
                                (t1,t2) -> t1.processingTime - t2.processingTime);
        ArrayList<Task> taskList = new ArrayList<>();

        for(int i=0; i<n; i++){
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(taskList, (t1,t2) -> t1.enqueTime - t2.enqueTime);

        int i = 1;
        int endTime = taskList.get(0).enqueTime + taskList.get(0).processingTime;
        res[0] = taskList.get(0).id;

        int j = 1;
        while(pq.isEmpty()){
            // equeue all available task
            // end previous and pick shortest from waiting queue

            while(i < n && taskList.get(i).enqueTime <= endTime){
                pq.offer(taskList.get(i));
                i++;
            }

            Task currentTask = pq.poll();
            endTime = endTime + currentTask.processingTime;
            res[j++] = currentTask.id;
        }

        return res;
    }

}


*/