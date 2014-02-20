package ${bean.domain}.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${bean.domain}.dao.${bean.name}Dao;
import ${bean.domain}.domain.${bean.name};

/**
 * ${bean.comment}
 * 
 * @author ${bean.authorName}
 */
@Service
public class ${bean.name}Service {

	@Autowired
	private ${bean.name}Dao dao;
	
	public int delete(int id){
		return dao.delete(id);
	}
	
	public int add(${bean.name} bean){
		return dao.add(bean);
	}

	public int update(${bean.name} bean){
		return dao.update(bean);	
	}

	public List<${bean.name}> list(Object formParam){
		return dao.list(formParam);
	}

	public int listTotal(Object formParam){
		return dao.listTotal(formParam);
	}

	public ${bean.name} get(int id){
		return get(id);
	}
	
}