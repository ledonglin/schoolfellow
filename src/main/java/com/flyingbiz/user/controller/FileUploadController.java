package com.flyingbiz.user.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.flyingbiz.user.entity.FileInfo;
import com.flyingbiz.user.entity.HoldType;
import com.flyingbiz.user.service.FileService;

@Controller
public class FileUploadController extends BaseController {

	@Autowired
	private FileService fileService;

	@RequestMapping("/preFileUploadCommand")
	public ModelAndView preFileUploadCommand(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("fileInfo", new FileInfo());
		mv.setViewName("uploadFile");
		return mv;
	}
	
	@RequestMapping(value="/preFileUpload", method=RequestMethod.POST)
	public ModelAndView preFileUPload(HttpServletRequest req, FileInfo fileInfo) {
		ModelAndView mv = new ModelAndView();
		// check file info
		fileInfo.setFileId(UUID.randomUUID().toString());
		fileInfo.setUploadTime(new Timestamp(System.currentTimeMillis()));
		fileInfo.setUploadUserId(getSessionUser(req).getUserId());

		fileService.saveFileInfo(fileInfo);
		mv.addObject("fileInfo", fileInfo);
		mv.setViewName("success");
		return mv;
	}

	@RequestMapping("/fileUpload")
	public ModelAndView fileUpload(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "icon", required = false) MultipartFile[] uploadFile)
			throws IOException, ServletException {

		ModelAndView mv = new ModelAndView();
		if (uploadFile.length > 0) {
			for (MultipartFile mFile : uploadFile) {
				FileInfo finfo = new FileInfo();
				// mFile.transferTo(finfo);

			}
		}
		return mv;

	}
}
