package com.encore.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.UploadDataVO;

@Controller
public class FileController {
	
	@RequestMapping("fileupload.do")
	public ModelAndView fileUpload(HttpServletRequest req, UploadDataVO vo) throws IllegalStateException, IOException {
		
		//1.vo에서 MultipartFile을 받아온다.
		MultipartFile mfile= vo.getUploadFile();
		System.out.println("MultipartFile: "+mfile);
		
		/*
		 * 업로드 된 파일이 있다면?
		 * -> 파일의 사이즈, 업로드한 파일의 이름, 업로드한 파일의 파라미터명을 가져올 수 있음
		 * -> 궁극적 목표 서버에 올리고, DB에 넣고 싶음
		 *  업로드 된 파일이 없다면?
		 */
		
		if(mfile.isEmpty()!= true) {
			System.out.println("파일의 사이즈 :"+mfile.getSize());
			System.out.println("업로드 된 파일명 :"+mfile.getOriginalFilename());
			System.out.println("파일의 파라미터명 :"+mfile.getName());	
		}
		String root = req.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\"; 

		//File은 디렉토리+파일명을 지칭
		File copyFile = new File(path+mfile.getOriginalFilename());
		//원래 업로드한 파일이, 지정한 path 위치로 이동 이때 카피본이 이동
		mfile.transferTo(copyFile);
		System.out.println("path: "+path+mfile.getOriginalFilename());
		return new ModelAndView("upload_result","uploadfile",mfile.getOriginalFilename());
	}
	
	@RequestMapping("filedown.do")
	public ModelAndView downloadImg(HttpServletRequest req, String filename) throws IOException {
		System.out.println(filename);
		
		String root = req.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		
		HashMap map = new HashMap();
		map.put("path",path); //특정한 경로에 upload한 파일을 다운로드할것.
		
		return new ModelAndView("downloadView",map);
	}
}
