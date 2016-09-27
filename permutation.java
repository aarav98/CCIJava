//Approach 1: 
//1. Convert two strings to char array
//2. sort both char arrays using java inbuilt function for arrays
//3. compare two arrays using java inbuilt function 

String sort(String s){
    char[] content = s.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
}

boolean permutation(String s, String t){
    if(s.length() != t.length()){
        return false;
    }
    return t.equals(sort(s));
}

// Approach 2
//1. declare a letter [] of size 128 for ascii
//2. for each char in s increment the corresponding letter array position by 1
//3. for each char in t decrement the letter array position by 1
//4. check if position last decremented is less than 0 return false

boolean permutation(String s, String t){
    if(s.length() != t.length()){
        return false;
    }
    
    int[] letters = new int[128];
    
    char[] s_array = s.toCharArray();
    for(char c : s_array){
        letter[c]++;
    }
    
    for(int i = 0; i<t.length(); i++){
        int c = (int)t.charAt(i);
        letters[c]--;
        if(letters[c] <0){
            return false;
        }
    }
    
    return true;
}