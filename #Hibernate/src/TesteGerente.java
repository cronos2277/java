import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class TesteGerente {
	//Hibernate: update alunos set alu_nome=?, alu_cidade=?, alu_fone=? where alu_codigo=?
    public static void main(String args[]){
        Gerente gerente = new Gerente();        
       List<Aluno> alunos = gerente.getAlunos();
        System.out.println(alunos);
        
        //Habilite se quiser testar salvamento.
        /* Aluno aluno = new Aluno("Luana","Pato Branco", "44545454545454545");
        gerente.saveTransaction(aluno);  
        System.out.println(gerente); */
     
        //Habilite para editar
        /* 	Aluno aluno = gerente.getAluno(1);
        	aluno.setAlu_nome("Neiri Natzke");
        	gerente.updateTransaction(aluno);
       		System.out.println(aluno);
        * */
       
        /*
        	Aluno aluno = gerente.getAluno(2);
        	gerente.deleteTransaction(aluno);
        	System.out.println(aluno);
        */
        
        System.out.println(alunos);
    }
}
