package dyd.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Q00347_TopKFrequentElements {
    static class Frequency implements Comparable<Frequency> {
        int num;
        int frequency;

        public Frequency(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }

        public int getNum() {
            return num;
        }

        @Override
        public int compareTo(Frequency f) {
            if (frequency < f.frequency) {
                return -1;
            } else if (frequency > f.frequency) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Frequency> frequencies = countFrequency(nums);
        return findTopK(frequencies, k);
    }

    private List<Frequency> countFrequency(int[] nums) {
        Map<Integer, Frequency> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Frequency frequency = frequencyMap.get(nums[i]);
            if (frequency == null) {
                frequency = new Frequency(nums[i], 0);
                frequencyMap.put(nums[i], frequency);
            }
            frequency.frequency = frequency.frequency + 1;
        }
        List<Frequency> frequencies = new ArrayList();
        frequencies.addAll(frequencyMap.values());
        return frequencies;
    }

    private List<Integer> findTopK(List<Frequency> frequencies, int k) {
        PriorityQueue<Frequency> heap = new PriorityQueue();
        for (Frequency frequency : frequencies) {
            heap.add(frequency);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.stream().map(Frequency::getNum).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        test(new int[] {1,1,1,2,2,3}, 2);
        test(new int[] {1}, 1);
    }

    private static void test(int[] nums, int k) {
        Q00347_TopKFrequentElements q = new Q00347_TopKFrequentElements();
        System.out.println("nums[]=" + Arrays.toString(nums) + ", k=" + k);
        System.out.println(q.topKFrequent(nums, k));
    }
}
