package com.varaisys.intranet.utils;

import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author Sachin kashyap
 * @created on 7-nov-20222
 *@Modify on 14-nov-2022
 */
 
public class MyInfoUploadForm {
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String fileName;
	private String type;
	private String description;
	private String size;
	private LocalDateTime dateAdded;
	private String addedBy;
	private MultipartFile file;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}
}
