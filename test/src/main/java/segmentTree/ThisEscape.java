package segmentTree;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/9/3 上午10:43
 */
public class ThisEscape {
    /**
     * 在构造器构造还未彻底完成前（即实例初始化阶段还未完成），
     * 将自身this引用向外抛出并被其他线程复制（访问）了该引用，可能会问到该还未被初始化的变量，甚至可能会造成更大严重的问题。
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //可能会发生初始化失败的情况解释：实例变量i的初始化被重排序到构造器外，此时1还未被初始化
                ThisEscape objB = thisEscape;
                try {
                    System.out.println(objB.j);
                } catch (NullPointerException e) {
                    System.out.println("发生空指针错误：普通变量j未被初始化");
                }
                try {
                    System.out.println(objB.i);
                } catch (NullPointerException e) {
                    System.out.println("发生空指针错误：final变量i未被初始化");
                }
            }
        });
        //threadA.start();
        threadB.start();
    }

    final int i;
    int j = 0;
    static ThisEscape thisEscape;

    public ThisEscape() {
        this.i = 1;
        j = 1;
        thisEscape = this;

    }
    //final常量会保证在构造器内完成初始化（但是仅限于未发生this逃逸的情况下，具体可以看多线程对final保证可见性的实现）

}
