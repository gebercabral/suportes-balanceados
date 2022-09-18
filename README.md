# suportes-balanceados

Desafio

Escreva uma função que receba uma string de colchetes como entrada e determine se a
ordem dos colchetes é válida. Um colchete é considerado qualquer um dos seguintes
caracteres: (, ), {, }, [ ou ].
Dizemos que uma sequência de colchetes é válida se as seguintes condições forem
atendidas:
● Não contém colchetes sem correspondência.
● O subconjunto de colchetes dentro dos limites de um par de colchetes correspondente
também é um par de colchetes correspondente.

Exemplos:


● (){}[] é válido
● [{()}](){} é válido
● []{() não é válido
● [{)] não é válido

Pré requisitos:
Java 8
Maven

Execução:
Abra o terminal e digite : mvn spring-boot:run

Após isso basta digita a string para verificar se é válido ou não.

