package arrays;

public class SearchElementInSortedRotatedArray {

	static int findPivot(int arr[], int low, int high) {
		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}

	public static void main(String[] args) {
		
		int arr[] = { 2, 3, 4, 5, 1 };
		System.out.println(findPivot(arr, 0, arr.length - 1));
	}
	
	static int search(int arr[], int l, int h, int key)
    {
        if (l > h) 
            return -1;
       
        int mid = (l+h)/2;
        if (arr[mid] == key)
            return mid;
       
        if (arr[l] <= arr[mid])
        {
            if (key >= arr[l] && key <= arr[mid])
               return search(arr, l, mid-1, key);
       
            return search(arr, mid+1, h, key);
        }
       
		if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid+1, h, key);
       
        return search(arr, l, mid-1, key);
    }

}
