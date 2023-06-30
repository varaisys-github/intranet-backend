package com.varaisys.intranet.daoImpl;
import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.MyInfoDao;
import com.varaisys.intranet.model.MyInfoFileupload;
import com.varaisys.intranet.serviceImpl.FileUploadHelper;
import com.varaisys.intranet.utils.MyInfoUploadForm;
/**
 * 
 * @author Sachin Kashyap
 * @Created on 11-nov-2022
 * @modify on 14-nov-2022
 */
@Repository
public class MyInfoDaoImpl extends AbstractDao<Integer, MyInfoFileupload> implements MyInfoDao {
@Autowired
FileUploadHelper fileUploadHelper;
	@Override
	@Transactional
	public void saveDetails(MyInfoFileupload myInfoFileupload) {
		persist(myInfoFileupload);
		System.out.println("Details save");
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<MyInfoFileupload> getAllFiles() {
		Criteria criteria = createEntityCriteria();
		return criteria.list();
	}

	@Override
	public void load(String filename) {

	}

	@Transactional
	@Override
	public MyInfoFileupload getFileDetailById(int id) {
		return getByKey(id);
	}
	@Transactional
	@Override
	public boolean deleteId(MyInfoFileupload myInfoFileupload) {
			delete(myInfoFileupload);
			return true;
	}	
	@Transactional
	@Override
	public  MyInfoFileupload  updateDeatils(MyInfoUploadForm myInfoFileupload, Environment environment) {
		String dirLocation = environment.getProperty("file.upload.dir");
		MultipartFile multipartFile = myInfoFileupload.getFile();
       try {
		
    		Files.copy(multipartFile.getInputStream(),
    				Paths.get(dirLocation + File.separator + multipartFile.getOriginalFilename()),
    				StandardCopyOption.REPLACE_EXISTING);
	} catch (Exception e) {
		e.printStackTrace();
	}
		MyInfoFileupload fileDetails = getFileDetailById(myInfoFileupload.getId());
		fileDetails.setAddedBy(myInfoFileupload.getAddedBy());
		fileDetails.setDescription(myInfoFileupload.getDescription());
		fileDetails.setFileName(myInfoFileupload.getFile().getOriginalFilename());
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/getFile/"+File.separator).toUriString();
		fileDetails.setUrl(fileDownloadUri);
		fileDetails.setSize(myInfoFileupload.getFile().getSize()+"");
		fileDetails.setDateAdded(LocalDateTime.now());
		
		return fileDetails;
	}
}
