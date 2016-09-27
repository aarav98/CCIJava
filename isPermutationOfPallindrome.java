//Approach 1
//Build frequency map for the characters in the string (HashMap)
//go through HashMap to check for more than one odd

boolean isPermutationOfPallindrome(String phrase){
    int table = buildFrequencyTable(phrase);
    return checkForMaxOneOdd(table);
}

int[] buildFrequencyTable(String phrase){
    int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1]; // only alphabets are considered, case doesn't matter
    for(char c: phrase.toCharArray()){
        int x = getCharNumber(c);
        if(x!=-1) table[x]++;
    }
    return table;
}

int getCharNumber(char c){
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int A = Character.getNumericValue('A');
    int Z = Character.getNumericValue('Z');
    
    int val = Character.getNumericValue(c);
    if(a<=val || val<=z){
    return val-a;
    } else if(A<=val || val<= Z){
        return val -A;
    }else{
        return -1;
    }
}

boolean checkForMaxOneOdd(int[] table){
    boolean foundOdd = false;
    for(int count : table){
        if(count%2 == 1){
            if(foundOdd) return false;
            foundOdd = true;
        }
    }
    return true;
}