class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int[] countP = new int[26];
        int[] countS = new int[26];

        for (int i = 0; i < p.length(); i++) {
            countP[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {

            countS[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                countS[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(countP, countS)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
