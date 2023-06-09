package ru.intensive.week06.exeptions;

public class ExecExamples {

    private final static int ARRAY_SIZE = 4;

    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] wrongDataArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "S", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] shortArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "S", "11", "12"}, {"13", "14", "15"}};

        check4X4("array", array);
        check4X4("wrongDataArray", wrongDataArray);
        check4X4("shortArray", shortArray);
    }

    public static void check4X4(String name, String[][] array) {
        try {
            if (array.length != ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
            for (String[] row : array) {
                if (row.length != ARRAY_SIZE) {
                    throw new MyArraySizeException();
                }

            }

            int sum = 0;
            for (int i = 0; i < ARRAY_SIZE; i++) {
                for (int j = 0; j < ARRAY_SIZE; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }

            System.out.println(name + ". Сумма всех ячеек: " + sum);

        } catch (MyArraySizeException mase) {
            System.out.println(name + ". Неверный размер массива");
        } catch (MyArrayDataException made) {
            System.out.println(name + ". Неверные данные в ячейке: [" + made.getI() + ", " + made.getJ() + "]");
        }
    }
}
