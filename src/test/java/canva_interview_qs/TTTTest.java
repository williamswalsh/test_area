package canva_interview_qs;

import org.junit.Test;

public class TTTTest {

    @Test
    public void getWinnerTest() {
        Character[][] game = new Character[][]{
                {'o', 'x', 'x'}, {'o', 'o', 'x'}, {'o', 'x', 'o'}
        };
        System.out.println(getWinner(game));
    }

    //    @Nullable
    Character getWinner(Character[][] game) {
        Character curr;
        Character existing;
        int requiredWinAmt;

        // Time Complexity -? O(n) ? Was this wrong????
        // n = num of columns/rows = 3
        // O(n^2) + O(n^2) + O(n) + O(n)
        // O(n^2)

        // Space complexity
        // Constant space
        // O(1)

// row
        for (int i = 0; i < game.length; i++) {
            requiredWinAmt = game.length - 1;
            existing = null;
            for (int j = 0; j < game[0].length; j++) {

                curr = game[i][j];

                if (existing == null) {
                    existing = curr;
                } else {
                    if (existing != curr) {
                        break;
                    } else {
                        requiredWinAmt--;
                        if (requiredWinAmt == 0) {
                            return curr;
                        }
                    }

                }
                // Win condition
            }
        }

//        Columns
//        for (int i = 0; i < game.length; i++) {
//            requiredWinAmt = game.length - 1;
//            existing = null; // TODO: Think about this
//            for (int j = 0; j < game[0].length; j++) {
//
//                curr = game[j][i];
//
//                if (existing == null) {
//                    existing = curr;
//                } else {
//                    if (existing != curr) {
//                        break;
//                    } else {
//                        requiredWinAmt--;
//                        if (requiredWinAmt == 0) {
//                            // Win condition
//                            return curr;
//                        }
//                    }
//                }
//            }
//        }

//        Diagonal \
        existing = null;
        requiredWinAmt = game.length - 1;
        for (int i = 0; i < game.length; i++) {

            curr = game[i][i];

            if (existing == null) {
                existing = curr;
            } else {
                if (existing != curr) {
                    break;
                } else {
                    requiredWinAmt--;
                    if (requiredWinAmt == 0) {
                        // Win condition
                        return curr;
                    }
                }
            }
        }


        // Rows x 3
        // game[0][0]
        // game[0][1]
        // game[0][2]

        // Columns x 3
        // game[0][0]
        // game[1][0]
        // game[2][0]

        // Diagonals
        // game[0][0]
        // game[1][1]
        // game[2][2]

        // game[0][2]
        // game[1][1]
        // game[2][0]
        for (int i = 0, j=2; i < game.length; i++,j--) {

        }
//
//
//
//        for (Character c: game[0]) {
//            // get 1st char
//            if (first != c) {
//                // if c is null
//                // disqualifies this row from winning
//                break;
//            }  else if (game.length == )
//            // if change in value exit
//            // otherwise
//            // win
//        }
//
//         x x o
        return null;
    }
}
