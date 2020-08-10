package com.encore.spring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.MultifileVO;

@Controller
public class MultifileController {
	
	@RequestMapping("multiupload.do")
	public ModelAndView multiUpload(HttpServletRequest req, MultifileVO vo) throws Exception {
		List<String> names = new ArrayList<String>();
		String root = req.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";

		//1업로드 된 파일을 받아온다.
		List<MultipartFile> flist = vo.getFile();
		
		//2업로드할 경로를 지정하고 해당경로에 파일의 복사본을 이동시킨다
		if (flist.isEmpty()!=true) {
			for (MultipartFile f: flist) {
				System.out.println("파일의 사이즈 :"+f.getSize());
				System.out.println("업로드 된 파일명 :"+f.getOriginalFilename());
				System.out.println("파일의 파라미터명 :"+f.getName());	
				String filename = f.getOriginalFilename();
				f.transferTo(new File(path+f.getOriginalFilename()));
				names.add(filename);
			}
		}
		
		
		//3업로드한 파일명(3개)이 출력되도록 결과 페이지를 지정한다 결과페이지 명은 multi_upload_result
		
		return new ModelAndView("multi_upload_result","names",names);
	}
	
	@RequestMapping("downloadfile.do")
	public ModelAndView downloadFile(HttpServletRequest req, String filename) {
		
		System.out.println(filename);
		String root = req.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		HashMap map = new HashMap();
		map.put("path",path);
		
		return new ModelAndView("downloadView",map);
	}
}
