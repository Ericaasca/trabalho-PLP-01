import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class Main {
    private static int numeros[], resultado[], posicoes;

    private static void combinacao(int n, int k) {
        numeros = new int[n];
        for (int i = 1; i <= n; i++)
            numeros[i - 1] = i;

        posicoes = k;
        resultado = new int[posicoes];
    }

    private static void combinar(int inicio, int fim, int profundidade) {
        if ((profundidade + 1) >= posicoes) {
            for (int x = inicio; x <= fim; x++) {
                resultado[profundidade] = numeros[x];
                System.out.print("(");

                for (int i = 0; i < posicoes; i++) {
                    System.out.printf("%d%s", resultado[i], (i == posicoes - 1) ? "" : " ");
                }
                System.out.print("), ");
            }

        } else {
            for (int x = inicio; x <= fim; x++) {
                resultado[profundidade] = numeros[x];
                combinar(x + 1, fim + 1, profundidade + 1);
            }
        }
    }

    private static void imprimirCombinacoes() {
        combinar(0, numeros.length - posicoes, 0);
        System.out.println();
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        combinacao(n, k);
        imprimirCombinacoes();

        try {
            List<String> allLines = Files.readAllLines(Paths.get(args[2]));
            for (String line : allLines) {
                String entrada[] = new String[2];
                entrada = line.split(" ");
                
                combinacao(Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1]));
                imprimirCombinacoes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}