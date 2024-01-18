/**
 * Gustavo Willian Martins da Silva 
 * Verbo: ar, er , ir
 * Verbos testados: beber, ceder,lavar, cantar e nutrir;
 * 06/05/2022
 */

import java.util.*;
public class AppVerbosRegulares

 {
     
private static Scanner teclado=new Scanner(System.in);
public static void main(String[] args) 
{int escolha;
do{
        System.out.println("\f\n Digite o verbo regular que deseja conjugar");
        String verbo=teclado.next();
        
        int tam=verbo.length();//para saber quantas posições tem o objeto, no caso a palavra;
        int prefixoT=tam-2;// utilizado para tirar as ultimas duas letras do verbo regular;
        String prefixo=verbo.substring(0,prefixoT);//saber até qual letra deve ir: beb
        String prefixo4=verbo.substring(prefixoT,tam);//saber até qual letra deve ir
        
        
        VerbosRegulares v1= new VerbosRegulares();

                 System.out.println("\n Digite para conjugar no : 1-presente, 2-passado e 3-futuro");
                int opcao=teclado.nextInt();//para especificar o que o usuario deseja
                 
                if(prefixo4.startsWith("er")){ 
                    switch (opcao)
                    { case 1:{v1.presenteEr (prefixo);}break;
                    case 2:{v1.passadoEr (prefixo);}break;
                    case 3: {v1.futuroEr(prefixo);}break;
                    case 4: break;
                    default: System.out.println("opcao invalida"); 
            
                    }
            }else if(prefixo4.startsWith("ar")){   
                switch (opcao)
                { case 1:{v1.presenteAr (prefixo);}break;
                case 2:{v1.passadoAr (prefixo);}break;
                case 3: {v1.futuroAr(prefixo);}break;
                case 4: break;
                default: System.out.println("opcao invalida"); 
        
                }

                                
            }else if(prefixo4.startsWith("ir")){  
                                                       
                switch (opcao)
                { case 1:{v1.presenteIr (prefixo);}break;
                case 2:{v1.passadoIr (prefixo);}break;
                case 3: {v1.futuroIr(prefixo);}break;
                case 4: break;
                default: System.out.println("opcao invalida"); 

                }                        
            }else {System.out.println("Essa palavra não pertence aos verbos regulares");}
          
               System.out.println("\nEscolha uma opção");
                     System.out.println("1- fazer novamente");
                     System.out.println("2- sair");
                     System.out.println("\nOpção: ");
                     
                escolha =teclado.nextInt();   
     
            }while(escolha!=2);//laço para retornar quantas vezes o usuario desejar
}
 
}

                 