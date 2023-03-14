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
    public static void main(String[] args) {
        int []arr = {4, 2, 1, 6, 7, 12, 9, 11};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d]", arr[i]);
        }
        quickSortSemPivo(arr);
        System.out.println("\n------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d]", arr[i]);
        }
        System.out.println();
    }
}