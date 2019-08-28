def permutacao(lista):
    if len(lista)==0:
        return []
    if len(lista)==1:
        return [lista]
    l = []
    for i in range(len(lista)):
        m = lista[i]
        final = lista[:i] + lista[i+1:]
        for p in permutacao(final):
            l.append([m] + p)
    return l


n = int(input("Digite o numero da sequencia que queres: "))
lista = []
for i in range(0, n):
    lista.append(i+1)

for p in permutacao(lista):
    print(p)
