/**
 *Trabalho1 
 *
 * @author (Gustavo W.M. Silva - 22111252-7)
*@version (16/06/2022)
 */

 

import java.util.Scanner;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class Trabalho1
{
    private Calendar agora = Calendar.getInstance();
    private Scanner teclado=new Scanner(System.in);
    public int menu()
    {

        System.out.println ("\f\nDigite a opção desejada:");
        System.out.println ("[0] Sair");
        System.out.println ("[1] Descubra quantos dias, horas e minutos você já viveu");
        System.out.println ("[2] Descubra o dia da semana em que você nasceu");
        System.out.println ("[3] Veja quantos dias voce já vivel");

        int opção = teclado.nextInt();
        return opção;
    }  

    public void App()
    { 
        Classes v1= new Classes();

        int nascAno=ano();
        int nascDia=dia();;
        int nascMes=mes();
        v1.tempoAniver(nascAno,nascDia,nascMes);

        System.out.println ("\nAperte qualquer tecla");
        teclado.nextLine();
        teclado.nextLine();

        int opção=0;
        do
        {

            opção=menu();
            switch(opção)
            {
                case 1:
                    LocalDateTime dataAtual = LocalDateTime.now();
                    LocalDateTime dataNascimento = LocalDateTime.of(nascAno, nascMes, nascDia, v1.nascHora(), v1.nascMin());
                    v1.vivel (dataAtual,dataNascimento);
                    System.out.println("\nAperte qualquer tecla");

                    teclado.nextLine();
                    teclado.nextLine();//Não sei se o problema é no meu PC mas prescisei coloca dois porque estava passando direto
                    break;

                case 2: v1.semanaNasceu(nascDia, nascMes, nascAno);
                    teclado.nextLine();//Não sei se o problema é no meu PC mas prescisei coloca dois porque estava passando direto
                    //Na primeira vez pula direto mas posteriormente funciona normalmente

                    break;

                case 3:v1.tempoAniver(nascAno,nascDia,nascMes);
                    System.out.println ("\nAperte qualquer tecla");
                    teclado.nextLine();
                    teclado.nextLine();//Não sei se o problema é no meu PC mas prescisei coloca dois porque estava passando direto

                    break;

                default: break;        
            }
            
        }while(opção!=0);
    }   

    public int mes()
    {

        System.out.println ("\nMês:\n");
        int nascMes = teclado.nextInt();

        while (nascMes <= 0 || nascMes > 12)
        {   
            System.out.println ("\fDigite o mês:");
            //System.out.println ("\nDia: "+nascDia);
            System.out.println ("\nDigite um mês válido (entre 1 e 12):\n");
            nascMes = teclado.nextInt();
        } 
        return nascMes;
    }

    public int ano()
    {
        int anoAtual = agora.get(Calendar.YEAR);
        System.out.println ("Digite o ano em que você nasceu:\n");

        int nascAno = teclado.nextInt();

        while (nascAno < 1900 || nascAno > anoAtual)
        {    
            System.out.println("\nDigite um ano válido (entre 1900 e a data de hoje):\n");
            nascAno = teclado.nextInt();
        }
        return nascAno;
    }

    public int dia()
    {

        System.out.println ("\nAgora digite o dia e o mês:");

        System.out.println ("\nDia:\n");
        int nascDia = teclado.nextInt();

        while (nascDia > 32 || nascDia <= 0)
        {   
            System.out.println ("\fDigite o dia:");
            System.out.println ("\nDigite um dia válido (entre 1 e 31):\n");
            nascDia = teclado.nextInt();
        }
        return nascDia;
    }

}