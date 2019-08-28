#include <stdio.h>
#include <stdlib.h>

int main(){
   int *vet;
   int k, n, i, j, m;
   
   printf("Subsequências de n: ");
   scanf("%d", &n);
   vet = (int *) malloc (n*sizeof(int));
   for(i = 0; i < n; i++){
       vet[i] = i+1;
   }
   
   printf("Valor de k: ");
   scanf("%d", &k);   
   for(i = 0; i < n; i++){
       for(j = i+1; j < n-(k-2); j++){
           printf("%d", vet[i]);
           for(m = j; m < j+k-1; m++){
               printf(",%d", vet[m]);
           }
           printf("\n");
       }
   }
   
    return 0;
}
