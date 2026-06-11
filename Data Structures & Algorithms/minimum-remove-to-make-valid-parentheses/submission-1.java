class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder temp = new StringBuilder();
        int count = 0; // extra open brackets

        // Remove invalid close brackets and build the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                temp.append(c);
                count++;
            } else if (c == ')' && count > 0) {
                temp.append(c);
                count--;
            } else if (Character.isLowerCase(c)) {
                temp.append(c);
            }
        }

        // Remove any extra open brackets by using count
        StringBuilder res = new StringBuilder();
        for (int i = temp.length() - 1; i >= 0; i--) {
            char c = temp.charAt(i);
            if (count > 0 && c == '(') {
                count--;
            } else {
                res.append(c);
            }
        }

        return res.reverse().toString();
    }
}