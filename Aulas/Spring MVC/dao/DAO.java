package Spring.dao;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DAO extends JdbcDaoSupport implements Actions<Bean>{
	
	public void saveOrUpdate(Bean model) {
		this.checkTable();
		if(model.getId() == 0) {
			this.getJdbcTemplate().update("insert into tabela(name) values (?)",model.getName());
			System.out.println("Adding...");
		}else {
			this.getJdbcTemplate().update("update tabela set name = ? where id = ?",model.getName(),model.getId());
			System.out.println("Updating...");
		}		
	}

	public void delete(int id) {
		this.checkTable();
		this.getJdbcTemplate().update("delete from tabela where id = ?",id);	
		System.out.println("Deleting...");
	}

	public List<Bean> getOne(int id) {
		this.checkTable();
		return (List) this.getJdbcTemplate().queryForList("select * from tabela where id = ?",id);
	}

	@SuppressWarnings("unchecked")
	public List<Bean> getAll() {
		this.checkTable();
		return (List) this.getJdbcTemplate().queryForList("select * from tabela");		
	}
	
	private void checkTable() {
		this.getJdbcTemplate().execute(""
				+ "create table if not exists tabela (id serial primary key, name varchar(50) not null)"
				);
	}

}
