public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(isSwitch(63));
        int[] arr = {1215,35,24,63,78,82,345,598};
        System.out.println( minSum(arr));
        int[] arr1 = {22,44,88,66,99,33};
        System.out.println(minSum(arr1));
    }
    public static boolean isSwitch(int number){
        if (number < 0){
            return false;
        }
        if (number < 10){
            return true;
        }
        while (true){
            int digit = number % 10;
            number = number / 10;
            if (number == 0){
                break;
            }
            int nextDigit = number % 10;
            if (!((digit % 2 == 0 && nextDigit % 2 != 0) || (digit % 2 != 0 && nextDigit % 2 == 0))){
                return false;
            }
        }
        return true;

    }
    public static int minSum (int[] switchingNumbers){
        int minSum = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < switchingNumbers.length ; i++) {
            if (isSwitch(switchingNumbers[i])){
                int sum = 0;
                while (switchingNumbers[i] > 0){
                    sum =  sum + switchingNumbers[i] % 10;
                    switchingNumbers[i] = switchingNumbers[i] / 10;
                }
                if (sum < minSum){
                    minSum = sum;
                    index = i;
                }
            }
        }
        return index;
    }
}
