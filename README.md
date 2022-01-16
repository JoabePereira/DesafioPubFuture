# DesafioPubFuture
Controle de Finanças - Desafio PubFuture

Este projeto tem como propósito auxiliar nas finanças pessoais.

#### Orientações para rodar a aplicação

Clone a aplicação do github através da URL: https://github.com/JoabePereira/DesafioPubFuture <br>
Importe para o Spring Too Suite 4 e execute <br>
O projeto esta documentado com Swagger, neste caso, é possível testar pela URL: http://localhost:8080/swagger-ui.html <br>
Também é possível testar utilizando o Postman fornecendo os parâmetros adequados quando necessário <br>
Um perfil de teste foi criado (TestConfig) pra carregar alguns dados no banco ao executar a aplicação <br>
Para armazenar os dados, foi utlizado o banco de dados H2 acessível pela URL: http://localhost:8080/h2-console

#### Urls Acessíveis

**Conta** <br>http://localhost:8080/contas <br>
URL para acessar todas as contas cadastradas <br>
Utilize essa URL também para inserir uma nova conta fornecendo apenas ***saldo***, ***tipo da conta*** e ***instituição financeira*** <br>

http://localhost:8080/contas/1 <br>
Deletar uma conta pelo id <br>
Atualizar uma conta pelo id, sendo que, o único dado que está permitido alterar pra uma conta é o ***saldo*** <br>

**Despesa** <br>http://localhost:8080/despesas <br>
URL para acessar todas as despesas cadastradas <br>
Utilize essa URL também para inserir uma nova despesa, fornecendo todos os campos com exceção do ***id*** que é gerado pelo banco de dados <br>

http://localhost:8080/despesas/1 <br>
Deletar uma despesa pelo id <br>
Atualizar uma despesa pelo id <br>

http://localhost:8080/despesas/data-pagamento <br>
Lista despesas por período, forneça a ***dataInicial*** e a ***dataFinal*** <br>

http://localhost:8080/despesas/tipo-despesa <br>
Lista despesa por tipo, forneça o ***tipo despesa*** <br>

**Receita** <br>
http://localhost:8080/receitas <br>
URL para acessar todas as receitas cadastradas <br>
Utilize essa URL também para inserir uma nova receita, fornecendo todos os campos com exceção do ***id*** que é gerado pelo banco de dados <br>

http://localhost:8080/receitas/1 <br>
Deletar uma receita pelo id <br>
Atualizar uma receita pelo id <br>

http://localhost:8080/receitas/data-recebimento <br>
Lista receitas por período, forneça a ***dataInicial*** e a ***dataFinal*** <br>

http://localhost:8080/receitas/tipo-receita <br>
Lista receita por tipo, forneça o ***tipo receita*** <br>

