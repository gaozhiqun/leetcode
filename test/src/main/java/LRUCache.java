import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    //双向链表
    class DoubleLinkNode {
        DoubleLinkNode pre;//前指针
        DoubleLinkNode next;//后指针
        int key;
        int value;

        public DoubleLinkNode() {

        }

        public DoubleLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private Map<Integer, DoubleLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DoubleLinkNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;//当前容量大小
        this.capacity = capacity;//最大容量
        // 使用伪头部和伪尾部节点
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.next = tail;//头部下一个节点为尾部
        tail.pre = head;//尾部前一个节点为头部
    }

    public int get(int key) {
        DoubleLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //访问数据，将该节点移至双向链表头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkNode node = cache.get(key);
        if (node == null) {//之前没有，则新建添加
            DoubleLinkNode newNode = new DoubleLinkNode(key, value);
            //添加到哈希表
            cache.put(key, newNode);
            //添加到双向链表头部
            addToHead(newNode);
            size += 1;
            if (size > capacity) {//如果超过最大容量，则删除最后节点
                DoubleLinkNode tailNode = removeTail();
                //删除哈希表对应key
                cache.remove(tailNode.key);
                size -= 1;
            }
        } else {//之前存在，则更新对应的值
            node.value = value;
            //访问数据，将该节点移至双向链表头部
            moveToHead(node);
        }
    }


    /**
     * 移动节点到头部，使用两步：①将该节点删除 ②将节点添加到头部
     *
     * @param node
     * @return
     */
    private void moveToHead(DoubleLinkNode node) {
        removeNode(node);
        addToHead(node);
    }


    /**
     * 删除节点   只需修改前后指针的指向即可
     *
     * @param node
     */
    private void removeNode(DoubleLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 添加节点到头部
     *
     * @param node
     */
    private void addToHead(DoubleLinkNode node) {
        //这里就体现了伪头部的作用，我们不用去关心具体的细节，就假设之前已经有了这么一个head，
        //添加也只是修改前后指针的指向而已
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    /**
     * 删除尾部节点
     *
     * @return
     */
    private DoubleLinkNode removeTail() {
        //这里就体现了伪尾部的作用
        DoubleLinkNode tailNode = tail.pre;
        removeNode(tailNode);
        return tailNode;
    }

}
