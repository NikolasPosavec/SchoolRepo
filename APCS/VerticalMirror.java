public class VerticalMirror {
    public static void main(String[] args) {
        int[][] arr = {{1, 7, 31}, {14, 5, 6}};
        
        // Mirror left to right
        for (int[] row : arr) {
            for (int j = 0; j < row.length / 2; j++) {
                row[row.length - 1 - j] = row[j];
            }
        }
        
        // Print result
        for (int[] row : arr) {
            for (int num : row) System.out.print(num + " ");
            System.out.println();
        }
    }
}