class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() &&
                   temperatures[st.peek()] < temperatures[i]) {

                int prev = st.pop();
                answer[prev] = i - prev;
            }

            st.push(i);
        }

        return answer;
    }
}
