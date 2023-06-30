package com.varaisys.intranet.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.varaisys.intranet.dao.MyInfoDao;
import com.varaisys.intranet.model.MyInfoFileupload;
import com.varaisys.intranet.serviceImpl.FileUploadHelper;
import com.varaisys.intranet.utils.MyInfoUploadForm;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;

/**
 * 
 * @author Sachin Kashyap
 * @Created on 11-nov-2022
 * @modify on 14-nov-2022
 */
@RestController
// @CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600, exposedHeaders = {
		"CONTENT_DISPOSITION" })
@RequestMapping("/api")
public class MyInfoController {
	@Autowired
	private FileUploadHelper fileUploadHelper;
	@Autowired
	MyInfoDao myInfoDao;
	@Autowired
	Environment environment;

	/**
	 * 
	 * @param form
	 * @param result
	 * @return
	 * @Created on 11-nov-2022
	 * @modify on 14-nov-2022
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ResponseEntity<?> upload(@ModelAttribute("form") MyInfoUploadForm form, BindingResult result) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (form.getFile().isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must Contain File");
			}
			if (!form.getFile().getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File must have in jpeg formate");
			}
			boolean f = fileUploadHelper.uploadFile(form);
			if (f) {
				map.put("Success", "File upload");
				return ResponseEntity.ok().body(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Try Again Something Wrong");
	}

	/**
	 * 
	 * @return all files
	 * @Created on 11-nov-2022
	 * @modify on 14-nov-2022
	 */
	@RequestMapping(value = "/getAllFile", method = RequestMethod.GET)
	public ResponseEntity<?> getFiles() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MyInfoFileupload> allFiles = fileUploadHelper.getAllFiles();
		System.out.println("controller");
		if (allFiles != null) {
			map.put("STATUS", "Sucsess");
			map.put("MESSAGE", "All Files Details");
			map.put("Files", allFiles);
		} else {
			map.put("STATUS", "Fialed");
			map.put("MESSAGE", "File Could not be loaded.");
		}
		return ResponseEntity.ok().body(map);
	}

	/**
	 * 
	 * @param id
	 * @param response
	 * @return
	 * @Created on 11-nov-2022
	 * @modify on 14-nov-2022
	 */
	@RequestMapping(value = "/viewImage/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> viewImage(@PathVariable int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MyInfoFileupload imageDetails = myInfoDao.getFileDetailById(id);
			if (imageDetails == null) {
				map.put("MESSAGE", "File not available ");
			} else {
				map.put("MESSAGE", "All File Details");
				map.put("File Details", imageDetails);
			}
		} catch (Exception e) {

		}
		return ResponseEntity.ok().body(map);
	}

	/**
	 * 
	 * @param id
	 * @param response
	 * @Created on 11-nov-2022
	 * @modify on 14-nov-2022
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String location = environment.getProperty("file.upload.dir");
			MyInfoFileupload imageDetails = myInfoDao.getFileDetailById(id);
			if (imageDetails == null) {
				map.put("Massage", "id not found");
				return ResponseEntity.ok().body(map);
			}
			Path fileToDeletePath = Paths.get(location + File.separator + imageDetails.getFileName());
			if (!Files.exists(fileToDeletePath)) {
				map.put("Massage", "File not found");
				return ResponseEntity.ok().body(map);
			} else {
				Files.delete(fileToDeletePath);
				map.put("massage", "file deleted");
			}
			if (myInfoDao.deleteId(imageDetails)) {
				map.put("Success", "file details deleted with id" + id);
				return ResponseEntity.ok().body(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(map);

	}

	/**
	 * @Created on 11-nov-2022
	 * @modify on 14-nov-2022
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/updateFile", method = RequestMethod.POST)
	public ResponseEntity<?> updateFile(@ModelAttribute("form") MyInfoUploadForm form) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MyInfoFileupload imageDetails = myInfoDao.getFileDetailById(form.getId());
			String location = environment.getProperty("file.upload.dir");
			Path fileToDeletePath = Paths.get(location + File.separator + imageDetails.getFileName());
			if (fileToDeletePath == null) {
				map.put("Massage", "file not found");
			}
			Files.delete(fileToDeletePath);
			MyInfoFileupload updatedDetails = myInfoDao.updateDeatils(form, environment);
			if (updatedDetails != null) {
				map.put("Updated Details", updatedDetails);
			}

		} catch (Exception e) {

		}

		return ResponseEntity.ok().body(map);

	}

	/**
	 * @Created on 11-nov-2022
	 * @modify on 14-nov-2022
	 * @param form
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getFile/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getFile(@PathVariable int id, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MyInfoFileupload imageDetails = myInfoDao.getFileDetailById(id);
			if (imageDetails == null) {
				map.put("status", "error");
				map.put("message", "please provide id");
			} else {

				if (imageDetails != null) {
					String location = environment.getProperty("file.upload.dir");
					Path path = Paths.get(location + File.separator + imageDetails.getFileName());
					Resource resource = null;
					resource = new UrlResource(path.toUri());
					System.out.println(resource);
					String contentType = null;
					try {
						contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
					} catch (IOException ex) {
						System.out.println("error");
					}
					InputStream inputStream = resource.getInputStream();
					byte[] dataAsBytes = FileCopyUtils.copyToByteArray(inputStream);
					map.put("image", dataAsBytes);
					if (contentType == null) {
						contentType = "image/jpeg";
					}
					return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
							.header(HttpHeaders.CONTENT_DISPOSITION,
									"attachment; fileName=\"" + resource.getFilename() + "\"")
							.body(dataAsBytes);
				}
			}

		} catch (Exception e) {
			map.put("Status", "failed");
			map.put("MESSAGE", "Something went wrong");
			return ResponseEntity.ok().body(map);
		}

		return ResponseEntity.badRequest().body(map);
	}

}
