package ${bean.domain}.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${bean.domain}.dao.${bean.className}Dao;
import ${bean.domain}.domain.${bean.className};

/**
 * ${bean.businessName}
 * 
 * @author ${bean.authorName}
 */
@Service
public class ${bean.className}Service {

	@Autowired
	private ${bean.className}Dao dao;
	
	public int delete(int id){
		return dao.delete(id);
	}
	
	public int add(${bean.className} bean){
		return dao.add(bean);
	}

	public int update(${bean.className} bean){
		return dao.update(bean);	
	}

	public List<${bean.className}> list(Object formParam){
		return dao.list(formParam);
	}

	public int listTotal(Object formParam){
		return dao.listTotal(formParam);
	}

	public ${bean.className} get(int id){
		return get(id);
	}
	
}