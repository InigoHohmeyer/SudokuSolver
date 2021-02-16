package com.company;


public class Main {

    public static void main(String[] args) {
        int[][] grid = {
                {9, 0, 0, 1, 0, 0, 0, 0, 5},
                {0, 0, 5, 0, 9, 0, 2, 0, 1},
                {8, 0, 0, 0, 4, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 7, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 6, 0, 0, 9},
                {2, 0, 0, 3, 0, 0, 0, 0, 6},
                {0, 0, 0, 2, 0, 0, 9, 0, 0},
                {0, 0, 1, 9, 0, 4, 5, 7, 0},
        };
        solve(grid);
        print(grid);



    }


    public static boolean solve(int[][] array) {
        //Iterates through the array
         for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                //If the coordinate is empty then it will try to fill it
                if(array[i][j] == 0){
                    for(int n = 1; n < 10; n++){
                        //if it is possible to add a certain number it will add it
                        if(possible(n, i,j, array)){
                            array[i][j] = n;
                            //If it works for the next empty spot then it will continue
                            if(solve(array)){
                                return true;
                            }else{
                                //Else it will change it back to 0 and we keep iterating
                                array[i][j] = 0;
                            }

                        }

                    }
                    return false;
                    //We return false because we have iterated through all the numbers and none of them work. As a result we change the previous
                }
            }
         }
         return true;
         //The grid has been solved.
    }


    //Prints out the grid.
    public static void print(int[][] array){
        for(int i =0; i < array.length; i++){
            //For every new row makes a new line.
            System.out.println(" ");
            for (int j = 0 ; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
        }
    }




    //Method for checking if it's possible for a certain coordinate
    public static boolean possible(int test, int row, int column, int[][] array){
        //If any single method returns false, possible will return false.
        return (column(test, column, array) && row(test, row, array) && square(test, column, row, array));

    }
    //Methods for checking if different aspects are possible

    //Checks if duplicate in column
    public static boolean column(int test, int column, int[][] array){
        for(int i = 0; i < 9; i++){
            if(array[i][column] == test){
                //Iterates through different rows but stays in the same column
                return false;
            }

        }
        return true;
    }
    //Checks there is duplicate in the same row
    public static boolean row(int test, int row, int[][] array){
        for (int i = 0; i < 9; i++){
            //Iterates through one row
            if(array[row][i] == test){
                return false;
            }

    }
        return true;

}
    //Checks if there is any duplicate number in square
    public static boolean square(int test, int column, int row, int[][] array){
        //0-2 returns 0, 3-5 returns 3, 6-8 returns 6;
        int csection = Math.floorDiv(column, 3) * 3;
        //Does floor division of the column it's in
        int rsection = Math.floorDiv(row, 3) * 3;
        //Do floor division of the row it's in
        int rstart = rsection;
        int cstart = csection;
        for(rsection = rstart; rsection <= rstart + 2 ; rsection++){
            for(csection = cstart; csection <= cstart + 2 ; csection++){

                if(test == array[rsection][csection]){
                    return false;
                }
            }
        }

        return true;

        }

    }




