class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[128];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        for(int right =0; right<s.length(); right++){
            char c = s.charAt(right);
            freq[c-'A']++;
            maxFreq = Math.max(maxFreq, freq[c-'A']);
            while((right-left+1)-maxFreq>k){
                char leftChar = s.charAt(left);
                freq[leftChar-'A']--;
                left++;
            }
            int wLength = right-left+1;
            maxLength = Math.max(maxLength,wLength);

        }
        return maxLength;
    }
}
