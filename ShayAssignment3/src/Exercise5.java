import java.util.Scanner;
public class Exercise5 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your text");
            String text = scanner.nextLine();
            int len = text.length();
            char [] seenAlready = new char[len];
            int [] counters = new int[len];
            for (int i = 0; i < len; i++) {
                char c = text.charAt(i);
                if (isExist(seenAlready, c) || c == ' ')
                    continue;
                seenAlready[i] = c;
                for (int j = 0; j < len; j++) {
                    if (c == text.charAt(j)) {
                        counters[i]++;
                    }
                }
            }
            int max1 = findMaxIndex(counters);
            counters[max1] = 0;
            int max2 = findMaxIndex(counters);
             System.out.println("max index is " + max1 + " the char is " + text.charAt(max1));
             System.out.println("max index is " + max2 + " the char is " + text.charAt(max2));
            char maxChar = text.charAt(max1);
            char secondMaxChar = text.charAt(max2);
            char[] newText = replaceChars(text, maxChar, secondMaxChar);
            System.out.println(newText);


        }

        private static char[] replaceChars(String text, char maxChar, char secondMaxChar) {
            char[] newText = new char[text.length()];
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c == maxChar) {
                    newText[i] = secondMaxChar;
                }
                else if (c == secondMaxChar) {
                    newText[i] = maxChar;
                }
                else {
                    newText[i] = c;
                }
            }
            return newText;
        }

        private static int findMaxIndex(int[] counters) {
            int max = 0;
            for (int i = 0; i < counters.length; i++ ) {
                if (counters[max] < counters[i]) {
                    max = i;
                }
            }
            return max;
        }

        private static boolean isExist(char[] seenAlready, char c) {
            for (int i = 0; i < seenAlready.length; i++) {
                if (c == seenAlready[i])
                    return true;
            }
            return false;
        }
    }

