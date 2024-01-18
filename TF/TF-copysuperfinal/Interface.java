/**
 * Escreva uma descrição da classe Interface aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.util.*;
public class Interface
{
    public static void main(String [] args)
    {
         Scanner teclado = new Scanner(System.in);
         CadastroPaciente p1= new CadastroPaciente (10);
         Paciente um= new Paciente ("Valdirene", "ESTRELA", p1.geradorCpf(),  "51999887710", "Zica", 2);
         Paciente dois= new Paciente ("Zeca", "ESTRELA", p1.geradorCpf(),  "51999887710", "Dengue", 2);
         Paciente tres= new Paciente ("Alcir", "Unimed", p1.geradorCpf(),  "51999887710", "Chikungunya", 2);
         Paciente quatro = new Paciente ("Jorge", "Ypê", p1.geradorCpf(),  "51999887710", "Dengue", 2);
         Paciente cinco = new Paciente ("Jurema", "Unimed", p1.geradorCpf(),  "51999887710", "Covid", 2);
         Paciente seis = new Paciente ("Sales", "Saúde Vitória", p1.geradorCpf(),  "51999887710", "Chikungunya", 2);
         Paciente sete = new Paciente ("Lucas", "IPA", p1.geradorCpf(),  "51999887710", "Varíola do macaco", 2);
         Paciente oito = new Paciente ("Fábio", "Ypê", p1.geradorCpf(),  "51999887710", "Varíola do macaco", 2);
         Paciente nove = new Paciente ("Júlia", "Help CLASS", p1.geradorCpf(),  "51999887710", "Outro", 2);
         p1.adicionaNoVetor(um);
         p1.adicionaNoVetor(dois);
         p1.adicionaNoVetor(tres);
         p1.adicionaNoVetor(quatro);
         p1.adicionaNoVetor(cinco);
         p1.adicionaNoVetor(seis);
         p1.adicionaNoVetor(sete);
         p1.adicionaNoVetor(oito);
         p1.adicionaNoVetor(nove);
         
        int opcao = 0;
        do {
            System.out.println ("\f*** Menu Principal ***");
            System.out.println ("\nDigite a opção desejada:");
            System.out.println ("\n[1] - Cadastrar novo paciente");
            System.out.println ("\n[2] - Remover paciente do cadastro");
            System.out.println ("\n[3] - Visualizar pacientes cadastrados");
            System.out.println ("\n[4] - Visualizar posição de cada paciente no cadastro");
            System.out.println ("\n[5] - Visualizar pacientes por ordem alfabética crescente" );
            System.out.println ("\n[6] - Média das consultas dos pacientes cadastrados" );
            System.out.println ("\n[7] - Porcentagem de pacientes com cada doença" );
            System.out.println ("\n[8] - Sair" );
            opcao = teclado.nextInt();

            switch (opcao) 
            {
                case 1:
                    {
                        p1.registrarPaciente (); 
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next(); 
                    }
                    break;
                case 2:
                    {
                        p1.removerPaciente ();
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next();  
                    }
                    break;

                case 3:
                    {
                        p1.imprimeVetor();
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next(); 
                    }
                    break;

                case 4:
                    {
                        p1.imprimeVetor7();
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next(); 
                    }
                    break;

                case 5:
                    {
                        String []y=new String[10];
                        p1.imprimeVetor2 (p1.ordemAlfabetica (p1.clone())); 
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next();
                    }
                    break;

                case 6:
                    {
                        p1.media2 ();
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next(); 
                    }
                    break;

                case 7:    
                    {
                        p1.porcentagem7 (); 
                        System.out.println("\nPressione qualquer tecla:");
                        teclado.next();
                    }
                    break;

                case 8://sair
                    {
                        System.out.println ("\fEncerrando o programa. Até logo!");
                        System.exit(0);
                    } 
                    break;

                default: 
                    System.out.println ("\nOPÇÃO INVÁLIDA! Pressione qualquer tecla");
                    teclado.next();
            }
        } while (opcao != 8);
    }
    }
