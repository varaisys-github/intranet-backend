package com.varaisys.intranet.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import com.varaisys.intranet.model.MyInfoFileupload;
import com.varaisys.intranet.utils.MyInfoUploadForm;
/**
 * 
 * @author Sachin Kashyap 
 * @created on 11-nov-2022
 * @modify on 14-nov-2022
 */
public interface MyInfoDao  {
public void saveDetails(MyInfoFileupload myInfoFileupload);
public List<MyInfoFileupload> getAllFiles();
public void load(String filename);
public MyInfoFileupload getFileDetailById(int id);
public boolean deleteId(MyInfoFileupload myInfoFileupload);
public MyInfoFileupload updateDeatils(MyInfoUploadForm form, Environment environment);
}
