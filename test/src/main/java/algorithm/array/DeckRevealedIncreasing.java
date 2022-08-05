package algorithm.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/10/21 下午7:33
 */
public class DeckRevealedIncreasing {
    public static void main(String[] args) {
        DeckRevealedIncreasing deckRevealedIncreasing = new DeckRevealedIncreasing();
        System.out.println(deckRevealedIncreasing.deckRevealedIncreasing(new int[]{
                17, 13, 11, 2, 3, 5, 7
        }));
    }

    /**
     * 逆行过程
     *
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        int[] ans = new int[N];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; ++i) {
            deque.offer(i);
        }
        Arrays.sort(deck);
        for (int i : deck) {
            ans[deque.pollFirst()] = i;
            if (!deque.isEmpty()) {
                deque.offer(deque.pollFirst());
            }
        }
        return ans;
    }
}
