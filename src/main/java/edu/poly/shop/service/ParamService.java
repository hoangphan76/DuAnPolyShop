package edu.poly.shop.service;

import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ParamService {
	@Autowired
	HttpServletRequest request;

/**
* Đọc chuỗi giá trị của tham số
* @param name tên tham số
* @param defaultValue giá trị mặc định
* @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
*/
public String getString(String name, String defaultValue){
	var value = request.getParameter(name);
	
	if(value == null) {
		return defaultValue;
	}
	return value;
}

/**
* Đọc số nguyên giá trị của tham số
* @param name tên tham số
* @param defaultValue giá trị mặc định
* @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
* */
public int getInt(String name, int defaultValue){
	var value = request.getParameter(name);
	
	if(value == null) {
		return defaultValue;
	}
	return Integer.parseInt(value);	
}

/**
* Đọc số thực giá trị của tham số
* @param name tên tham số
* @param defaultValue giá trị mặc định
* @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
*/
public double getDouble(String name, double defaultValue){
	var value = request.getParameter(name);
	
	if(value == null) {
		return defaultValue;
	}
	return Double.parseDouble(value);	
}

/**
* Đọc giá trị boolean của tham số
* @param name tên tham số
* @param defaultValue giá trị mặc định
* @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
*/
public boolean getBoolean(String name, boolean defaultValue){
	var value = request.getParameter(name);
	
	if(value == null) {
		return defaultValue;
	}
	return Boolean.parseBoolean(value) ;	
}

/**
* Đọc giá trị thời gian của tham số
* @param name tên tham số
* @param pattern là định dạng thời gian
* @return giá trị tham số hoặc null nếu không tồn tại
 * @throws ParseException 
* @throws RuntimeException lỗi sai định dạng
*/
public Date getDate(String name,Date defaultValue) throws ParseException {
	var value = request.getParameter(name);
	
	if(value == null) {
		return defaultValue;
	}
	SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
	
	return (Date) sdf.parse(value);
}

/**
* Lưu file upload vào thư mục
* @param file chứa file upload từ client
* @param path đường dẫn tính từ webroot
* @return đối tượng chứa file đã lưu hoặc null nếu không có file upload
 * @throws Exception 
* @throws RuntimeException lỗi lưu file
*/
public File save(MultipartFile file, String path) throws Exception {
	try {
		File saveFile = new File(request.getRealPath(path)+"/"+ file.getOriginalFilename());
		
		file.transferTo(saveFile);
		return saveFile;
	} catch (Exception e) {
		throw e;
		// TODO: handle exception
	}
}
}
