 

/**
 * Aplicação.
 *
 * @author (Lorenzo Duarte - 22103093-5)
 * Este exercício foi bem interessante pois permitiu manipular o registro de pacientes de um hospital. As minhas principais
dificuldades foram manipular o menu e vetores. Gustavo me ajudou nas duas. Com o menu, era algo simples como ao inves de ter só 
um while, colocar o menu em uma estrutura de do...while. Já para a parte de vetores, tendo em vista que tinha perdido as aulas 
sobre o assunto, comecei a entender tanto a sintaxe quanto a lógica e o potencial dos vetores. Antes de nos reunirmos eu tinha 
feito vários switch cases, e o código não estava tão eficiente; funcionava, mas estava comprido e eu tinha ideias que só poderiam 
ser resolvidas com vetores. Além disso, consultei um site na internet para conseguir gerar os números aleatórios para o CPF 

link do site:
https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java#:~:text=Random%20
rand%20%3D%20new%20Random()%3B,of%20the%20array)%20and%20array.
 * 
 * 
 * @author (Gustavo W.M. Silva - 22111252-7)
 * @Apredizado (
 * Utilizamos, como aprendido em aula o Array, dando uma boa simplificada no codigo e diminuindo o numero de repetição de informação. 
 * Utilização e manipulação de informação nas classes.//Não tivemos tempos de implementar o Array e organizar melhor as classes
 * A utilização de diversas aprendizados (metodos, classes, array, manipulação de valores...) em um unico programa, tendo eles interligados, com um utilizando o outro;
 * Desenvolimento em trabalho de equipe, com argumentação e implementação do codigo, tendo um auxiliando o outro; raciocinando e debatendo para a solução de problemas;
 * )
 * 
 * @version (2/6/22)
 */
import java.util.*;
public class AppAplicacao
{   
    public static int menuPrincipal () 
    {//metodo que define o menu principal
        Scanner teclado = new Scanner (System.in);
        int opcao = 0;//inicializando variavel opcao
        System.out.println ("\f***** Menu Principal *****");
        System.out.println ("\nDigite a opção desejada:");
        System.out.println ("\n[1] - Registrar novo paciente (em construção)");
        System.out.println ("\n[2] - Consultar dados dos pacientes");
        System.out.println ("\n[3] - Alterar dados dos pacientes");
        System.out.println ("\n[4] - Consultar valor total a receber pelas consultas dos pacientes");
        System.out.println ("\n[5] - Consultar paciente cujo nome possui o maior número de vogais" );
        System.out.println ("\n[6] - Estatística da quantidade de paciente com cada doença" );
        System.out.println ("\n[7] - Sair" );
        opcao = teclado.nextInt(); 
        return opcao;
    }

    public static Paciente registrarPaciente() 
    {//metodo utilizado para registrar novos pacientes
        Scanner teclado = new Scanner (System.in);
        System.out.println ("\fDigite o nome do paciente: ");
        String nomeN = teclado.nextLine();
        System.out.println ("\nDigite o nome do convênio: ");
        String convenioN = teclado.nextLine();
        System.out.println ("\nCPF do paciente (gerado aleatoriamente): ");
        String cpfN = geradorCpf();
        System.out.println (cpfN);
        System.out.println ("\nDigite o telefone do paciente:");
        String telefoneN = teclado.nextLine();
        System.out.println ("\nInforme o diagnóstico: " +
            "\n1 - Covid" +
            "\n2 - Zica" +
            "\n3 - Chikungunya" +
            "\n4 - Dengue" +
            "\n5 - Outro");
        int valor = teclado.nextInt();
        String diagnosticoN = "";//permanecera em branco se usuario digitar numero < 1 ou > 5
        switch (valor)
        {
            case 1: {diagnosticoN = "Covid"; break;}   
            case 2: {diagnosticoN = "Zica"; break;}
            case 3: {diagnosticoN = "Chikungunya"; break;}
            case 4: {diagnosticoN = "Dengue"; break;}
            case 5: {diagnosticoN = "Outro"; break;}
            default: System.out.println ("\nDIAGNÓSTICO NÃO REGISTRADO! Altere depois utilizando a opção 3 do menu principal.");//caso usuario digite numero < 1 ou > 5              
        }
        System.out.println("\nInforme o número de consultas no mês: ");
        int consultasN = teclado.nextInt();
        return new Paciente (nomeN, convenioN, cpfN, telefoneN, diagnosticoN, consultasN);
    }

    public static String geradorCpf () 
    {//metodo que gera uma string com 11 numeros aleatorios entre 0 e 9
        String x = "";
        int tamanho = x.length();
        int minimo = 0;
        int maximo = 9;
        int alcance = maximo - minimo;
        double randomico = Math.random();
        for (int i = 0; i < 11; i++) 
        {
            x = x + (minimo + (int)(Math.random() * (alcance + 1)));
        }
        return x;
    }

