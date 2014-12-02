/*
Written by Joe Sweeney (Jeteroll), Grant Rassumusen (grantras) and Cooper Pellaton (cooperpell) in November 2014.
*/

import java.util.*;

public class Sudoku {

  public static void go() {
    
//    Initiate a try-with-resources statement to ensure that the numScan and inputScan scanners are closed.
    try (Scanner numScan = new Scanner(System.in); Scanner inputScan = new Scanner(System.in)) {
      
//      Initiate booleans
      boolean squareConts = false;
      boolean rowConts = true;
      boolean columnConts = true;
      
      boolean staticNum = true;
      
//      Initiate the random object & set the variable num1 (the number of random elements in the array 
//      to be assigned) to equal that random number from 17 to 20
      Random randNum = new Random();
      
      int num1 = (randNum.nextInt(4)) + 17;
      
//      Initiate variables
      int randX = 0;
      int randY = 0;
      String randEle = "";
      
      int row = 0;
      int column = 0;
      
      
//      Initiate arrays
      String[][] array = new String[9][9];
    
      String[][] currentSquare = new String[3][3];
      String[] currentRow = new String[9];
      String[] currentColumn= new String[9];
      
      String[] staticNums = new String[num1];
      
//      Fill in the array with zeros
      for (int x = 0; x < 9; x++) {
        for (int y = 0; y < 9; y++) {
          array[x][y] = "0";
        }
      }

//      Fill in as many elements (between 17 and 20, inclusive) as determined by num1
      for (int i = 0; i < num1; i++) {
        
//        Reset booleans
        squareConts = false;
        rowConts = true;
        columnConts = true;
        
//        Pick random numbers for variables
        randX = randNum.nextInt(9);
        randY = randNum.nextInt(9);
        
//        Copy the current row (randY) to the currentRow array      
        System.arraycopy(array[randY], 0, currentRow, 0, 9);

//        Copy each value from the current column (randX) to the currentColumn array
        for (int j = 0; j < 9; j++) {
          currentColumn[j] = array[j][randX];
        }
        
//        Check which 3 by 3 square the input is located in, and then copy that square to the currentSquare array
        if (randY >= 0 && randY <= 2) {
          if (randX >= 0 && randX <= 2) {
            for (int k = 0; k < 3; k++) {
              System.arraycopy(array[k], 0, currentSquare[k], 0, 3);
            } 
          } else if (randX >= 3 && randX <= 5) {
            for (int k = 0; k < 3; k++) {
              System.arraycopy(array[k], 3, currentSquare[k], 0, 3);
            }
          } else {
            for (int k = 0; k < 3; k++) {
              System.arraycopy(array[k], 6, currentSquare[k], 0, 3);
            }
          }
        } else if (randY >= 3 && randY <= 5) {
          if (randX >= 0 && randX <= 2) {
            for (int k = 3; k < 6; k++) {
              System.arraycopy(array[k], 0, currentSquare[k - 3], 0, 3);
            } 
          } else if (randX >= 3 && randX <= 5) {
            for (int k = 3; k < 6; k++) {
              System.arraycopy(array[k], 3, currentSquare[k - 3], 0, 3);
            }
          } else {
            for (int k = 3; k < 6; k++) {
              System.arraycopy(array[k], 6, currentSquare[k - 3], 0, 3);
            }
          }
        } else {
          if (randX >= 0 && randX <= 2) {
            for (int k = 6; k < 9; k++) {
              System.arraycopy(array[k], 0, currentSquare[k - 6], 0, 3);
            } 
          } else if (randX >= 3 && randX <= 5) {
            for (int k = 6; k < 9; k++) {
              System.arraycopy(array[k], 3, currentSquare[k - 6], 0, 3);
            }
          } else {
            for (int k = 6; k < 9; k++) {
              System.arraycopy(array[k], 6, currentSquare[k - 6], 0, 3);
            }
          }
        }
        
//        Check whether the randomly generated element passes the three checks
        while (squareConts == true || rowConts == true || columnConts == true) {
          
          randEle = String.valueOf(randNum.nextInt(9) + 1);
          
//          Reset booleans      
          squareConts = false;
          rowConts = true;
          columnConts = true;
          
//          Check whether the number is already in its square
          for (int l = 0; l < 3; l++) {
              if (Arrays.asList(currentSquare[l]).contains(randEle) == true) {
                squareConts = true;
              }
          }
          
//          Check whether the number is already in its row
          rowConts = Arrays.asList(currentRow).contains(randEle);
          
//          Check whether the number is already in its column
          columnConts = Arrays.asList(currentColumn).contains(randEle);
        }
        
//        Write the random element to the array
        array[randY][randX] = randEle;

//        Add the row and column number of the random element to the array staticNum array
        staticNums[i] = String.valueOf(randX) + "," + String.valueOf(randY);
      }
      
//      Reset booleans and initiate variables
      squareConts = false;
      rowConts = true;
      columnConts = true;
      
      boolean playerWin = false;
      
      int currRow = 0;
      String input = "0";
      
//      Loop until the player wins
      while (playerWin == false) {
        
//        Reset booleans
        squareConts = false;
        rowConts = true;
        columnConts = true;
        
        staticNum = true;
        
//        Print the current board
        System.out.println("           Current Board:\n");
        System.out.println("1   2   3   4   5   6   7   8   9\n");
        
        for (int y = 0; y < 9; y++) {
          for (int x = 0; x < 9; x++) {
            currRow = y;
            if (x != 9) {
              System.out.print(array[y][x] + "   ");
            } else {
              System.out.print(array[y][x]);
            }
          }
          System.out.print((currRow + 1) + "\n");
        }
        
//        Loop until the user enters a element location that is not generated (static)
        while (staticNum == true) {
          
//          Take user input for selection and value input
          System.out.println("\nPlease enter the column number: ");
          column = numScan.nextInt() - 1;
          
//          Take user input for selection and value input
          System.out.println("\nPlease enter the row number: ");
          row = numScan.nextInt() - 1;
          
//          Check whether the element location entered is a generated element, and alert the user accordingly.
          if (Arrays.asList(staticNums).contains(String.valueOf(column) + "," + String.valueOf(row))) {
            System.out.println("That element was randomly generated, you cannot change it. Please pick another element.");
          } else {
            staticNum = false;
          }
        }
        
//        Copy the current row to the currentRow array
        System.arraycopy(array[row], 0, currentRow, 0, 9);
        
//        Copy each value from the current column to the currentColumn array
        for (int i = 0; i < 9; i++) {
          currentColumn[i] = array[i][column];
        }
          
//        Check which 3 by 3 square the input is located in, and then copy that square to the currentSquare array
        if (row >= 0 && row <= 2) {
          if (column >= 0 && column <= 2) {
            for (int i = 0; i < 3; i++) {
              System.arraycopy(array[i], 0, currentSquare[i], 0, 3);
            } 
          } else if (column >= 3 && column <= 5) {
            for (int i = 0; i < 3; i++) {
              System.arraycopy(array[i], 3, currentSquare[i], 0, 3);
            }
          } else {
            for (int i = 0; i < 3; i++) {
              System.arraycopy(array[i], 6, currentSquare[i], 0, 3);
            }
          }
        } else if (row >= 3 && row <= 5) {
          if (column >= 0 && column <= 2) {
            for (int i = 3; i < 6; i++) {
              System.arraycopy(array[i], 0, currentSquare[i - 3], 0, 3);
            } 
          } else if (column >= 3 && column <= 5) {
            for (int i = 3; i < 6; i++) {
              System.arraycopy(array[i], 3, currentSquare[i - 3], 0, 3);
            }
          } else {
            for (int i = 3; i < 6; i++) {
              System.arraycopy(array[i], 6, currentSquare[i - 3], 0, 3);
            }
          }
        } else {
          if (column >= 0 && column <= 2) {
            for (int i = 6; i < 9; i++) {
              System.arraycopy(array[i], 0, currentSquare[i - 6], 0, 3);
            } 
          } else if (column >= 3 && column <= 5) {
            for (int i = 6; i < 9; i++) {
              System.arraycopy(array[i], 3, currentSquare[i - 6], 0, 3);
            }
          } else {
            for (int i = 6; i < 9; i++) {
              System.arraycopy(array[i], 6, currentSquare[i - 6], 0, 3);
            }
          }
        }
        
//        Take user input for the input number, and check if it is valid, if not, loop and ask for new input  
        while (squareConts == true || rowConts == true || columnConts == true) {
    
//          Reset booleans      
          squareConts = false;
          rowConts = true;
          columnConts = true;
          
//          Take user input for the input number      
          System.out.println("\nPlease enter the number you would like to input: ");
          input = inputScan.nextLine();
          
//          Check whether the number is already in its square
          for (int i = 0; i < 3; i++) {
              if (Arrays.asList(currentSquare[i]).contains(input) == true) {
                squareConts = true;
              }
          }
          
//          Check whether the number is already in its row
          rowConts = Arrays.asList(currentRow).contains(input);
          
//          Check whether the number is already in its column
          columnConts = Arrays.asList(currentColumn).contains(input);

//          Check whether the number is already in its square, row, or column, and alert the user accordingly 
          if (rowConts) {
            System.out.println(input + " already exists in row " + (row + 1) + ".");
            if (columnConts) {
              System.out.println(input + " already exists in column " + (column + 1) + ".");
            } 
            if (squareConts) {
              System.out.println(input + " already exists in that square.");
            }
          } else if (columnConts) {
            System.out.println(input + " already exists in column " + (row + 1) + ".");
            if (rowConts) {
              System.out.println(input + " already exists in row " + row + ".");
            } 
            if (squareConts) {
              System.out.println(input + " already exists in that square.");
            }
          } else if (squareConts) {
            System.out.println(input + " already exists in row " + (row + 1) + ".");
            if (rowConts) {
              System.out.println(input + " already exists in column " + (column + 1) + ".");
            }
            if (columnConts) {
              System.out.println(input + " already exists in that square.");
            }
          }
        }
        
//        Write the input to the correct element in the array     
        array[row][column] = input;
        
//        Check whether the player wins     
        playerWin = true;
        
//        Check each element in the main array to determine whether it passes the three checks
        
//        Cycle through each row in the main array
        for (int y = 0; y < 9; y++) {
          
//          Copy the current row to the currentRow array
          System.arraycopy(array[y], 0, currentRow, 0, 9);
        
//          Cycle through each column in the main array
          for (int x = 0; x < 9; x++) {
              
//              Reset booleans
              squareConts = false;
              rowConts = false;
              columnConts = false;
              
//              Copy the current column to the currentColumn array
              for (int i = 0; i < 9; i++) {
                currentColumn[i] = array[i][x];
              }
              
//              Check whether there are duplicate numbers in the row compared to the current number
              for (int i = 0; i < 9; i++) {
                
//                Skip checking the element that is currently being checked by the main for loop
                if (y == i) {
                } else if (array[y][x] == currentRow[i]) {
                  rowConts = true;
                }
              }
              
//              Check whether there are duplicate numbers in the column compared to the current number
              for (int i = 0; i < 9; i++) {
                
//                Skip checking the element that is currently being checked by the main for loop
                if (x == i) {
                } else if (array[y][x] == currentColumn[i]) {
                  columnConts = true;
                }
              }
              
//              Determine the current 3 by 3 square that the number is in and copy that square to the currentSquare array
              if (y >= 0 && y <= 2) {
                if (x >= 0 && x <= 2) {
                  for (int i = 0; i < 3; i++) {
                    System.arraycopy(array[i], 0, currentSquare[i], 0, 3);
                  } 
                } else if (x >= 3 && x <= 5) {
                  for (int i = 0; i < 3; i++) {
                    System.arraycopy(array[i], 3, currentSquare[i], 0, 3);
                  }
                } else {
                  for (int i = 0; i < 3; i++) {
                    System.arraycopy(array[i], 6, currentSquare[i], 0, 3);
                  }
                }
              } else if (y >= 3 && y <= 5) {
                if (x >= 0 && x <= 2) {
                  for (int i = 3; i < 6; i++) {
                    System.arraycopy(array[i], 0, currentSquare[i - 3], 0, 3);
                  } 
                } else if (x >= 3 && x <= 5) {
                  for (int i = 3; i < 6; i++) {
                    System.arraycopy(array[i], 3, currentSquare[i - 3], 0, 3);
                  }
                } else {
                  for (int i = 3; i < 6; i++) {
                    System.arraycopy(array[i], 6, currentSquare[i - 3], 0, 3);
                  }
                }
              } else {
                if (x >= 0 && x <= 2) {
                  for (int i = 6; i < 9; i++) {
                    System.arraycopy(array[i], 0, currentSquare[i - 6], 0, 3);
                  } 
                } else if (x >= 3 && x <= 5) {
                  for (int i = 6; i < 9; i++) {
                    System.arraycopy(array[i], 3, currentSquare[i - 6], 0, 3);
                  }
                } else {
                  for (int i = 6; i < 9; i++) {
                    System.arraycopy(array[i], 6, currentSquare[i - 6], 0, 3);
                  }
                }
              }
              
//              Check whether there are duplicate numbers in the square compared to the current number  
              for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++)
                  
//                  Skip checking the element that is currently being checked by the main for loop
                  if (y == j && x == k) {
                  } else if (array[y][x] == array[j][k]) {
                    squareConts = true;
                  }
              }
              
//              Check whether the current element passes all three checks. If not, set playerWin to false.
//              Just one check evaluating to false in the entire array will cause the main while loop to continue 
//              because playerWin will be set to false
              if (rowConts == true || columnConts == true || squareConts == true ) {
                playerWin = false;
              }
          }
        }
      }
      
//      Alert the player that he/she has won
      System.out.println("You win!");
    }
  }
}
