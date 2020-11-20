package controller;
import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import pojo.MultiFileDomain;
@Controller
public class MutiFilesController {
	// 得到一个用来记录日志的对象，这样打印信息时，能够标记打印的是哪个类的信息
	private static final Log logger = LogFactory.getLog(MutiFilesController.class);
	/**
	 * 多文件上传
	 */
	@RequestMapping("/multifile")
	public String multiFileUpload(@ModelAttribute MultiFileDomain multiFileDomain, HttpServletRequest request){
		String realpath = request.getServletContext().getRealPath("uploadfiles");  
		//上传到eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ch2_6/uploadfiles
		File targetDir = new File(realpath); 
		if(!targetDir.exists()){  
			targetDir.mkdirs();  
        } 
		List<MultipartFile> files = multiFileDomain.getMyfile();
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			String fileName = file.getOriginalFilename();
			File targetFile = new File(realpath,fileName);
			//上传 
	        try {  
	        	file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		}
		logger.info("成功");
		return "showMulti";
	}
}
