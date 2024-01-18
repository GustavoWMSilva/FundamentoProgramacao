/*
 * @author (Gustavo W.M. Silva - 22111252-7)
* @version (16/06/2022)
 */
import java.util.Scanner;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class Classes
{
    private Scanner teclado=new Scanner(System.in);
    private Calendar agora = Calendar.getInstance();

    public void tempoAniver(int nascAno,int nascDia,int nascMes)
    {

        Calendar agora = Calendar.getInstance();
        int diaAtual = agora.get(Calendar.DAY_OF_MONTH);
        int mesAtual = agora.get(Calendar.MONTH) + 1;
        int diaF = nascDia - diaAtual;
        System.out.println ("\f");

        if (nascMes == mesAtual)
        {
            if (nascDia == diaAtual)//se dia e mes sao compativeis e aniversario da pessoa
            {
                System.out.println ("\nFeliz aniversário!\n");
            }
            else
            {
                if (nascDia > diaAtual)           
                { 
                    System.out.println ("\nFaltam " + diaF + " dias para o seu aniversário.\n");
                }
                else
                {
                    System.out.println ("\nSeu aniversário foi em " + nascDia + "/" + nascMes + ".\n");
                }
            }
        }
        else
        {
            if (nascMes > mesAtual)
            {
                aniver (nascDia, nascMes);  
            }
            else
            {
                System.out.println ("\nSeu aniversário foi em " + nascDia + "/" + nascMes + ".\n");
            }
        }

    }
    
    public static boolean anoBissexto (int ano) 
    {//metodo que diz se ano e bissexto ou nao
        if (ano%100 == 0)
        {
            if (ano%400 == 0)
            {
                return true;
            }//anos terminados com dois 00 que sao bissextos 
            else
            {
                return false;
            }
        }  

        if(ano%4 == 0)
        {
            return true;
        }//ano bissexto é divisivel por 4 com resto 0
        else
        {
            return false;
        }        
    }

    public int diaSemana (int nascDia, int nascMes, int nascAno)
    {//metodo que informa o dia da semana de um ano qualquer a partir de 1900
        int aux = 0;
        int a = nascAno - 1900;
        int b = a/4;
        int c = 0;
        boolean z = anoBissexto (nascAno);
        int d = nascDia - 1;
        
        if (z = true)
        {
            if (nascMes == 1 || nascMes == 2)
            {
                if (nascDia <= 31)
                {b = b -1;}
            }
        }

        if (nascMes == 1 || nascMes == 10) {c = 0;} //janeiro ou outubro
        if (nascMes == 2 || nascMes == 3 || nascMes == 11) {c = 3;} //fevereriro, março ou novembro
        if (nascMes == 4 || nascMes == 7) {c = 6;} //abril ou julho
        if (nascMes == 5) {c = 1;} //maio
        if (nascMes == 6) {c = 4;} //junho
        if (nascMes == 8) {c = 2;} //agosto
        if (nascMes == 9 || nascMes == 12) {c = 5;} //setembro ou dezembro
        //Poderia utilizar switch mas preferi utilizar if para demostrar o dominio nos dois. 

        aux = (a + b + c + d)%7;

        return aux;
    }

    public void vivel( LocalDateTime dataAtual, LocalDateTime dataNascimento)
    {  

        long diffM = ChronoUnit.MINUTES.between (dataNascimento, dataAtual);
        long diffH = ChronoUnit.HOURS.between (dataNascimento, dataAtual);
        long diffD = ChronoUnit.DAYS.between (dataNascimento, dataAtual);                       

        System.out.println (
            "\f\nDias vividos: " + diffD + 
            "\nHoras vividas: " + diffH + 
            "\nMinutos vividos: " + diffM + "\n"
        );

    }

    public void aniver (int nascDia, int nascMes) 
    {//metodo que diz quantos dias faltam para aniversario da pessoa no ano atual

        int diaAtual = agora.get(Calendar.DAY_OF_MONTH);
        int mesAtual = agora.get(Calendar.MONTH) + 1;

        int soma = 0;
        int x = nascDia - diaAtual;
        int z= diaAtual - nascDia; 
        int contador=-1;
        int aux = 0;

        do{
            contador++;
            if (nascMes > mesAtual) 
            {
                aux = soma;
                switch (mesAtual) 
                {
                    case 1: 
                    case 3: 
                    case 5:    
                    case 7:
                    case 8:
                    case 10:
                    case 12: 
                    soma = 31;
                    break;

                    case 4:
                    case 6:
                    case 9:
                    case 11:
                    soma = 30;
                    break;

                    case 2: 
                    soma = 28;
                    break;

                    default: break;    
                }
                soma = soma + aux + x;
            }
            mesAtual++; 

        } while (mesAtual != nascMes);  

        int vezes=x*contador;
        int vezes1=z*contador;

        if (x==0)
        {
            System.out.println ("\nFaltam "+soma+ " dias para o seu aniversário.\n");
        }
        else if(x>0)
        {
            System.out.println ("\nFaltam "+(soma-vezes)+ " dias para o seu aniversário.\n");

        }
        else if(x<0)
        {
            System.out.println ("\nFaltam "+(soma+vezes1)+ " dias para o seu aniversário.\n");
        }

    }



    public void semanaNasceu(int nascDia,int nascMes, int nascAno)
    {
        Classes v1= new Classes();
        int x = v1.diaSemana (nascDia, nascMes, nascAno);

        String [] diaVetor={"segunda","terça","quarta","quinta", "sexta", "sábado", "domingo"};
        for(int i=0;i<diaVetor.length; i++)
        {   

            if (x == i)
            {
                System.out.println ("\f\nO dia da semana em que você nasceu foi "+diaVetor[i]+".\n");
            }

        }
        System.out.println ("\nAperte qualquer tecla");
        teclado.nextLine();

    }

    

    public int nascHora ()
    {
        System.out.println ("\f\nDigite a hora em que você nasceu:(de 0 a 23) ");                            
        int nascHora = teclado.nextInt();

        while (nascHora > 23 || nascHora < 0 )
        {
            System.out.println ("\nDigite uma hora válida (entre 0 e 23):\n");
            nascHora = teclado.nextInt();
        }
        return nascHora;
    }

    public int nascMin ()
    {
        System.out.println ("\nDigite os Minutos:\n");
        int nascMin = teclado.nextInt();

        while (nascMin > 59 || nascMin < 0)
        {
            System.out.println ("\nDigite minutos válidos (entre 0 e 59):\n");
            nascMin = teclado.nextInt();
        }
        return nascMin;
    }

}