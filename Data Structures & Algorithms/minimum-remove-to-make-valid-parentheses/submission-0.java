class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int idx = 0; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            if (Character.isLowerCase(c)) {
                continue;
            } else if (c == ')' && !stack.isEmpty()
            && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                stack.push(idx);
            }
        }

        // Using HashSet for constant lookup
        Set<Integer> idxToRemove = new HashSet<>(stack);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!idxToRemove.contains(i)) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}