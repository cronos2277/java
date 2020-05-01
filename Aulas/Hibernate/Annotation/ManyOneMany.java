import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="manyonemany")
public class ManyOneMany {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="manyonemany_id")
	public int id;
	
	@Column(name="valor")
	public String valor;
	
	
	@OneToMany(mappedBy="manyonemany",fetch=FetchType.LAZY) 
	@Cascade(value = { CascadeType.ALL })	
	public Collection<Auxiliar> list_auxilires;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="auxiliar_id",updatable=true, insertable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	public Auxiliar auxiliar;
}