    public static int valorConsulta (int consultas) 
    {//método que recebe o numero de consultas como parâmetro e retorna o valor total a ser pago pelas consultas do mês
        int valor = 150;
        return valor * consultas;
    }

    public static int vogais (String palavra) 
    {//metodo que retorna a quantidade de vogais de uma string
        palavra = palavra.toLowerCase();//transformando tudo em minuscula para nao precisar verificar as maiusculas
        int quantidade = 0;//quantidade de vogais
        for (int contador = 0; contador < palavra.length(); contador++) 
        {
            char letra = palavra.charAt(contador);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {quantidade ++;}
            else if (letra == 'á' || letra == 'à' || letra == 'â' || letra == 'ã') {quantidade ++;}
            else if (letra == 'é' || letra == 'è' || letra == 'ê' || letra == 'ẽ') {quantidade ++;}
            else if (letra == 'í' || letra == 'ì' || letra == 'î' || letra == 'ĩ') {quantidade ++;}
            else if (letra == 'ú' || letra == 'ù' || letra == 'û' || letra == 'ũ') {quantidade ++;}
        }
        return quantidade;
    }
    public static void imprime(int tamanhoVetor,Paciente []pacientes )
    {
    for(int j=0; j<tamanhoVetor;j++)//imprimir os pacientes
     {
        System.out.println(" |"+(j+1)+"|"+pacientes[j].getNome()); 
       }
    }

