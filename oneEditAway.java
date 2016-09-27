//Approach
//1. check for length of two strings - if same call replace method
//2. if difference is 1 the call insert method
//3. insert method would work for remove as well - just pass second string as first argument


boolean oneEditAway(String first, String second){
    if(first.lenght() == second.lenght()){
        return oneEditReplace(first,second);
    }else if(first.length() + 1 == second.length()){
        return oneEditInsert(first,second);
    }else if(first.length()-1 == second.length()){
        return oneEditInsert(second,first);
    }
    return false;
}

//Approach
//1. maintain a flag for for foundDifference = false
//2. iterate through both the strings if the char don't match check for found difference and if that already true - return false 

boolean oneEditReplace(String s1, String s2){
    boolean foundDifference = false;
    for(int i = 0; i<=s1.length(); i++){
        if(s1.charAt(i) != s2.charAt(i)){
            if(foundDifference){
                return false;
            }
            founddifference = true;
        }
    }
    return true;
}

//Approach
//both string would be same except for the place where it would be shifted by one place


boolean oneEditInsert(String s1, String s2){
    int i1=0, i2=0;
    while(i1 < s1.length() && i2 < s2.length()){
        if(s1.charAt(i1) != s2.charAt(i2)){
            if(i1 != i2){
            return false
            }
            i2++;
        }else{
            i1++;
            i2++;
        }
    }
    return true;
}