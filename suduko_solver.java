import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class suduko_solver {

    public static void main(String args[]){

         int[][] board = {{8, 1, 0, 0, 3, 0, 0, 2, 7}, 
                            {0, 6, 2, 0, 5, 0, 0, 9, 0}, 
                            {0, 7, 0, 0, 0, 0, 0, 0, 0}, 
                            {0, 9, 0, 6, 0, 0, 1, 0, 0}, 
                            {1, 0, 0, 0, 2, 0, 0, 0, 4}, 
                            {0, 0, 8, 0, 0, 5, 0, 7, 0}, 
                            {0, 0, 0, 0, 0, 0, 0, 8, 0}, 
                            {0, 2, 0, 0, 1, 0, 7, 5, 0}, 
                            {3, 8, 0, 0, 7, 0, 0, 4, 2}};

        printBoard(board);

        if(solve(board)){
            System.out.println("--------SOLUTION--------");
            printBoard(board);
        }

    }


    // a method to print the suduko board

     static void printBoard(int [][] board){

        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board.length; x++){
                System.out.print(board[y][x]+" |");
            }

            System.out.println();
        }
        System.out.println();
    }


    static boolean isEmpty(int y,int x,int[][] board){
       // Check if a cell is Empty(0)
        return board[y][x] == 0;
    }


    static boolean isValid(int y,int x, int[][] board,int num){
        //Check if the number doesn't exist along the X-axis (Columns)

        for(int i = 0 ; i < board.length ; i++){
            if(board[y][i] == num) return false;
        }

       // Check if the number doesn't exist along the Y-axis (rows)

        for(int i = 0 ; i < board.length ; i++){
            if(board[i][x] == num) return false;
        }

        // Check if the numbers doesn't exist inside 3x3  matrix

        int x0 = (x / 3) * 3;
        int y0 = (y / 3) * 3;

        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[y0 + i][x0 + j] == num) return false;
            }
        }
        
        // Return true Otherwise
        return true;
    }

    static boolean solve(int [][] board){

        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board.length; x++){
                if(isEmpty(y, x, board)){
                    for(int num = 1; num <= 9;num++){
                        if(isValid(y, x, board, num)){
                            board[y][x] = num;
                            if(solve(board)) return true;
                            board[y][x] = 0;
                        }
                    }
                    return false;

                }
            }
        }
        return true;
    }

    

}
