package pkg.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attachments")
public class Attachments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String notes;
	private String name;
	private String path;
	public String getPath() {
		return path;
	}
	
	@ManyToOne
    private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getId() {
		return id;
	}
	
	public String getNotes(){
		return this.notes;
	}
	
	public void setNotes(String notes){
		this.notes = notes;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
