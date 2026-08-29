class Solution {
    HashMap<Character, String> mp= new HashMap<>();
    List<String> l = new ArrayList<>();

    public Solution() {
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return l;
        }

        fun(0, digits, new StringBuilder(), l);
        return l;
    }

    private void fun(int idx, String digits, StringBuilder s, List<String> l){
        if(idx== digits.length()){
            l.add(s.toString());
            return;
        }

        String choice= mp.get(digits.charAt(idx));

        for(int j=0; j<choice.length(); j++){
            s.append(choice.charAt(j));
            fun(idx+1, digits, s, l);
            s.deleteCharAt(s.length()-1);
        }

        return;
    }
}
