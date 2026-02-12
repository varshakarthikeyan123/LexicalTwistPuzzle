import java.util.Scanner;

public class LexicalTwistPuzzle {

    public static void main(String[] args) {

        System.out.println("Lexical Twist Puzzle");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first word: ");
        String firstWord = scanner.nextLine();

        System.out.print("Enter second word: ");
        String secondWord = scanner.nextLine();

        // UC3: Validate single word constraint
        if (firstWord.contains(" ")) {
            System.out.println(firstWord + " is an invalid word");
            return;
        }

        if (secondWord.contains(" ")) {
            System.out.println(secondWord + " is an invalid word");
            return;
        }

        // UC4: Reverse check
        String reversed = new StringBuilder(firstWord).reverse().toString();

        if (reversed.equalsIgnoreCase(secondWord)) {

            // UC5: Transform if reverse match
            String transformed = reversed
                    .toLowerCase()
                    .replaceAll("[aeiou]", "@");

            System.out.println(transformed);

        } else {

            // UC6: Combine and count
            String combined = (firstWord + secondWord).toUpperCase();

            int vowelCount = 0;
            int consonantCount = 0;

            for (char ch : combined.toCharArray()) {

                if ("AEIOU".indexOf(ch) != -1) {
                    vowelCount++;
                } else if (Character.isLetter(ch)) {
                    consonantCount++;
                }
            }

            // UC7: Rule-based output

            if (vowelCount > consonantCount) {

                int printed = 0;
                String printedChars = "";

                for (char ch : combined.toCharArray()) {
                    if ("AEIOU".indexOf(ch) != -1 &&
                            printedChars.indexOf(ch) == -1) {

                        System.out.print(ch);
                        printedChars += ch;
                        printed++;

                        if (printed == 2) break;
                    }
                }

            } else if (consonantCount > vowelCount) {

                int printed = 0;
                String printedChars = "";

                for (char ch : combined.toCharArray()) {
                    if (Character.isLetter(ch) &&
                            "AEIOU".indexOf(ch) == -1 &&
                            printedChars.indexOf(ch) == -1) {

                        System.out.print(ch);
                        printedChars += ch;
                        printed++;

                        if (printed == 2) break;
                    }
                }

            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }

        scanner.close();
    }
}
