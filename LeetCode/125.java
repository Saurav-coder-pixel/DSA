class Solution {
    public boolean isPalindrome(String s) {
        int n= s.length();
        if(n== 0) return true;
        int start=0;
        int end= s.length()-1;

        while(start< end){
            while(start< end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start< end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}







class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left= 0;
        int right= s.length()-1;

        while(left< right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            else{
                left++;
                right--;
            }
        }

        return true;
    }
}
