package Portfolio.SortingVisualizer;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SortingVisualizer 
{
    static final int ARRAY_SIZE = 100; //unsorted aray size
    static int delay = 50; //delay in ms
    static int[] array; //unsorted array

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Sorting Visualizer");
        SortingPanel panel = new SortingPanel(); //panel for visualizing sorting
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel controlPanel = new JPanel(); //panel for speed change buttons
        JButton speedUpButton = new JButton("Speed Up");
        JButton slowDownButton = new JButton("Slow Down");

        //adjust speed when buttons are clicked
        speedUpButton.addActionListener(e -> adjustSpeed(0.75));
        slowDownButton.addActionListener(e -> adjustSpeed(1.25));

        controlPanel.add(speedUpButton);
        controlPanel.add(slowDownButton);
        frame.add(controlPanel, BorderLayout.SOUTH); //putting controls at bottom

        frame.setVisible(true);

        initializeArray(); //create and fill the array with random values
        panel.setArray(array);

        //show choices to the user
        String[] options = {"Bubble Sort", "Merge Sort", "Quick Sort"};
        String choice = (String) JOptionPane.showInputDialog(
                frame,
                "Choose a sorting algorithm:",
                "Sorting Algorithms",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        //execute the chosen sorting algorithm
        if (choice != null) 
        {
            switch (choice) 
            {
                case "Bubble Sort":
                    bubbleSort(panel);
                    break;
                case "Merge Sort":
                    mergeSort(panel, 0, array.length - 1);
                    break;
                case "Quick Sort":
                    quickSort(panel, 0, array.length - 1);
                    break;
            }
        }
    }

    public static void initializeArray() 
    {
        array = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) 
        {
            array[i] = random.nextInt(ARRAY_SIZE) + 1; //fill array with values between 1 and ARRAY_SIZE
        }
    }

    public static void bubbleSort(SortingPanel panel) 
    {
        for (int i = 0; i < array.length - 1; i++) 
        {
            for (int j = 0; j < array.length - 1 - i; j++) 
            {
                if (array[j] > array[j + 1]) //swap if elements are in the wrong order
                {
                    swap(j, j + 1);
                    panel.repaint(); //refresh the panel to show current array state
                    sleep(); //pause for animation
                }
            }
        }
    }

    public static void mergeSort(SortingPanel panel, int left, int right) 
    {
        if (left < right) 
        {
            int mid = (left + right) / 2;
            mergeSort(panel, left, mid); //sort left half
            mergeSort(panel, mid + 1, right); //sort right half
            merge(panel, left, mid, right); //merge sorted halves
        }
    }

    public static void merge(SortingPanel panel, int left, int mid, int right) 
    {
        int[] temp = new int[right - left + 1]; //temporary array for merging
        int i = left, j = mid + 1, k = 0;

        //merge elements from both halves into temp array
        while (i <= mid && j <= right) 
        {
            if (array[i] <= array[j]) 
            {
                temp[k++] = array[i++];
            } 
            else 
            {
                temp[k++] = array[j++];
            }
        }

        //copy remaining elements from left half
        while (i <= mid) 
        {
            temp[k++] = array[i++];
        }

        //copy remaining elements from right half
        while (j <= right) 
        {
            temp[k++] = array[j++];
        }

        //copy sorted elements back to original array
        for (i = left; i <= right; i++) 
        {
            array[i] = temp[i - left];
            panel.repaint(); //refresh panel
            sleep(); //pause for animation
        }
    }

    public static void quickSort(SortingPanel panel, int low, int high) 
    {
        if (low < high) 
        {
            int pivotIndex = partition(panel, low, high); //partition the array
            quickSort(panel, low, pivotIndex - 1); //sort elements before pivot
            quickSort(panel, pivotIndex + 1, high); //sort elements after pivot
        }
    }

    public static int partition(SortingPanel panel, int low, int high) 
    {
        int pivot = array[high]; //pivot element
        int i = low - 1;

        for (int j = low; j < high; j++) 
        {
            if (array[j] < pivot) 
            {
                i++;
                swap(i, j); //swap elements
                panel.repaint(); //refresh panel
                sleep(); //pause for animation
            }
        }

        swap(i + 1, high); //place pivot in correct position
        panel.repaint();
        sleep();
        return i + 1;
    }

    public static void swap(int i, int j) 
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp; //swap two elements in the array
    }

    public static void sleep() 
    {
        try 
        {
            Thread.sleep(delay); //pause execution for animation
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt(); //handle interruption
        }
    }

    public static void adjustSpeed(double factor) 
    {
        delay = Math.max(1, (int) (delay * factor)); //adjust delay while keeping it positive
    }

    static class SortingPanel extends JPanel 
    {
        private int[] array; //array to be visualized

        public void setArray(int[] array) 
        {
            this.array = array;
        }

        @Override
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            if (array == null) return;

            int width = getWidth();
            int height = getHeight();
            int barWidth = width / array.length; //width of each bar

            for (int i = 0; i < array.length; i++) 
            {
                int barHeight = (int) ((double) array[i] / ARRAY_SIZE * height); //scale height
                g.setColor(Color.BLUE); //bar color
                g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight); //draw bar
                g.setColor(Color.BLACK); //outline color
                g.drawRect(i * barWidth, height - barHeight, barWidth, barHeight); //draw outline
            }
        }
    }
}

