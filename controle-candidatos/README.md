## CONTROLE-CANDIDADTOS

### Visão geral
Este projeto destina-se a exercitar os conceitos de **controle de fluxo** em **Java** puro, com um sistema de
validação de processo seletivo para vagas de emprego, proposto pela [DIO](https://github.com/digitalinnovationone).
Em suma, o sistema deve ser capaz de indicar se os candidatos adequam-se à exigência da vaga: ter pretensão 
salarial igual ou inferior ao salário base sugerido; listar os selecionados e ligar para eles.
### Detalhamento
1. Todo o sistema está construído na classe ProcessoSeletivo;
2. O salário base sugerido é de R$ 2000, e foi implementado como double; 
3. Os candidatos totalizam 10 e são agrupados como um array estático de Strings;
4. Todos os métodos criados são públicos e estáticos;
5. Foram usadas como apoio 3 classes do pacote `util` da linguagem: "ThreadLocalRandom", "Random" e "Scanner";

Uma observação relevante: todos os métodos foram sugeridos pelo então instrutor da DIO [Gleyson
Sampaio](https://github.com/glysns).

Cabe agora descrever o funcionamento geral. O método `selecionarCandidatos` usa
o array estático de strings "candidatos" em um **while** para indicar quais candidatos são
adequados à vaga, segundo a pretensão salarial, e acrescenta-os noutro array, chamado
"selecionados", enquanto o número de selecionados for inferior a 5. Este método foi auxiliado
por outro chamado `definirPretensao`, que retorna um valor double aleatório entre 1800 e
2200, mediante os métodos "current" e "nextDouble" da classe "ThreadLocalRandom".

O método `analisarCandidato`, é uma alternativa ao primeiro, e recebe do usuário o valor 
pretendido pelo candidato ou executa a análise com um valor obtido de "definirPretensao",
usando um bloco de **if, else if, else** para definir a adequação do candidato, além de 
**try e catch** para captar entradas incorretas.

O método `listarSelecionados` imprime uma lista com os elementos do array "selecionados",
acrescentados por "selecionarCandidatos", e nomeia como **Não selecionado** os elementos
com valor `null`, para uma melhor visualização.

O método `ligarParaSelecionado` recebe uma string correspondente a um candidato como parâmetro
e simula ligações telefônicas. Primeiro é feita validação para que o método não recebe uma
string com valor `null`. Em seguida usa um **do... while** com  **if e else** para imprimir
uma mensagem indicativa de contato bem ou mal sucedido, com o auxílio do método `atender`,
que retorna um **boolean**, de modo que, se o valor for **true**, o candidato atendeu e não é
mais necessário ligar, se **false**, continua a iteração, até um máximo de 3 tentativas.

Por fim, o método `ligarParaSelecionados` apenas itera no método anterior com um for sobre o
array **selecionados**, permitindo que se possa testar o contato com candidatos tanto individual
quanto coletivamente.

### Desafio
Além do projeto acima descrito, [neste repositório](https://github.com/digitalinnovationone/trilha-java-basico/tree/main/desafios/controle-fluxo)
propõe-se um desafio, resolvido no pacote dedicado `desafio`. Trata-se de uma prática simples
de **controle de fluxo**, que inclui o uso de:
1. entrada de dados pelo usuário, mediante a classe Scanner;
2. estrutura condicional (if);
3. laço de repetição (for) e
4. exceção, contando com uma exceção própria.