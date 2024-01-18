/**
 * Classe Paciente, usada para representar um paciente que faz parte do cadastro de um hospital.
 *
 * @author (Lorenzo Duarte - 22103093-5)
 * @author (Gustavo W.M. Silva - 22111252-7)
 * 
 * @version (2/6/22)
 */
import java.util.*;
public class Paciente
{
    //atributos da classe
    private int consultas;
    private String nome, diagnostico, convenio, cpf, telefone;
    
    public Paciente (String nome, String convenio, String cpf, String telefone, String diagnostico, int consultas)
    {//metodo construtor
        this.nome = nome;
        this.convenio = convenio;
        this.cpf = cpf;
        this.telefone = telefone;
        this.diagnostico = diagnostico;
        this.consultas = consultas;
    }
    
    //metodos getters
    public String getNome() {return nome;}
    public String getConvenio() {return convenio;}
    public String getCpf() {return cpf;}
    public String getTelefone() {return telefone;}
    public String getDiagnostico() {return diagnostico;}
    public int getConsultas() {return consultas;}
    
    //metodos setters
    public void setNome (String nome) {this.nome = nome;}
    public void setConvenio (String convenio) {this.convenio = convenio;}
    public void setCpf (String cpf) {this.cpf = cpf;}
    public void setTelefone (String telefone) {this.telefone = telefone;}
    public void setDiagnostico (String diagnostico) {this.diagnostico = diagnostico;}
    public void setConsultas (int consultas) {this.consultas = consultas;}
    
    //toString: formatacao da saida dos dados
    public String toString () 
    {
        return "\nNome do paciente: " + nome + "\nConvênio: " + convenio + "\nCPF: " + cpf + "\nTelefone: " + telefone + "\nDiagnóstico: " + diagnostico + "\nNúmero de consultas: " + consultas + "\n";
    }
    
    public int valorConsulta (int consultas) 
    {//método que recebe o numero de consultas como parâmetro e retorna o valor total a ser pago pelas consultas do mês
        int valor = 150;
        return valor * consultas;
    }
}