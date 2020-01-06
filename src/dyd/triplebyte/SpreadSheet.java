package dyd.triplebyte;

import java.util.Arrays;

public class SpreadSheet {
    private static final String COLUMN_SEPARATOR = "|";

    private int rows;
    private int cols;
    private String[][] cells;

    public SpreadSheet(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        cells = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(cells[i], "");
        }
    }

    public void setCell(String cell, int row, int col) {
        this.cells[row][col] = cell;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cells[i][j]);
                if (j < cols - 1) {
                    System.out.print(COLUMN_SEPARATOR);
                }
            }
            System.out.println();
        }
    }

    public void prettyPrint() {
        String[][] printCells = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].startsWith("sum(")) {
                    printCells[i][j] = Integer.toString(evaluate(cells[i][j]));
                } else {
                    printCells[i][j] = cells[i][j];
                }
            }
        }

        int[] colWidths = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                colWidths[j] = Math.max(colWidths[j], printCells[i][j].length());
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%-" + colWidths[j] + "s", printCells[i][j]);
                if (j < cols - 1) {
                    System.out.print(COLUMN_SEPARATOR);
                }
            }
            System.out.println();
        }
    }

    public int evaluate(String formula) {
        int leftBrace = formula.indexOf("(");
        int rightBrace = formula.indexOf(")");
        String range = formula.substring(leftBrace + 1, rightBrace);
        String[] cooridnates = range.split("-");
        String[] topLeft = cooridnates[0].split(":");
        String[] bottomRight = cooridnates[1].split(":");
        int top = Integer.parseInt(topLeft[0]);
        int left = Integer.parseInt(topLeft[1]);
        int bottom = Integer.parseInt(bottomRight[0]);
        int right = Integer.parseInt(bottomRight[1]);
        int sum = 0;
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (!cells[i][j].isEmpty()) {
                    try {
                        sum += Integer.parseInt(cells[i][j]);
                    } catch (NumberFormatException e) {
                        // Ignore
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SpreadSheet spreadSheet = new SpreadSheet(4, 3);
        spreadSheet.setCell("bob", 0, 0);
        spreadSheet.setCell("10", 0, 1);
        spreadSheet.setCell("foo", 0, 2);
        spreadSheet.setCell("alice", 1, 0);
        spreadSheet.setCell("5", 1, 1);
        System.out.println();
        System.out.println("print:");
        spreadSheet.print();
        System.out.println();
        System.out.println("pretty print:");
        spreadSheet.prettyPrint();
        System.out.println();
        System.out.println("sum: " + spreadSheet.evaluate("sum(0:0-1:1)"));
        System.out.println("sum: " + spreadSheet.evaluate("sum(0:0-0:1)"));
        spreadSheet.setCell("sum(0:0-1:1)", 1,2);
        spreadSheet.prettyPrint();
    }
}
