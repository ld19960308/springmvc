package annotation.upload;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/upload")
public class UploadController {
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest request,
			              @RequestParam("description")String des,
			              @RequestParam("file")MultipartFile file)throws Exception{
		//System.out.println(request.getAttribute("description")==null?"null":request.getAttribute("description"));
		System.out.println(des);
		if(!file.isEmpty()){
			String path=request.getServletContext().getRealPath("/images/");
			System.out.println("path:"+path);
			String filename=file.getOriginalFilename();
			System.out.println("filename:"+filename);
			File filepath=new File(path,filename);
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			file.transferTo(new File(path+File.separator+filename));
			System.out.println("È«Â·¾¶:"+path+File.separatorChar+filename);
			return "upload/upload_success";
		}
		return "upload/uploadForm";
	}
	@RequestMapping(value="/uploadByObject",method=RequestMethod.POST)
	public String upload(HttpServletRequest request,@ModelAttribute User user,Model model)throws Exception{
		System.out.println(user.getName());
		if(!user.getFile().isEmpty()){
			String path=request.getServletContext().getRealPath("/images/");
			String filename=user.getFile().getOriginalFilename();
			System.out.println(filename);
			File file=new File(path,filename);
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			user.getFile().transferTo(new File(path+File.separatorChar+filename));
			model.addAttribute("user",user);
			return "upload/userInfo";
		}
		return "upload/uploadByObject";
	}
	@RequestMapping(value="/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
			                                @RequestParam("filename")String filename,
			                                Model model)throws Exception{
		String path=request.getServletContext().getRealPath("/images/");
		File file=new File(path+File.separatorChar+filename);
		HttpHeaders headers=new HttpHeaders();
		String downloadFilename=new String(filename.getBytes("UTF-8"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", downloadFilename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}

}
