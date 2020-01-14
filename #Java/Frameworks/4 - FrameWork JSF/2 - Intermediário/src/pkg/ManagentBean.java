package pkg;
import javax.faces.bean.ManagedBean; //Necess�rio para uso da anota��o @ManagedBean
import javax.faces.bean.RequestScoped; //Necess�rio para uso da anota��o @RequestScoped
@ManagedBean(name="beans") //Aqui � definido o nome do Bean.
@RequestScoped //Aqui � definido o tipo de escopo. No caso, ao fim da aplica��o os dados s�o apagados. Os dados persistem, apenas durante a requisi��o. 
public class ManagentBean {
//Lembrando sempre que o JSF trabalha com Beans.	
private String text; //Aqui o nome da Classe privada, a ser usada nas p�ginas para persistencia de dados.

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}
}
