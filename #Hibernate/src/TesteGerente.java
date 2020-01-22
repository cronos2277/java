import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class TesteGerente {
	//Hibernate: update alunos set alu_nome=?, alu_cidade=?, alu_fone=? where alu_codigo=?
    public static void main(String args[]){
        Gerente gerente = new Gerente();        
        gerente.getAlunos();
        System.out.println(gerente);
        
        //Habilite se quiser testar salvamento.
        /* Aluno aluno = new Aluno("Luana","Pato Branco", "44545454545454545");
        gerente.saveTransaction(aluno);  
        System.out.println(gerente); */
        
    }
}
