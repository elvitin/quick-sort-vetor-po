import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void quickSortSemPivoRecursivo(int inicio, int fim, int[] vet)
    {
        int i = inicio;
        int j = fim;
        int aux;
        boolean vezI = true;

        while (i < j) {
            if(vet[i] > vet[j])
            {
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
                vezI = !vezI;
            }

            if (vezI)
                i++;
            else
                j--;
        }

        if (inicio < i - 1)
            quickSortSemPivoRecursivo(inicio, i - 1, vet);
        if (j + 1 < fim)
            quickSortSemPivoRecursivo(j + 1, fim, vet);
    }

    public static void quickSortSemPivo(int[] vet) {
        quickSortSemPivoRecursivo(0, vet.length - 1, vet);
    }

    public static void display(int... arr)
    {
        for (int j : arr) {
            System.out.printf("[%d]", j);
        }
        System.out.println();
    }
    static final Random random = new Random();
    public static int getRandNumber(int min, int max)
    {
        return random.nextInt(max - min + 1) + min;
    }
    
    public static boolean validaOrdenacao(int[] arr)
    {
        // Array has one or no element
        if (arr.length == 0 || arr.length == 1)
            return true;

        for (int i = 1; i < arr.length; i++)

            // Unsorted pair found
            if (arr[i - 1] > arr[i])
                return false;

        // No unsorted pair found
        return true;
    }
    public static void main(String... args) {

        int[] arr = new int[getRandNumber(50, 100)];
        System.out.printf("[%d] Elementos no array\n", arr.length);

        Arrays.setAll(arr, i -> getRandNumber(0, 100));

        display(arr);
        System.out.println("------------------");

        quickSortSemPivo(arr);

        display(arr);

        if(validaOrdenacao(arr))
            System.out.println("Vetor está ordenado!");
        else
            System.out.println("Vetor desordenado!");
    }
}