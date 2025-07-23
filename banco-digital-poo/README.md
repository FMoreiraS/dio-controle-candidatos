# BANCO-DIGITAL-POO
Este projeto tem por fim pôr em praticar o conhecimento de orientação a objetos, mas recebe também um pouco de
programação funcional, com as implementações de uma collection set e da interface funcional Consumer. 
## Estrutura
Isto consiste num pequeno sistema bancário, composto pelas classes:
- `Banco`;
- `Conta`, abstrata;
- `ContaCorrente` e `ContaPoupanca`, que estendem Conta;
- `Cliente`;
- `Main`, a principal.  
## Descrição
Banco contém um set de contas (`contas`), pois essa coleção *impede a ocorrência de objetos iguais*, tendo aqui o
número da conta como parâmetro. É também a classe responsável por adiconar, lista, buscar e remover objetos do tipo
Conta nesse set. Cabe destacar o método listarContas em Banco: é onde se aplica programação funcional. Aí, há um
tree set para ordenar o set em ordem cresecente de número de conta, um consumer com uma função lambda - para exibir
as informações duma conta - e o método forEach da Stream API - para usar esse Consumer com todas as contas.  
Isso é possível porque a classe Conta possui uma classe interna (`CompararPorNumero`) que implementa a interface
Comparator para comparar os números das contas, usada como parâmetro para na criação do tree set acima mencionado.
Além disso, Conta possui métodos para imprimir extrato, depositar, sacar, transferir e imprimir informações comuns
a qualquer tipo de conta.  
ContaCorrente e ContaPoupanca são especializações da classe Conta que, sendo abstrata, não pode ser instanciada,
atendendo à regra de negócio comum de bancos, capaz de disponibilizar apenas contas do tipo corrente ou do tipo
poupança. Cliente atende também a uma exigência formal, afinal uma conta precisa pertencer a um cliente.  
Enfim, a classe Main é responsável por exibir o menu da aplicação e realizar todas as operações, conforme as entradas
do usuário, mediante a classe Scanner.