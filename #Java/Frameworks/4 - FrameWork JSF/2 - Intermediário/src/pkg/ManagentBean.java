package pkg;
import javax.faces.bean.ManagedBean; //Necessário para uso da anotação @ManagedBean
import javax.faces.bean.RequestScoped; //Necessário para uso da anotação @RequestScoped
@ManagedBean(name="beans") //Aqui é definido o nome do Bean.
@RequestScoped //Aqui é definido o tipo de escopo. No caso, ao fim da aplicação os dados são apagados. Os dados persistem, apenas durante a requisição. 
public class ManagentBean {
//Lembrando sempre que o JSF trabalha com Beans.	
private String text; //Aqui o nome da Classe privada, a ser usada nas páginas para persistencia de dados.

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}
}
