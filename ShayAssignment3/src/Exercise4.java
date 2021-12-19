public class Exercise4 {
        public static void main(String[] args) {
            int[] arr = {6, 5, 8, 7, 0};

            System.out.println(checkAFullArrayNumbers(orderArray(arr)));

        }

        public static int[] orderArray(int[] arr) {
            int tampNumber;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        tampNumber = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tampNumber;
                    }
                }
            }

            return arr;}
        public static boolean checkAFullArrayNumbers(int []arr){
            boolean fullArray = true;

            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] != (arr[i+1]+1)) {
                    fullArray = false;
                }
            }
            return fullArray;
        }

    }

