package com.stomato.dao;

import java.util.List;

import com.stomato.domain.User;
import com.stomato.exception.DaoException;
import com.stomato.form.UserFormParam;

public interface UserDao{
	User getUser(User user) throws DaoException;

	User getUserByUid(int uid) throws DaoException;

	int updateUser(User user) throws DaoException;

	int addUser(User user) throws DaoException;

	int updatePassword(User user) throws DaoException;

	int updateLoginToken(User user) throws DaoException;

	User getUserByEmail(String email) throws DaoException;

	int updateEmail(User user) throws DaoException;

	User verify(User user) throws DaoException;

	int listTotal(UserFormParam param) throws DaoException;

	List<User> listUser(UserFormParam param) throws DaoException;
}
