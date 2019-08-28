import sys

numeros = resultado = []
posicao = -1

def combinacao(n, k):
    global numeros, posicao, resultado

    for i in range(1, n+1): numeros.append(i)
    posicao = k
    resultado = [None] * posicao

def combinar(inicio, fim, profundidade):
    global posicao, resultado, numeros

    if profundidade+1 >= posicao:
        for x in range(inicio, fim+1):
            resultado[profundidade] = numeros[x]
            print('(', end='')
            for i in range(0, posicao): print(str(resultado[i]) + ("" if i == posicao-1 else " "), end='')
            print(") ", end='')

    else:
        for x in range(inicio, fim+1):
            resultado[profundidade] = numeros[x]
            combinar(x+1, fim+1, profundidade+1)

def imprimirCombinacao():
    global numeros, posicao
    combinar(0, len(numeros) - posicao, 0)
    print()
    numeros = resultado = []
    posicao = -1

args = sys.argv

combinacao(int(args[1]), int(args[2]))
imprimirCombinacao()

file = open(args[3], 'rt', encoding="utf8")
linhas = file.readlines()

for linha in linhas:
    n = int(linha.split(' ')[0])
    k = int(linha.split(' ')[1])

    combinacao(n, k)
    imprimirCombinacao()
