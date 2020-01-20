

public class Aluno {   
    private int alu_codigo;
    private String alu_nome;
    private String alu_cidade;
    private String alu_fone;    
    public Aluno(){
        
    } 
    
    
    public Aluno(String alu_nome, String alu_cidade, String alu_fone){        
        this.alu_nome = alu_nome;
        this.alu_cidade = alu_cidade;
        this.alu_fone = alu_fone;
    }
    public int getAlu_codigo() {
        return alu_codigo;
    }

    public void setAlu_codigo(int alu_codigo) {
        this.alu_codigo = alu_codigo;        
    }

    public String getAlu_nome() {
        return alu_nome;
    }

    public void setAlu_nome(String alu_nome) {
        this.alu_nome = alu_nome;
    }

    public String getAlu_cidade() {
        return alu_cidade;
    }

    public void setAlu_cidade(String alu_cidade) {
        this.alu_cidade = alu_cidade;
    }

    public String getAlu_fone() {
        return alu_fone;
    }
    
    @Override
    public String toString() {
    	
    	return "Codigo: "+this.alu_codigo+", Nome: "+this.alu_nome;
    }

    public void setAlu_fone(String alu_fone) {
        this.alu_fone = alu_fone;
    }  
    
    
}
