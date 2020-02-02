package pkg.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ref")
public class References {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String ref;
	private String notes;
	
	@ManyToOne
    private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Long getId() {
		return id;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
