class Solution {
    // Function to remove all occurrences of the character from the string
    public void removeCharacter(StringBuilder s, char c) {
        // code here
        remove(s,c,0);
    }
    
    private void remove(StringBuilder s, char c, int i){
        if(i== s.length()){
            return;
        }
        
        if(s.charAt(i)== c){
            s.deleteCharAt(i);
            remove(s,c,i);
        }else{
            remove(s,c,i+1);
        }      
    }
}
