public class UncheckedException {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        try{
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("陣列索引超出範圍");

        }
    }
}
