package com.varaisys.intranet.serviceImpl;

import java.io.File;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.varaisys.intranet.dao.MyInfoDao;
import com.varaisys.intranet.model.MyInfoFileupload;
import com.varaisys.intranet.utils.MyInfoUploadForm;
/**
 * 
 * @author Sachin Kashyap
 * @Created on 7-nov-2022
 * @modify on 14-nov-2022
 */
@Component
@Service
public class FileUploadHelper {
	@Autowired
	private Environment enviroment;
	@Autowired
	MyInfoDao myInfoDao;
	private boolean flag = false;

//private final String dirLoaction="/home/UM6AD02/intranateapi/intranet/uploadfile";
	public boolean uploadFile(MyInfoUploadForm form) {
		try {
			MyInfoFileupload myInfoFileupload = new MyInfoFileupload();
			String dirLoaction = enviroment.getProperty("file.upload.dir");
			System.out.println(dirLoaction);
			MultipartFile multipartFile = form.getFile();
			Files.copy(multipartFile.getInputStream(),
			Paths.get(dirLoaction + File.separator + multipartFile.getOriginalFilename()),
			StandardCopyOption.REPLACE_EXISTING);
			myInfoFileupload.setAddedBy(form.getAddedBy());
			myInfoFileupload.setDescription(form.getDescription());
			myInfoFileupload.setFileName(form.getFile().getOriginalFilename());
			myInfoFileupload.setSize(form.getFile().getSize() + "");
			myInfoFileupload.setType(form.getFile().getContentType());
			myInfoFileupload.setDateAdded(LocalDateTime.now());
//			Path path = Paths.get(dirLoaction + File.separator + multipartFile.getOriginalFilename());
//			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/getFile/"+File.separator).toUriString();
			myInfoFileupload.setUrl(dirLoaction);
			myInfoDao.saveDetails(myInfoFileupload);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<MyInfoFileupload> getAllFiles() {
	List<MyInfoFileupload> fileDetails = myInfoDao.getAllFiles();
	return fileDetails;
	}
	public Resource load(String filename) {
	    try {
	    	String dirLoaction = enviroment.getProperty("file.upload.dir");
	    	 Path root = Paths.get(dirLoaction);
	      Path file = root.resolve(filename);
	      Resource resource = new UrlResource(file.toUri());

	      if (resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	        throw new RuntimeException("Could not read the file!");
	      }
	    } catch (MalformedURLException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }
	  }
}
