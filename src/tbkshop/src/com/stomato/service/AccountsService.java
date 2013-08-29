package com.stomato.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stomato.dao.UserDao;
import com.stomato.domain.User;
import com.stomato.exception.DaoException;
import com.stomato.exception.ServiceException;
import com.stomato.form.UserFormParam;

@Service("accountsService")
public class AccountsService {

	@Resource
	private UserDao userDao;

	public int listTotal(UserFormParam param) throws ServiceException, DaoException, DaoException {
		return userDao.listTotal(param);
	}

	public List<User> listUser(UserFormParam param) throws ServiceException, DaoException {
		return userDao.listUser(param);
	}

	public void addUser(User user) throws ServiceException, DaoException {
		userDao.addUser(user);
	}

	public void updateUser(User user) throws ServiceException, DaoException {
		userDao.updateUser(user);
	}

	public User getUser(User user) throws ServiceException, DaoException {
		return userDao.getUser(user);
	}

	public User getUserByUid(int uid) throws ServiceException, DaoException {
		return userDao.getUserByUid(uid);
	}

	public int updatePassword(User user) throws ServiceException, DaoException {
		return userDao.updatePassword(user);
	}

	public void uploadLoginToken(User user) throws ServiceException, DaoException {
		userDao.updateLoginToken(user);
	}

	public User getUserByEmail(String email) throws ServiceException, DaoException {
		return userDao.getUserByEmail(email);
	}

	public int updateEmail(User user) throws ServiceException, DaoException {
		return userDao.updateEmail(user);
	}

	public User verify(User user) throws ServiceException, DaoException {
		return userDao.verify(user);
	}

}
