public class LexicalAnalyzer {

    public boolean isReverseMatch(String firstWord, String secondWord) {
        String reversed = new StringBuilder(firstWord).reverse().toString();
        return reversed.equalsIgnoreCase(secondWord);
    }

    public String transformWord(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return reversed.toLowerCase().replaceAll("[aeiou]", "@");
    }

    public void processNonReverse(String firstWord, String secondWord) {

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

        if (vowelCount > consonantCount) {
            printUniqueCharacters(combined, true);
        } else if (consonantCount > vowelCount) {
            printUniqueCharacters(combined, false);
        } else {
            System.out.println("Vowels and consonants are equal");
        }
    }

    private void printUniqueCharacters(String text, boolean vowels) {

        int printed = 0;
        String printedChars = "";

        for (char ch : text.toCharArray()) {

            if (vowels) {
                if ("AEIOU".indexOf(ch) != -1 &&
                        printedChars.indexOf(ch) == -1) {

                    System.out.print(ch);
                    printedChars += ch;
                    printed++;
                }
            } else {
                if (Character.isLetter(ch) &&
                        "AEIOU".indexOf(ch) == -1 &&
                        printedChars.indexOf(ch) == -1) {

                    System.out.print(ch);
                    printedChars += ch;
                    printed++;
                }
            }

            if (printed == 2) break;
        }
    }
}
