import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, maxLength = 0;
        HashSet<Character> Set = new HashSet<>();
        for(int right=0;right<n;right++){
            while(Set.contains(s.charAt(right))){
                Set.remove(s.charAt(left));
                left++;
            }
        
        Set.add(s.charAt(right));
        maxLength = Math.max(maxLength, right - left + 1);

        } 
    
    return maxLength;
}
}