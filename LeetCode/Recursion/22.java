class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l= new ArrayList<>();
        generate(n,0,0, new StringBuilder() ,l);
        return l;
    }

    private void generate(int n, int open, int close, StringBuilder s, List<String> l){
        if(open== n && close== n){
            l.add(s.toString());
            return;    
        }

        if(open< n){
            s.append("(");
            generate(n, open+1, close, s, l);
            s.deleteCharAt(s.length()-1);
        }

        if(close< open){
            s.append(")");
            generate(n, open, close+1, s, l);
            s.deleteCharAt(s.length()-1);
        }
        return;
    }
}
