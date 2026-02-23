class StateOfTicTacToe {
    public GameState determineState(String[] board) {
        GameState gameState;
        boolean xWin = false, oWin = false;

        var countX = countMarks(board, 'X');
        var countO = countMarks(board, 'O');

        if (countX < countO) {
            throw new IllegalArgumentException("Wrong turn order: O started");
        } else if (countX - 1 > countO) {
            throw new IllegalArgumentException("Wrong turn order: X went twice");
        }

        if (countX > 2) {
            xWin = hasWon(board, 'X');
            oWin = hasWon(board, 'O');
        }

        if (xWin && oWin) {
            throw new IllegalArgumentException("Impossible board: game should have ended after the game was won");
        } else if (xWin || oWin) {
            gameState = GameState.WIN;
        } else if (isBoardFull(board)) {
            gameState = GameState.DRAW;
        } else {
            gameState = GameState.ONGOING;
        }

        return gameState;
    }

    private boolean checkRow(String row, char player) {
        return row.equals(String.valueOf(player).repeat(3));
    }

    private boolean checkColumn(String[] board, char player, int column) {
        var columnStringBuilder = new StringBuilder();
        
        for (String row : board) {
            columnStringBuilder.append(row.charAt(column));
        }
        
        return checkRow(columnStringBuilder.toString(), player);
    }

    private boolean checkSlash(String[] board, char player) {
        var slashStringBuilder = new StringBuilder();
        
        for (var i = 0; i < board.length; ++i) {
            slashStringBuilder.append(board[i].charAt(board.length - i - 1));
        }
        
        return checkRow(slashStringBuilder.toString(), player);
    }

    private boolean checkBackSlash(String[] board, char player) {
        var blackSlashStringBuilder = new StringBuilder();
        
        for (var i = 0; i < board.length; ++i) {
            blackSlashStringBuilder.append(board[i].charAt(i));
        }
        
        return checkRow(blackSlashStringBuilder.toString(), player);
    }

    private int countMarks(String[] board, char player) {
        var count = 0;
        
        for (var row : board) {
            for (var character : row.toCharArray()) {
                if (character == player) {
                    ++count;
                }
            }
        }
        
        return count;
    }

    private boolean isBoardFull(String[] board) {
        var boardFull = true;
        
        boardloop:
        for (var row : board) {
            for (var character : row.toCharArray()) {
                if (character == ' ') {
                    boardFull = false;
                    break boardloop;
                }
            }
        }

        return boardFull;
    }

    private boolean hasWon(String[] board, char player) {
        var won = false;
        
        for (var row : board) {
            if (!won && checkRow(row, player)) {
                won = true;
                break;
            }
        }
        for (var i = 0; i < board.length; ++i) {
            if (!won && checkColumn(board, player, i)) {
                won = true;
                break;
            }
        }
        
        if (!won && checkSlash(board, player)) {
            won = true;
        }
        if (!won && checkBackSlash(board, player)) {
            won = true;
        }
        
        return won;
    }
}