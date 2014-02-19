package com.stomato.service;

import java.util.List;

import com.stomato.dao.LogSettingDao;
import com.stomato.domain.LogSetting;

/**
 * 日志配置
 * 
 * @author Admin
 */
@Service
public class LogSettingService {

	@Autowired
	private LogSettingDao dao;
	
	public int delete(int id){
		return dao.delete(id);
	}
	
	public int add(LogSetting bean){
		return dao.add(id);
	}

	public int update(LogSetting bean){
		return dao.update(bean);	
	}

	public List<LogSetting> list(Object formParam){
		return dao.list(formParam);
	}

	public int listTotal(Object formParam){
		return dao.listTotal(formParam);
	}

	public LogSetting get(int id){
		return get(id);
	}
	
}