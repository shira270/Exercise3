public class Exercise3 {
    public static void main(String[] args) {
        System.out.println(dividesNumber(18));


    }

    public static int dividesNumber(int number) {

        int[] primaryFactors = new int[arrayLength(number)];
        int prime = 2;
        int i = 0;
        while (number > 1) {
            if (number % prime == 0) {
                primaryFactors[i] = prime;
                number = number / prime;
                i++;
            } else {
                prime++;
            }
        }
        return prime;
    }

    public static int arrayLength(int number) {
        int prime = 2;
        int counter = 0;
        while (number > 1) {
            if (number % prime == 0) {
                number = number / prime;
                counter++;
            } else {
                prime++;
            }
        }
        return counter;
    }
}

