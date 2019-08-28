#include <stdio.h>

void permutar(int *vetor, int n, int index) {
    int k;
    if (index == n) {
        printf("%d", vetor[0]);
        for (k = 1; k < n; k++) printf(" %d", vetor[k]);
        puts("");
        return;
    }
    for (k = index; k < n; k++) {
        int aux;
        aux = vetor[k];
        vetor[k] = vetor[index];
        vetor[index] = aux;

        permutar(vetor, n, index + 1);

        aux = vetor[k];
        vetor[k] = vetor[index];
        vetor[index] = aux;
	}
}
int main(void) {
	int n;
	printf("Numero de numeros que querem: ");
	scanf("%d", &n);
	int vetor[n];
	for(int i = 0; i < n; i++){
		vetor[i] = i+1;
	}
    permutar(vetor, n, 0);
    return 0;
}
