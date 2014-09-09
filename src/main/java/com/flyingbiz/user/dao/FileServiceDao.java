package com.flyingbiz.user.dao;

import com.flyingbiz.user.entity.FileInfo;

public interface FileServiceDao {
	public void modifyFileInfo(FileInfo fileInfo);

	public void saveFileInfo(FileInfo fileInfo);
}
