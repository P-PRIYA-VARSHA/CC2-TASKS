public class ProductArray {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // answer[i] will hold the product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // R will hold the product of all elements to the right of i
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            // multiply the product of elements to the right
            answer[i] = answer[i] * R;
            R = R * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);

        System.out.print("Product array: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
