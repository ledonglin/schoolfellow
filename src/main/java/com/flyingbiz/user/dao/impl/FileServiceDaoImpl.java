package com.flyingbiz.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.flyingbiz.user.dao.BaseHibernateDAO;
import com.flyingbiz.user.dao.FileServiceDao;
import com.flyingbiz.user.entity.FileInfo;

@Repository
public class FileServiceDaoImpl extends BaseHibernateDAO implements
		FileServiceDao {

	@Override
	public void modifyFileInfo(FileInfo fileInfo) {
		getSession().saveOrUpdate(fileInfo);
	}

	@Override
	public void saveFileInfo(FileInfo fileInfo) {
		getSession().save(fileInfo);
	}

}
