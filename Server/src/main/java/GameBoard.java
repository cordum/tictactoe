package main.java;

public class GameBoard {
    GameBoard() {
        m_board = new char[Size][Size];

        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                m_board[i][j] = '_';
            }
        }

        m_currentMove = 'x';
    }

    public String toString() {
        String buffer = "";
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                buffer += m_board[i][j];
            }
        }
        return buffer;
    }

    public char currentMove() {
        return m_currentMove;
    }

    private void changeActivePlayer() {
        if (m_currentMove == 'x')
            m_currentMove = 'o';
        else
            m_currentMove = 'x';
    }

    public void process(Messages.Move move) {
        if (m_board[move.x][move.y] != '_')
            return;
        m_board[move.x][move.y] = m_currentMove;
        changeActivePlayer();
    }

    public char getWinner() {
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                if (checkWin(i, j) == true)
                    return m_board[i][j];
            }
        }
        return '_';
    }

    boolean checkWin(int x, int y) {
        char dot = m_board[x][y];
        for (int i = 0; i < 3; i++)
            if ((m_board[i][0] == dot && m_board[i][1] == dot && m_board[i][2] == dot) || (m_board[0][i] == dot && m_board[1][i] == dot && m_board[2][i] == dot))
                return true;
        if ((m_board[0][0] == dot && m_board[1][1] == dot && m_board[2][2] == dot) || (m_board[2][0] == dot && m_board[1][1] == dot && m_board[0][2] == dot))
            return true;
        return false;
    }

    boolean isTableFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (m_board[i][j] == '_')
                    return false;
        return true;
    }

    private char[][] m_board;
    private char m_currentMove;
    public final int Size = 3;
}
