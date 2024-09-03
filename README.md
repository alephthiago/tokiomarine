# tokiomarine
Repositório para teste técnico

O projeto está em java 17 por alguns impedimentos técnico mas a intenção desde o começo foi usar logica e recursos de java 8-11 para se adequar

As duas contas cadastradas são 1234567890 e 1987654321

A aplicacao informa e bloqueia agendamento caso as contas tentadas nao existão

A aplicacao informa e bloqueia agendamento com uma mensagem vermelha abaixo do logo caso não exista taxa aplicável 

A aplicacao informa mas não bloqueia agendamento caso o valor que se planeja transferir seja maior do que existe na conta inicialmente, imaginasse que até lá o usuario tenha o saldo necessário

A aplicacao informa mas não bloqueia agendamento caso exista saldo suficiente

A aplicacao não foi feita em hexagonal por causa da pequena quantidade de negocio, nao necessidade de eventos de mudança de estado de varias entidades via eventos/mensagem e
 a definicao de apenas um front e um datasource.

Existe um teste unitario básico com asserts só para demonstracao

Interpretei o padrão XXXXXXXXXX como alphanumerico, espero que tenha sido o correto

No enunciado "2. O cálculo da taxa sobre o valor a ser transferido depende da data de transferência como segue: (tabela)"
 o que foi possivel entender é que o calculo da taxa depende do range de data para qual foi agendada a transferencia,
  a coluna "R$" na tabela ficou meio que avulsa na lógica portanto optei por ignorar já que a aplicacao não é responsavel por aplicar e deduzir taxas, apenas 
fazer o agendamento, caso não fosse essa a intenção peço desculpas.

Existiam diferentes formas de fazer essa solução, por exemplo back-heavy com funcoes diferentes sequenciais, multiplos nano services, camel orquestrando e mais, a opção aqui era a mais simples
 para o tamanho e demonstraçao e o front ficou com mais responsabilidades de validações.
 
 


