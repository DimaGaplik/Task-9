package app;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = random.nextInt(50) + 1;
                    }
                }
                System.out.println("Матриця 4x4:");
                printMatrix(matrix);

                int sumEvenRows = 0, sumOddRows = 0;
                int prodEvenCols = 1, prodOddCols = 1;

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (i % 2 == 0) {
                            sumEvenRows += matrix[i][j];
                        } else {
                            sumOddRows += matrix[i][j];
                        }

                        if (j % 2 == 0) {
                            prodEvenCols *= matrix[i][j];
                        } else {
                            prodOddCols *= matrix[i][j];
                        }
                    }
                }
                System.out.println("\nСума елементів у парних рядках (рядок 0, 2): " + sumEvenRows);
                System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + sumOddRows);
                System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + prodEvenCols);
                System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + prodOddCols);

                boolean isMagicSquare = checkMagicSquare(matrix);
                if (isMagicSquare) {
                    System.out.println("\nМатриця є магічним квадратом.");
                } else {
                    System.out.println("\nМатриця не є магічним квадратом.");
                }
            }
            private static void printMatrix(int[][] matrix) {
                for (int[] row : matrix) {
                    for (int element : row) {
                        System.out.printf("%3d ", element);
                    }
                    System.out.println();
                }
            }
            private static boolean checkMagicSquare(int[][] matrix) {
                int rowSum = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    rowSum += matrix[0][j];
                }

                for (int i = 1; i < matrix.length; i++) {
                    int currentRowSum = 0;
                    for (int j = 0; j < matrix[i].length; j++) {
                        currentRowSum += matrix[i][j];
                    }
                    if (currentRowSum != rowSum) {
                        return false;
                    }
                }

                for (int j = 0; j < matrix[0].length; j++) {
                    int colSum = 0;
                    for (int i = 0; i < matrix.length; i++) {
                        colSum += matrix[i][j];
                    }
                    if (colSum != rowSum) {
                        return false;
                    }
                }

                int mainDiagonalSum = 0;
                int antiDiagonalSum = 0;
                for (int i = 0; i < matrix.length; i++) {
                    mainDiagonalSum += matrix[i][i];
                    antiDiagonalSum += matrix[i][matrix.length - 1 - i];
                }
                return mainDiagonalSum == rowSum && antiDiagonalSum == rowSum;
            }
        }
