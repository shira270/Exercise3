import java.util.Random;
import java.util.Scanner;

public class FIX99 {
        public static void main(String[] args) {
            Random randomNumber = new Random();
            int secretCode;
            do {
                secretCode = randomNumber.nextInt(5210)+ 1234;
            } while (!codeAvailable(secretCode));
            System.out.println(secretCode);
            String code = Integer.toString(secretCode);
            guessGamePlay(code);
        }
        public static int selectLevel(){
            Scanner scanner = new Scanner(System.in);
            int levelOfTry;
            do {
                System.out.println("Select a level: ");
                System.out.println("press 1 for 20 tries:");
                System.out.println("press 2 for 15 tries:");
                System.out.println("press 3 for 10 tries:");
                System.out.println("press 4 for 5-25 tries:");
                levelOfTry = scanner.nextInt();
            } while (levelOfTry > 4 | levelOfTry < 1);
            return levelOfTry;
        }
        public static boolean codeAvailable (int secretCode){
            boolean codeNotTaken = false;
            if (inTheRangeOfTheLimits(secretCode) && checkIfTheNumberIsRepeated(secretCode)){
                codeNotTaken = true;
            }
            return codeNotTaken;
        }

        public static boolean checkIfTheNumberIsRepeated(int code) {
            boolean notRepeatedNumbers = true;
            String theCode=""+code;
            while (code != 0) {
                if (theCode.charAt(3) != theCode.charAt(2) &&
                        theCode.charAt(3) != theCode.charAt(1) &&
                        theCode.charAt(3) != theCode.charAt(0) &&
                        theCode.charAt(2) != theCode.charAt(1) &&
                        theCode.charAt(2) != theCode.charAt(0) &&
                        theCode.charAt(1) != theCode.charAt(0)) {
                    code = code / 10;
                } else {
                    notRepeatedNumbers = false;
                    break;
                }
            }
            return notRepeatedNumbers;
        }

        public static boolean inTheRangeOfTheLimits(int code){
            String stringCode=""+code;
            int lastDigit = stringCode.charAt(3) - '0';
            boolean notTaken = true;
            if (code < 1000 | code > 6666){
                notTaken = false;
            }

            for (int i = 0; stringCode.length() > i; i++) {
                if ((int) stringCode.charAt(i) > 54 || (int) stringCode.charAt(i) < 49) {
                    notTaken = false;
                    break;
                }
            }
            while (code != 0){
                if (lastDigit != 0 &&  lastDigit != 7 && lastDigit != 8 && lastDigit !=9){
                    code = code / 10;
                } else {
                    notTaken = false;
                    break;
                }
            }
            return notTaken;
        }


        public static void guessGamePlay (String code){
            Scanner scanner = new Scanner(System.in);
            int howManyTriesLeft = 0;
            int level = (selectLevel());
            switch (level){
                case 1: howManyTriesLeft = 20;
                    break;
                case 2: howManyTriesLeft = 15;
                    break;
                case 3: howManyTriesLeft = 10;
                    break;
                case 4: howManyTriesLeft = 25;
                    break;
            }
            int enterCode;
            String codeGuessString = "";
            do { do {
                if (level == 4) {
                    System.out.println("Enter four digits from 1 to 6: ");
                } else {
                    System.out.println("There are: " + howManyTriesLeft + " tries.Enter four digits from 1 to 6: ");
                }
                enterCode = scanner.nextInt();
                if (inTheRangeOfTheLimits(enterCode)) {
                    if (!inTheRangeOfTheLimits(enterCode)){
                        howManyTriesLeft = howManyTriesLeft - 1;
                        System.out.println("You have put the same numbers " +
                                "you lost 2 tries");
                    }
                    howManyTriesLeft--;
                    codeGuessString = Integer.toString(enterCode);
                    guessesLocation(code, codeGuessString);
                }
            } while (!inTheRangeOfTheLimits(enterCode));
            } while (!revealCode(code, codeGuessString) && howManyTriesLeft >= 0);
            if (revealCode(code, codeGuessString)){
                System.out.println("you have won!");
            } else
            {System.out.println("You have lost, The code is : " + code);
            }
        }

        public static void guessesLocation(String code, String codeGuessString){
            int fullyCorrectGuessedNumber = 0;
            int halfCorrectGuessedNumber = 0;
            for (int i = 0; i < code.length(); i++){
                for (int j = 0; j < codeGuessString.length(); j++){
                    if (code.charAt(i) == codeGuessString.charAt(j)){
                        if (i == j){
                            fullyCorrectGuessedNumber+=1;
                        } else {
                            halfCorrectGuessedNumber+=1;
                        }
                        break;
                    }}}
            System.out.println("You got " + fullyCorrectGuessedNumber+" in the right location");
            System.out.println("There are correct " + halfCorrectGuessedNumber+" correct numbers but not at the right location");
        }

        public static boolean revealCode (String code, String inputCode){
            boolean revealing = true;
            for (int i= 0; i < 4; i++){
                if (code.charAt(i) != inputCode.charAt(i)) {
                    revealing = false;
                    break;
                }
            }
            return revealing;
        }
    }
