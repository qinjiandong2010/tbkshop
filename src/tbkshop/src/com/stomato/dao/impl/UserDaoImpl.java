package com.stomato.dao.impl;

import java.util.List;

import com.stomato.dao.UserDao;
import com.stomato.domain.User;
import com.stomato.exception.DaoException;
import com.stomato.form.UserFormParam;

public class UserDaoImpl extends BaseDAOImpl implements UserDao {

	@Override
	public User getUser(User user) throws DaoException {
		return queryForEntity("com.stomato.dao.UserDao.getUser", User.class, user);
	}

	@Override
	public User getUserByUid(int uid) throws DaoException {
		return queryForEntity("com.stomato.dao.UserDao.getUserByUid", User.class, uid);
	}

	@Override
	public int updateUser(User user) throws DaoException {
		return update("com.stomato.dao.UserDao.updateUser", user);
	}

	@Override
	public int addUser(User user) throws DaoException {
		return insert("com.stomato.dao.UserDao.updateUser", user);
	}

	@Override
	public int updatePassword(User user) throws DaoException {
		return update("com.stomato.dao.UserDao.updatePassword", user);
	}

	@Override
	public int updateLoginToken(User user) throws DaoException {
		return update("com.stomato.dao.UserDao.updateLoginToken", user);
	}

	@Override
	public User getUserByEmail(String email) throws DaoException {
		return queryForEntity("com.stomato.dao.UserDao.getUserByEmail", User.class, email);
	}

	@Override
	public int updateEmail(User user) throws DaoException {
		return update("com.stomato.dao.UserDao.updateEmail", user);
	}

	@Override
	public User verify(User user) throws DaoException {
		return queryForEntity("com.stomato.dao.UserDao.verify", User.class, user);
	}

	@Override
	public int listTotal(UserFormParam param) throws DaoException {
		return queryForEntity("com.stomato.dao.UserDao.listTotal", Integer.class, param);
	}

	@Override
	public List<User> listUser(UserFormParam param) throws DaoException {
		return queryForListEntity("com.stomato.dao.UserDao.listUser", User.class, param);
	}
}
