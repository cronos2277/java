package Spring.dao;

import java.util.List;

public interface Actions<Model> {
	void saveOrUpdate(Model model);
	void delete(int id);
	List<Model> getOne(int id);
	List<Model> getAll();
}
