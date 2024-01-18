import java.util.*;

public class CadastroPaciente

{
    private Paciente [] vetor;//atributo atua como objeto da classe Paciente (isso cria setinha tambem)
    //private Paciente p1;
    private int index;//colocar o index aqui permite que ele possa ser chamado com o valor atualizado atualizado nos outros metodos
    private String[] doencas = {"Covid", "Zica", "Chikungunya", "Dengue", "Varíola do macaco", "Outro"};

    public CadastroPaciente(int tamanho)
    {//responsavel por criar a estrutura na memoria
        vetor = new Paciente[tamanho];
        index = 0;//indice que vai ajudar a percorrer as posicoes do vetor
    }

    public boolean adicionaNoVetor(Paciente c)
    {//kit basico
        if(index >= vetor.length)
        {
            return false;
        } else
            {
                vetor[index] = c;
                index++;//vai para proxima posicao
                return true;
            }
    }

    //pesquisar no vetor
    public Paciente pesquisaNoVetor(String nome1)
    {//metodo que retorna o carro que esta na posicao
        int i = pesquisarPosicao(nome1);//verificar a posicao no vetor que tem a nome1: furo: pode ser que nao tenha nada la
        if(i >= 0)
        {
            return vetor[i];//retorna o carro
        } else 
            {  
                return null;//carro nao se encontra na posicao
            }
    }

    //pesquisar no vetor
    public int pesquisarPosicao(String nome1)
    {       
        for(int i=0; i<index; i++)
        {
            if(vetor[i].getNome().equalsIgnoreCase(nome1))
            {
                return i;
            }            
        } 
        return -1;//numero negativo pq nao existe posicao negativa no vetor
    }

    //remover do vetor
    public boolean removeDoVetor(String nome1)
    {//kit basico
        int posicao = pesquisarPosicao(nome1);                
        if(posicao == -1) {return false;}
        for(int i=posicao; i<index-1; i++)
        {
            vetor[i] = vetor[i+1];
        }
        vetor[index-1] = null;//deixando a ultima posicao com null      
        index--;//retirar uma das posicoes ocupadas        
        return true; 
    }

    public void imprimeVetor()
    {//kit basico
        System.out.println("\f");
        for(int i=0; i < index; i++)
        {
            System.out.println("\nPACIENTE " + (i+1) + ":\n");            
            System.out.println(vetor[i].toString());
        }        
    }
    
    public void imprimeVetor7()
    {//kit basico
        System.out.println("\fPosições ocupadas no vetor:\n");
        for(int i=0; i < index; i++)
        {
            System.out.println("Na posição "+(i+1)+" está o paciente "+vetor[i].getNome());
        }        
    }
    
    public String[] ordemAlfabetica (String[] vetor)
    {//ordena um vetor de String em ordem alfabetica crescente
        String aux = "";
        boolean troca = false;
        do{
            troca = false;
            for(int i = 0; i < index - 1;i++)
            {
                if(vetor [i].compareToIgnoreCase (vetor [i+1]) > 0)
                {
                    aux = vetor[i];
                    vetor [i] = vetor[i+1];
                    vetor [i+1] = aux;
                    troca = true;
                }
            }
        } while (troca);
        return vetor;   
    }
    
    public double media () 
    {
        double media = 0;
        for (int i = 0; i < index; i++) 
        {
            media = media + vetor [i].getConsultas ();
        }
        media = media / index;
        return media;
    }

    public void media2 () 
    {
        System.out.println ("\fMédia de consultas dos paciente: " + media () );
    }
    
    public Paciente[] getPaciente() { return vetor;} 
    //gerador de cpf aleatório
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
    
    public void registrarPaciente() 
    {//metodo utilizado para registrar novos pacientes
        Scanner teclado = new Scanner(System.in);
        System.out.println ("\fCADASTRO: ");
        System.out.println ("\nDigite o nome do paciente: ");
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
            "\n5 - Varíola do macaco" +
            "\n6 - Outro");
        int valor = teclado.nextInt();
        String diagnosticoN = "";//permanecera em branco se usuario digitar numero < 1 ou > 5
        switch (valor)
        {
            case 1: {diagnosticoN = "Covid"; break;}   
            case 2: {diagnosticoN = "Zica"; break;}
            case 3: {diagnosticoN = "Chikungunya"; break;}
            case 4: {diagnosticoN = "Dengue"; break;}
            case 5: {diagnosticoN = "Varíola do macaco"; break;}
            case 6: {diagnosticoN = "Outro"; break;}
            default: System.out.println ("\nDIAGNÓSTICO NÃO REGISTRADO! Altere depois utilizando a opção 3 do menu principal.");//caso usuario digite numero < 1 ou > 5              
        }
        System.out.println("\nInforme o número de consultas no mês: ");
        int consultasN = teclado.nextInt();

        Paciente c = new Paciente (nomeN, convenioN, cpfN, telefoneN, diagnosticoN, consultasN);
        if (adicionaNoVetor (c)) 
        {
            System.out.println ("\fCADASTRO REALIZADO COM SUCESSO!");
        }
        else 
        {
            System.out.println ("\fERRO AO CADASTRAR!" + "\nInfelizmente o cadastro do hospital está cheio.");
        }
    }

    public void removerPaciente () 
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("\fDigite o nome do paciente para remover do cadastro: ");
        String nome = teclado.next();

        if(removeDoVetor (nome))
        {
            System.out.print("\nPACIENTE REMOVIDO COM SUCESSO!");           
        } else 
        {
            System.out.print("\nERRO NA REMOÇÃO! " + "Verifique se o paciente está cadastrado.");           
        }
    }
    
    public void imprimeVetor2 (String [] vetor)
    {//kit basico
        System.out.println("\f");
        if (index != 0) 
        {
            System.out.println("\nPacientes em ordem alfabética:");
        } else 
        {
            System.out.println("\nO vetor está vazio.");
        }
        for(int i = 0; i < index; i++)
        {            
            System.out.println (vetor[i] + "\n");
        }        
    }
    
    public String [] clone ()
    {
    String [] x = new String [10];
        for (int i = 0; i < index; i++) 
        {
         x [i] = vetor[i].getNome();
        }
    return x;
    }
    
    public void porcentagem7 () 
    {
        double []contador= {0,0,0,0,0,0};
        double contador2 = 0;
        System.out.println ("\f*** ESTATÍSTICAS ***");
        System.out.println ("\nDiganósticos registrados: ");


        for (int i = 0; i < doencas.length; i++) 
        { 
            double porcento=0;
            for (int j = 0; j < index; j++) 
            {

                if (doencas[i].equalsIgnoreCase ( vetor[j].getDiagnostico())) 
                {    
                    contador [i] ++;

                }

            }
            porcento= (contador[i] / index) * 100;
            System.out.print (doencas[i] + ": ");
            System.out.printf ("%.2f %% \n", porcento);

        }
        System.out.print ("\nPosições dos pacientes com ");
        for (int i = 0; i < doencas.length; i++) 
        { 

            int cont=0;
            for (int j = 0; j < index; j++) 
            {

                if (doencas[i].equalsIgnoreCase ( vetor[j].getDiagnostico())) 
                {    
                    if(cont==0)
                    {
                        System.out.print ("\n"+doencas[i]+": ");
                        cont++;
                    }
                    System.out.print ((j+1)+"; ");

                }

            }
        }
    }
}