public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String paran) {
        int openBracketCount = 0;

        for (char c : paran.toCharArray()) {
            if (c == '(') {
                openBracketCount++;
            } else if (c == ')') {
                openBracketCount--;
            }

            // Early exit if more closing brackets than opening
            if (openBracketCount < 0) {
                return false;
            }
        }
        return openBracketCount == 0;
    }

    // 2. reverseInteger

    public static String reverseInteger(int foo) {
        String numStr = Integer.toString(foo);
        String res = "";
        for (int i = numStr.length() - 1; i >= 0; i--) {
            res += numStr.charAt(i);
        }
        return res;

    }

    // 3. encryptThis

    public static String encryptThis(String str) {
        String[] words = str.split(" ");
        String res = "";
        for (String word : words) {
            String new_word = "";
            new_word += (int) word.charAt(0);
            if (word.length() > 2) {
                char last_index = word.charAt(word.length() - 1);
                char second_index = word.charAt(1);
                new_word += last_index;
                new_word += word.substring(2, word.length() - 1);
                new_word += second_index;
            } else if (word.length() == 2) {
                new_word += word.charAt(1);
            }
            res += new_word + " ";
        }
        return res.trim();
    }


    // 4. decipherThis
    public static String decipherThis(String str) {
        String[] words = str.split(" ");
        String res = "";
        for (String word : words) {
            String new_word = "";
            String asciiCode = "";
            int i = 0;
            while (i < word.length() && Character.isDigit(word.charAt(i))) { //Extract Ascii code.
                asciiCode += word.charAt(i);
                i++;
            }
            new_word += (char) Integer.parseInt(asciiCode);

            if (word.length()-i > 1) { //Handle words with more than 2 chars remaining after ascii code
                char secondChar = word.charAt(word.length() - 1);
                String middlePart = word.substring(i + 1, word.length() - 1);
                new_word += secondChar + middlePart + word.charAt(i);

            } else if ((word.length()-i) == 1) {
                new_word += word.charAt(i);
            }
            res += new_word + " ";

        }
        return res.trim();
        }
}