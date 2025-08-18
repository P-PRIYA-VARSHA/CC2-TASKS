public class UglyNumber {

    public static boolean isUgly(int num) {
        if (num <= 0) return false;

        // Divide num by 2 as long as it is divisible by 2
        while (num % 2 == 0) {
            num /= 2;
        }
        
        // Divide num by 3 as long as it is divisible by 3
        while (num % 3 == 0) {
            num /= 3;
        }
        
        // Divide num by 5 as long as it is divisible by 5
        while (num % 5 == 0) {
            num /= 5;
        }
        
        // After dividing out 2,3,5, if num == 1 then it's ugly
        return num == 1;
    }

    public static void main(String[] args) {
        int testNum = 30;
        System.out.println(testNum + " is ugly? " + isUgly(testNum));
    }
}
