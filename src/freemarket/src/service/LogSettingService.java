package service;

/**
 * »’÷æ≈‰÷√
 * 
 * @author Jiandong
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