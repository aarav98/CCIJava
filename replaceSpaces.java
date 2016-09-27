//Approach 1
//1. count no. of spaces = n
//2. add 2*n to the length of string
//3. start replacing spaces from the end

void replaceSpaces(char[] str, int length){
    int spaceCount = 0,newlength;
    for(int i=0;i<lenght;i++){
        if(str[i] == ' ') spaceCount++;
    }
    newLength = length + 2*spacCount;
    
    str[newLength] = '\0';
    for(int i = length-1; i>=0;i--){
        if(str[length-1] == ' '){
            str[newLength-1] = '0';
            str[newLength-2] = '2';
            str[newLength-3] = '%';
            newLength -= 3;
        } else{
            str[newlength -1] = str[i];
            newLength -=1;
        }
    }
}