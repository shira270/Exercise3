public static void main(String[] args) {

    //check
        for (int i = 0; i <arrayLength(54) ; i++) {
          
           System.out.println(dividesNumber(54)[i]);
        }
    }

    public static int [] dividesNumber(int number) {

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
        return primaryFactors;
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

