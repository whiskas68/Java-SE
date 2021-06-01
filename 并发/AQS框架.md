# AQS框架

JUC包的核心。主要涉及以下内容：抢锁，入队，堵塞，唤醒，出队，释放锁

**关键字**： CLH队列，双向链表，排队

```
static final class Node {
    /** Marker to indicate a node is waiting in shared mode */
    static final Node SHARED = new Node();
    /** Marker to indicate a node is waiting in exclusive mode */
    static final Node EXCLUSIVE = null;

    /** waitStatus value to indicate thread has cancelled */
    static final int CANCELLED =  1;
    /** waitStatus value to indicate successor's thread needs unparking */
    static final int SIGNAL    = -1;
    /** waitStatus value to indicate thread is waiting on condition */
    static final int CONDITION = -2;
    /**
     * waitStatus value to indicate the next acquireShared should
     * unconditionally propagate
     */
    static final int PROPAGATE = -3;
    volatile int waitStatus;
    volatile Node prev;
    volatile Node next;
    volatile Thread thread;
    Node nextWaiter;
```



## 通过state标志位和FIFO等待队列来管理多线程的同步状态

**抢锁**

1. tryAccquire()方法，尝试获取锁（修改标记位），立即返回

   ```
   protected boolean tryAcquire(int arg) {
       throw new UnsupportedOperationException();
   }
   // 允许上层业务代码自行实现，对获取锁的设计（通过int参数修改state状态）
   ```

   

2. accquire()方法，获取锁，可以进入队列等待，直到获取锁

```
public final void acquire(int arg) {
// tryAcquire(arg)获得锁，则不再进行后面的判断和执行
// 获取不到锁，进行尝试排队操作addWaiter()方法和acquireQueued()方法
    if (!tryAcquire(arg) &&
        acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
        selfInterrupt();
}
```



**入队**

```java
...
private Node addWaiter(Node mode) {
        Node node = new Node(Thread.currentThread(), mode);
        // Try the fast path of enq; backup to full enq on failure
        // 尝试快速入队，将新建的节点插入到队尾
        //获取尾节点的指针，
        Node pred = tail;
        
        if (pred != null) {  //如果尾节点不为空
            //则将尾节点作为当前节点的前驱节点
            node.prev = pred;
            if (compareAndSetTail(pred, node)) {  // 将当前节点设置为尾节点
                pred.next = node; //不存在线程安全，不管是哪个线程，都将前驱节点的下个节点指针指向当前节点
                return node;
            }
        }
        enq(node);
        return node;
    }

private Node enq(final Node node) {
        for (;;) {
            Node t = tail;
            if (t == null) { // Must initialize
                if (compareAndSetHead(new Node()))
                    tail = head;
            } else {
                node.prev = t;
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }
        }
}

```

备注：在完整入队（调用enq方法）之前，会优先进行一次入队的尝试（判断尾节点是否为空），之后在进行入队操作。由于enq方法本身是自旋操作，会带来性能开销。因此才会有这样的设计，来提升性能（前后两者（addWaiter方法和enq方法都进行了入队操作）的操作的区别在于，前者多了一次判空的操作）。





