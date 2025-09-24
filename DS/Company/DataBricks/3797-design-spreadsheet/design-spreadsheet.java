class Spreadsheet {
    int[][] excel;

    public Spreadsheet(int rows) {
        this.excel = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int column = (int) (cell.charAt(0) - 'A');
        int row = Integer.parseInt(cell.substring(1)) - 1;

        excel[row][column] = value;
    }

    public void resetCell(String cell) {
        setCell(cell, 0);
    }

    public int getValue(String formula) {
        if (formula.charAt(0) == '=') {
            formula = formula.substring(1); // remove '='
        }

        String[] tokens = formula.split("\\+");
        int sum = 0;

        for (String token : tokens) {
            token = token.trim();
            if (Character.isLetter(token.charAt(0))) {
                // Cell reference
                int col = token.charAt(0) - 'A';
                int row = Integer.parseInt(token.substring(1)) - 1;
                sum += excel[row][col];
            } else {
                // Number
                sum += Integer.parseInt(token);
            }
        }

        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */