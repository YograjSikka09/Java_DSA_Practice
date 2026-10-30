
import java.util.*;

class Solution {

    String[] mapping = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        backtrack(digits, 0, new StringBuilder(), res);

        return res;
    }

    private void backtrack(String digits, int index,
                           StringBuilder current, List<String> res) {

        if (index == digits.length()) {
            res.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            current.append(letters.charAt(i));

            backtrack(digits, index + 1, current, res);

            current.deleteCharAt(current.length() - 1);
        }
    }
}
