package pkg.entidade;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Esta entidade refere-se a criada pelo @JoinTable nas entidades.
@Table(name="usergroup")
public class Relacionamento {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="rel")
private int id;
@Column(name="usuario_id")
private int user = 0;
@Column(name="grupo_id")
private int group = 0;
public int getUser() {
	return user;
}
public void setUser(int user) {
	this.user = user;
}
public int getGroup() {
	return group;
}
public void setGroup(int group) {
	this.group = group;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}
