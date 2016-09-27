boolean isUnique(String str){
    if(str.length() > 128) return false; //assuming ASCII not Unicode(256)
    booelan[] char_set = new boolean[128];
    for(int i=0; i<str.length();i++){
        int val = str.charAt(i);
        if(char_set[val]){
            return false;
        }
        char_set[val] = true;
    }
    return true;
}

boolean isUnique(String str){
    if(str.length() > 128) return false;
    int checker = 0;
    for(int i = 0;i<str.length();i++){
        int val = strr.charAt(i)-'a';
        if(checker & (1<<val)>0) return false;
        checker |= (1<<val);
    }
    return true;
}