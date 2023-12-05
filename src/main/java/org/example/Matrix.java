package org.example;

import java.util.Random;

public class Matrix {
    private final int rows, columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public Matrix(int size) {
        this.rows = size;
        this.columns = size;
    }

    public int[][] getRandomMatrix(int min, int max) {
        if (rows > 0 && columns > 0) {
            int[][] matrix = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = new Random().nextInt(max - min) + min;
                }
            }
            return matrix;
        } else {
            throw new RuntimeException("Matrix size must be greater than 0");
        }
    }

    public void print(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows > 0 && columns > 0) {
            for (int[] ints : matrix) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(ints[j] + "\t\t");
                }
                System.out.println();
            }

        } else {
            throw new RuntimeException("Matrix size must be greater than 0");
        }
    }

    public int[] getNumbersAbovePrimaryDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] temp = new int[rows * columns];
        int size = 0;
        if (rows > 0 && columns > 0) {
            if (rows == columns) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (j > i) {
                            temp[size++] = matrix[i][j];
                        }
                    }
                }
                int[] numbers = new int[size];
                for (int i = 0; i < size; i++) {
                    numbers[i] = temp[i];
                }
                return numbers;
            } else {
                throw new RuntimeException("rows size and columns size must be equal");
            }
        } else {
            throw new RuntimeException("matrix size must be greater than 0");
        }
    }

    public int[][] reverseMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] reverse = new int[rows][columns];
        if (rows > 0 && columns > 0) {
            if (rows == columns) {
                for (int i = 0 ; i < rows; i++) {
                    for (int j = columns - 1; j >= 0; j--) {
                        reverse[i][columns - j - 1] = matrix[i][j];
                    }
                }
                return reverse;
            } else {
                throw new RuntimeException("rows size and columns size must be equal");
            }
        } else {
            throw new RuntimeException("matrix size must be greater than 0");
        }

    }

    public int[] getNumbersAboveSecondaryDiagonal(int[][] matrix) {
        return getNumbersAbovePrimaryDiagonal(reverseMatrix(matrix));
    }

}
