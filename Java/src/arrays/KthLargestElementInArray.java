package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
  public static void main(String[] args) {
    System.out.println(new KthLargestElementInArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
  }

  // https://www.youtube.com/watch?v=hiUYgtCxJFI
  public int findKthLargest(int[] nums, int k) {
    int left = 0;
    int right = nums.length -1;
    while(true) {
      int pos = partition(nums, left, right);
      if(pos == k-1 ) {
        return nums[pos];
      }
      else if(pos < k-1){
        left++;
      } else if(pos > k-1) {
        right--;
      }
    }
  }

  public int partition(int[] nums, int left, int right) {
    int pivot = nums[left];
    int l = left + 1;
    int r = right;

    while(l <= r) {
      if(nums[l] < pivot && nums[r] > pivot) {
        swap(nums, l, r);
      } else if(nums[l] >= pivot) {
        l++;
      } else if(nums[r] <= pivot) {
        r--;
      }
    }
    swap(nums, left, r);
    return r;
  }

  public void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public int findKthLargest2(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
    for(int n: nums) {
      pq.add(n);
      if(pq.size() > k) {
        pq.poll();
      }
    }
    return pq.peek();
  }

  public int findKthLargest3(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }
}
