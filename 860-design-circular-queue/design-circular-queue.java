class MyCircularQueue {

    int queue[];
    int front;
    int rear;
    int size;


    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        rear = 0;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        queue[rear%size] = value;
        rear++;

        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        front++;

        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return queue[front%size];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return queue[(rear-1+size)%size];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return (rear - front) == size;
    }
}


/* 
Constructive thinking:
    
    k = 10

    Array[10] -> [0,1,2,3,4,5,6,7,8,9]

        2 pointer : front and rear;

        front -> deQueue()
        rear -> enQueue()

        isEmpty() -> front == rear

        isFull() -> (front - rear + 1) == k

    
    queue = [1,2,3,4,5]
             f       r

            f = 6, r = 6  -> empty

            f = 1, r = 5 -> full

            4 - 0 + 1 == 5 -> full

            0 - 1 + 1 == 0 wrong 


    After complete cycle:

    queue = [1,2,3,4,5]
               r   f

        r - f + 1 = 1 - 3 + 1 = -1 that is wrong

*/

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */