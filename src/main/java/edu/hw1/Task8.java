package edu.hw1;

public class Task8 {
    private Task8() {}
    protected boolean isValidIndex(int[][] chessBoard, int i, int j) {
        return (i >= 0 && i < chessBoard.length && j >= 0 && j < chessBoard[0].length);
    }
    public boolean knightBoardCapture(int[][] chessBoard) {
        int[][] shift = {
            {2, 1}, {1, 2}, {2, -1}, {1, -2},
        };
        for (int i = 0; i < chessBoard.length; i++)
            for (int j = 0; j <chessBoard[0].length; j++)
                if (chessBoard[i][j] == 1) {
                    for (int k = 0; k < shift.length; k++)
                        if(isValidIndex(chessBoard, i + shift[k][0], j + shift[k][1]))
                            if (chessBoard[i + shift[k][0]][j + shift[k][1]] == 1)
                                return false;
                }
        return true;
    }
}
