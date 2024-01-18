/**
 *Trabalho1 
 *
 * @author (Gustavo W.M. Silva - 22111252-7)
 * @Apredizado (
 * Utilizei, como aprendido em aula o Array, dando uma boa simplificada no codigo e diminuindo o numero de repetição de informação. 
 * Utilizei e manipulação de informação nas classes para deixar o codigo mais organizado visualmete.
 * O trabalho me possibilitou a aplicação de diversas aprendizados (metodos, classes...) em um unico programa, tendo eles interligados, 
 * com um utilizando o outro e me ajudou a melhorar o meu dominio sobre alguns conceitos; 
 * 
 * Problema: esta no readme e esta logo abaixo
 * )
 * @version(16/06/2022)
 */
public class Principal
{
    public static void main(String[]args)
    {
        Trabalho1 pronto=new Trabalho1();
        pronto.App();
    }
}
/**
 * Problema 1:
 *  O programa estava dando erro  na parte de contar quantos dias faltam para o aniversario, o calculo dava certo quando o dia era 
 *igual a o da data do sistema, mas quando era diferente diminuía ou aumentava a quantidades de dias. 
*
* Resolução: Demorei um bom tempo até descobrir o que estava acontecendo de errado, depois de vários testes e pesquisa descobri 
* um padrão nos erros:  
*
*Ex.  
*
*Hoje= 16/06 
*
*Aniversario= 20/09  
*
// 3 meses de diferença e 4 dias 
*
//multiplicava 4*3 e somava esse valor com a quantidade de dias que faltava até dia  16/09 
*
// o mesmo acontece quando a quantidade de dias do aniversario é menor do que a do sistema, só que ao invés de somar ele diminui; 
*
*
*
*O programa multiplicava a diferença de dias pela diferença de meses, ou seja, quando o dia do aniversário estava mais distante do
* dia no sistema maior era o erro. 
*
*Resolução: 
*
*Coloquei um contador, para saber quantos meses tinham se passado; 
*
*Diminui o dia atual pelo do aniversário; 
*
* Quando o dia atual é maior que o dia do aniversário: diminui o do aniversario pelo do dia atual; 
*
*Multiplica esses valores pelo contador, depois soma ou diminui dependendo dos dois tópicos anteriores; 
*
*
*
*Problema 2:
*
* Meu programa estava apresentando erro na hora de executar, estava pulando direto algumas informaçõe na tela mesmo eu colocando o 
* teclado.nextLine();, por isso eu tive que colocar dois em alguns casos.
* Obs: pode ser que seja problema no meu PC.
 */