    public static void main (String [] args) 
    {
        Scanner teclado = new Scanner (System.in);
        Paciente [] pacientes = new Paciente [3];//vetor que pode guardar 3 objetos da classe Paciente
        Paciente um = new Paciente ("Valdirene", "ESTRELA", geradorCpf(),  "51999887710", "Zica", 2);
        Paciente dois = new Paciente ("Jocelino", "HELP class", geradorCpf(), "51966226710", "Dengue", 3);
        Paciente tres = registrarPaciente();//chamando metodo registrar paciente
        String[] doencas = {"Covid", "Zica", "Chikungunya", "Dengue", "Outro"};//vetor com as doenças: armazena 5 strings

        pacientes [0] = um;//armazenando objeto um na posicao 0 do vetor pacientes
        pacientes [1] = dois;
        pacientes [2] = tres;

        //criando vetor composto pela quantidade de vogais em cada posicao do vetor pacientes
        int[] vetorVogais = {vogais(pacientes [0].getNome()), vogais(pacientes [1].getNome()), vogais (pacientes [2].getNome())};
        int tamVogais = vetorVogais.length;

        int[] vogaisClone = new int[tamVogais];

        //tamanhos dos vetores
        int tamanhoVetorVogais = vetorVogais.length; 
        int tamanhoVetor = pacientes.length;
        int tamDoencas = doencas.length;

        int contador1 = 0;

        int opcao = 0;
        do {
            opcao = menuPrincipal();
            switch (opcao) 
            {
                case 1://registrar novo paciente (em construção)
                    {
                        registrarPaciente();
                    } 
                    break;
                case 2://consultar dados dos pacientes 
                    {
                        System.out.println ("\f***** Paciente um *****\n" + um + "\n***** Paciente dois *****\n" + dois + "\n***** Paciente três *****\n" + tres);
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next();
                    } 
                    break;
                case 3://alterar dados dos pacientes 
                    {
                        System.out.println ("\fEscolha uma opção:");
                        System.out.println ("\n1 - Alterar diagnóstico" +
                            "\n2 - Alterar convênio" +
                            "\n3 - Voltar");
                        int escolha = teclado.nextInt();

                        switch(escolha)
                        {
                            case 1:
                                {
                                    System.out.println("\fEscolha o Paciente:");
                                    imprime(tamanhoVetor,pacientes);

                                    int mudarD=teclado.nextInt();
                                    int i=mudarD-1;
                                    if(i<tamanhoVetor && i>=0){
                                        System.out.println("\fDados do Paciente");
                                        System.out.println("\nNome: "+pacientes[i].getNome());
                                        System.out.println("Diagnostico atual: "+pacientes[i].getDiagnostico());
                                        System.out.println("\nEscolha o novo diagnostico: ");
                                        for(int n=0;n<doencas.length;n++)
                                        {
                                            System.out.println(" | "+(n+1)+"- "+doencas[n]);
                                        }

                                        int trocaDoença=teclado.nextInt()-1;
                                        if(trocaDoença<tamDoencas && trocaDoença>=0){
                                            pacientes[i].setDiagnostico(doencas[trocaDoença]);

                                            System.out.println("\f\nDiagnostico Atualizado com Sucesso ");

                                        }else { System.out.println("\fDiagnóstico  não registrado:");}
                                    }else { System.out.println("\fOpção invalida:");}

                                    System.out.println("\nPressione qualquer tecla:");
                                    teclado.next();

                                }break;

                            case 2://para mudar o Convenio
                                {
                                    System.out.println("\fEscolha o Paciente:");
                                    imprime(tamanhoVetor,pacientes);
                                    
                                    int mudarC=teclado.nextInt();
                                    int i=mudarC-1;
                                    if(i<tamanhoVetor && i>=0){
                                        System.out.println("\fDados do Paciente");
                                        System.out.println("\nNome: "+pacientes[i].getNome());
                                        System.out.println("Covenio atual: "+pacientes[i].getConvenio());

                                        System.out.println("\nDigite o novo Convenio: ");
                                        String convenioN=teclado.nextLine();
                                        String f=teclado.nextLine();
                                        pacientes[i].setConvenio(f);

                                        System.out.println("\fConvenio Atualizado com Sucesso. ");

                                    }else { System.out.println("\fOpção invalida:");}

                                    System.out.println("\nPressione qualquer tecla:");
                                    teclado.next();

                                    System.out.println("\f ");

                                }
                                
                            case 3://voltar  
                                break;
                            default: 
                                System.out.println("\f\nOPÇÃO INVALIDA. Pressione qualquer tecla:");
                                teclado.next();
                        }
                    } 
                    break;
                case 4://consultar valor total a receber pelas consultas dos pacientes 
                    {
                        int valorUm = valorConsulta (um.getConsultas());
                        int valorDois = valorConsulta (dois.getConsultas());
                        int valorTres = valorConsulta (tres.getConsultas());

                        System.out.println ("\f\nValor a receber de " + um.getNome() + " : R$ " + valorUm);
                        System.out.println ("\nValor a receber de " + dois.getNome() + " : R$ " + valorDois);
                        System.out.println ("\nValor a receber de " + tres.getNome() + " : R$ " + valorTres);
                        System.out.println ("\nValor total a receber dos pacientes: R$ " + (valorUm + valorDois + valorTres));
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next();
                    } 
                    break;
                case 5://consultar paciente cujo nome possui o maior número de vogais 
                    {
                        //transformando em minuscula para nao ter que verificar as vogais maiusculas
                        String nome1 = um.getNome().toLowerCase();
                        String nome2 = dois.getNome().toLowerCase();
                        String nome3 = tres.getNome().toLowerCase();
                        int x = 0;
                        for(int i=0;i< tamVogais;i++) 
                        {//for para clonar um vetor. o clone, nesse caso, recebe os valores do vetor original, enquanto o outro eh manipulado 
                            vogaisClone[i] = vetorVogais[i];
                        }

                        int aux = 0;

                        for (int i = 0; i < tamVogais; i++) 
                        {//for para ordenar em ordem descrescente
                            for (int j = 0; j < i; j++) 
                            {
                                if (vetorVogais [i] > vetorVogais [j]) 
                                {
                                    aux = vetorVogais [i];
                                    vetorVogais [i] = vetorVogais [j];
                                    vetorVogais [j] = aux;
                                }  
                            }
                        }
                        System.out.println ("\fNome(s) com mais vogais: \n");
                        for (int i = 0; i < tamVogais; i++) 
                        {//for que imprime nome dos pacientes do vetor original
                            if (vetorVogais[0] == vogaisClone[i]) 
                            {//se o int da posicao 0 do vetorVogais (que eh o maior numero deste vetor) for igual ao numero de vogais do vetor original, este nome deve ser printado
                                System.out.println ("Nome: " + pacientes [i].getNome());
                            }
                        } 

                        System.out.println ("\nNúmero de vogais no(s) nome(s): " + vetorVogais[0]);
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next();
                    } 
                    break;
                case 6://estatística da quantidade de paciente com cada doença 
                    {
                        double []contador= {0,0,0,0,0};
                        double contador2 = 0;System.out.println ("\f***** ESTAT�?STICAS *****");
                        for (int i = 0; i < tamDoencas; i++) 
                        {//for que conta a quantiade das doenças
                            for (int j = 0; j < tamanhoVetor; j++) 
                            {
                                if (doencas[i].equalsIgnoreCase ( pacientes[j].getDiagnostico())) 
                                {    
                                    contador[i]++;
                                    contador2++;
                                }
                            }
                        }
                        int a = (int) contador2;
                        System.out.printf ("\nDiganósticos registrados: %d \n\n", a);

                        for (int i = 0; i < tamDoencas; i++) 
                        {
                            double porcento = (contador[i] / contador2) * 100;
                            System.out.print (doencas[i] + ": ");
                            System.out.printf ("%.2f %% \n", porcento);
                        }
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next();
                    } 
                    break;
                case 7://sair 
                    {
                        System.out.println("\nEncerrando o programa. Até logo!");   
                    } 
                    break;
                default:
                    System.out.println("\nOPÇÃO INV�?LIDA. Pressione qualquer tecla:");
                    teclado.next();
            }
        } while (opcao != 7);//enquanto usuario nao digitar 7, menu repete 
    }
}
