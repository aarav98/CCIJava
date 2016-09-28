void setZeros(int[][] matrix){
    boolean row = new boolean[matrix.length];
    boolean column = new boolean[matrix[0].length];
    
    for(int r = 0; r<matrix.length; r++){
        for(int c = 0; c<matrix[0].length; c++){
            if(matrix[r][c] == 0){
                row[r] = true;
                column[c] = true;
            }
        }
    }
    
    for(int i = 0; i<row.length; i++){
        if(row[i]){
            nullifyRow(matrix,i)
        }
    }
    
    for(int i = 0; i<column.length; i++){
        if(column[i]) nullifyColumn(matrix,i);
    }
}

void nullifyRow(int[][] matrix, int row){
    for(int i = 0; i<matrix[0].length; i++){
        matrix[row][i] = 0;
    }
}

void nullifyColumn(int[][] matrix, int column){
    for(int i = 0; i<matrix.length; i++){
        matrix[i][column] = 0;
    }
}


//Alternate approach

void setZero(int[][] matrix){
    boolean rowHasZero = false;
    boolean colHasZero = true;
    
    for(int c = 0; c<matrix[0].length; c++){
        if(matrix[0][c] == 0) rowHasZero true;
        break;
    }
    
    for(int r = 0; r<matrix.length; r++){
        if(matrix[r][0] == 0){
            colHasZero = true;
            break;
        }
    }
    
    for(int r = 1; r<matrix[0].length; r++){
        for(int c = 1; c<matrix[0].length; c++){
            if(matrix[r][c] == 0){
                matrix[0][c] = 0;
                matrix[r][0] = 0;
            }
        }
    }
    
    for(int c=0; c<matrix.length;c++){
        if(matrix[0][c]==0) nullifyColumn(matrix,c);
    }
    
    for(int r = 0; r<matrix.length;r++){
        if(matrix[r][0]==0) nullifyRow(matrix,r);
    }
    
    if(rowHasZero) nullifyRow(matrix,0);
    if(colHasZero) nullifyColumn(matrix,0);
}