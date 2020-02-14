package dyd.leetcode;

import javax.swing.plaf.TableHeaderUI;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1188. Design Bounded Blocking Queue -- Medium
 *
 * Implement a thread safe bounded blocking queue that has the following methods:
 *
 * BoundedBlockingQueue(int capacity) The constructor initializes the queue with a maximum capacity.
 * void enqueue(int element) Adds an element to the front of the queue. If the queue is full, the calling thread is
 * blocked until the queue is no longer full.
 * int dequeue() Returns the element at the rear of the queue and removes it. If the queue is empty, the calling thread
 * is blocked until the queue is no longer empty.
 * int size() Returns the number of elements currently in the queue.
 * Your implementation will be tested using multiple threads at the same time. Each thread will either be a producer
 * thread that only makes calls to the enqueue method or a consumer thread that only makes calls to the dequeue method.
 * The size method will be called after every test case.
 *
 * Please do not use built-in implementations of bounded blocking queue as this will not be accepted in an interview.
 *
 * Example 1:
 *
 * Input:
 * 1
 * 1
 * ["BoundedBlockingQueue","enqueue","dequeue","dequeue","enqueue","enqueue","enqueue","enqueue","dequeue"]
 * [[2],[1],[],[],[0],[2],[3],[4],[]]
 *
 * Output:
 * [1,0,2,2]
 *
 * Explanation:
 * Number of producer threads = 1
 * Number of consumer threads = 1
 *
 * BoundedBlockingQueue queue = new BoundedBlockingQueue(2);   // initialize the queue with capacity = 2.
 *
 * queue.enqueue(1);   // The producer thread enqueues 1 to the queue.
 * queue.dequeue();    // The consumer thread calls dequeue and returns 1 from the queue.
 * queue.dequeue();    // Since the queue is empty, the consumer thread is blocked.
 * queue.enqueue(0);   // The producer thread enqueues 0 to the queue. The consumer thread is unblocked and returns 0
 *      // from the queue.
 * queue.enqueue(2);   // The producer thread enqueues 2 to the queue.
 * queue.enqueue(3);   // The producer thread enqueues 3 to the queue.
 * queue.enqueue(4);   // The producer thread is blocked because the queue's capacity (2) is reached.
 * queue.dequeue();    // The consumer thread returns 2 from the queue. The producer thread is unblocked and enqueues 4
 *      // to the queue.
 * queue.size();       // 2 elements remaining in the queue. size() is always called at the end of each test case.
 *
 *
 * Example 2:
 *
 * Input:
 * 3
 * 4
 * ["BoundedBlockingQueue","enqueue","enqueue","enqueue","dequeue","dequeue","dequeue","enqueue"]
 * [[3],[1],[0],[2],[],[],[],[3]]
 *
 * Output:
 * [1,0,2,1]
 *
 * Explanation:
 * Number of producer threads = 3
 * Number of consumer threads = 4
 *
 * BoundedBlockingQueue queue = new BoundedBlockingQueue(3);   // initialize the queue with capacity = 3.
 *
 * queue.enqueue(1);   // Producer thread P1 enqueues 1 to the queue.
 * queue.enqueue(0);   // Producer thread P2 enqueues 0 to the queue.
 * queue.enqueue(2);   // Producer thread P3 enqueues 2 to the queue.
 * queue.dequeue();    // Consumer thread C1 calls dequeue.
 * queue.dequeue();    // Consumer thread C2 calls dequeue.
 * queue.dequeue();    // Consumer thread C3 calls dequeue.
 * queue.enqueue(3);   // One of the producer threads enqueues 3 to the queue.
 * queue.size();       // 1 element remaining in the queue.
 *
 * Since the number of threads for producer/consumer is greater than 1, we do not know how the threads will be scheduled in the operating system, even though the input seems to imply the ordering. Therefore, any of the output [1,0,2] or [1,2,0] or [0,1,2] or [0,2,1] or [2,0,1] or [2,1,0] will be accepted.
 */
public class Q01188_DesignBoundedBlockingQueue {

    private int capacity;
    private Queue<Integer> queue;
    private ReentrantLock lock;
    private Condition queueFullCondition;
    private Condition queueEmptyCondition;

    public Q01188_DesignBoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        lock = new ReentrantLock();
        queueFullCondition = lock.newCondition();
        queueEmptyCondition = lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();

        try {
            while (queue.size() == capacity) {
                queueFullCondition.await();
            }

            queue.add(element);
            queueEmptyCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();

        try {
            while (queue.size() == 0) {
                queueEmptyCondition.await();
            }

            int res = queue.remove();
            queueFullCondition.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.tryLock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final Q01188_DesignBoundedBlockingQueue queue = new Q01188_DesignBoundedBlockingQueue(3);
        final int[] inputs = new int[] {1, 2, 3, 4, 5};

        Runnable r1 = () -> {
            for (int num : inputs) {
                try {
                    System.out.printf("start enqueuing %d...\n", num);
                    queue.enqueue(num);
                    System.out.printf("enqueue %d done\n", num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < inputs.length; i++) {
                try {
                    System.out.printf("start dequeuing ...\n");
                    int num = queue.dequeue();
                    System.out.printf("dequeue %d done\n", num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
