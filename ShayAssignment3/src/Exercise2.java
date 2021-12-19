public class Exercise2 {
    public static void main(String[] args) {
        int[] arr1 = {14,11,13,14,15};
        int[] arr2 = {16,2,21,19,1};
        System.out.println(siblingsNumbers(arr1 ,arr2));

    }

    public static int siblingsNumbers(int[] arr1,  int[] arr2){
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            int checkingForBrothers = brotherCount(arr2 ,arr1[i]);
            if (checkingForBrothers > max){
                max = checkingForBrothers;
                index = i;
            }
        }
        return index;
    }
    public static int brotherCount(int[] arr, int num){
        int sumDigit = digitSum(num);
        int countBrothers = 0;
        for (int i = 0; i < arr.length ; i++) {
            int sumArr = digitSum(arr[i]);
            if (sumDigit == sumArr ){
                countBrothers++;
            }


        }
        return countBrothers;

    }

    public static int digitSum(int num){
        int sum = 0;
        while (num > 0){
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

}
