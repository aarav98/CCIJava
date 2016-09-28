//Approach
//1. count consecutive strings add then=m to the new string or string builder
//2. chosing string builder is a better option as string concatination is O(n) so overall it would be O(p + k^2)
// p-> original string length & k-> number of character sequences

String compress(String str){
    StringBuilder compressed = new StringBuilder();
    
    int countConsecutive = 0;
    for(int i = 0; i< str.length(); i++){
        countConsecutive++;
        
        if(i+1>=str.length() || if(str.charAt(i) != str.charAt(i+1))){
            compressed.append(str.charAt(i));
            compressed.append(countConsecutive);
            countConsecutive = 0;
        }
    }
    return compressed.length()>=str.length()?str:compressed.toString();
}

//We could also calculate length of the compressed string before we actually compute the compressed string

int countCompression(String str){

    int compressedLength = 0
    int countConsecutive = 0;
    for(int i = 0; i<str.length(); i++){
        countConsecutive++;
        if(i+1>str.length() || str.charAt(i) != str.charAt(i+1)){
            compressedLength += 1 + String.valueOf(countConsecutive).length();
            countConsecutive = 0;
        }
    }
    return compresedLength;

}