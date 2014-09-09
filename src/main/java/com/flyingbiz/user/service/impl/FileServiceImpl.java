package com.flyingbiz.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyingbiz.user.dao.FileServiceDao;
import com.flyingbiz.user.entity.FileInfo;
import com.flyingbiz.user.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileServiceDao fileServiceDao;

	@Override
	public void modifyFileInfo(FileInfo fileInfo) {
		fileServiceDao.modifyFileInfo(fileInfo);
	}

	@Override
	public void saveFileInfo(FileInfo fileInfo) {
		fileServiceDao.saveFileInfo(fileInfo);
	}

}
