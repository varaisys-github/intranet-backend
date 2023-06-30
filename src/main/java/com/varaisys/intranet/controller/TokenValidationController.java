package com.varaisys.intranet.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.varaisys.intranet.model.UserInfo;
import com.varaisys.intranet.service.TokenValidationService;
import com.varaisys.intranet.service.UserService;
import com.varaisys.intranet.utils.TokenData;
/**
 * @Author Babli Singh
 * @CreationDate - 13-02-2023
 * @ModifyDate - 13-02-2023
 * @Desc
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class TokenValidationController {
	@Autowired
	TokenValidationService tokenValidationService;
	@Autowired
	UserService userService;
	@PostMapping("/tokenValidation")
	public ResponseEntity<?> tokenValidate(@RequestBody TokenData tokenData) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserInfo userInfoData = tokenValidationService.findByToken(tokenData.getToken());
			if (tokenValidationService.findByToken(tokenData.getToken()) != null) {
				System.out.println("here is the role " + tokenData.getToken());
				System.out.println(tokenData.getToken() + "=====" + userInfoData.getToken());
				if (userInfoData.getToken().equals(tokenData.getToken())) {
					map.put("token", "token matched");
					return ResponseEntity.ok().body(map);
				}
			
				
			}
			map.put("token", "token does not  matched");
			return ResponseEntity.badRequest().body(map);
			
		} catch (Exception e) {
			map.put("MESSAGE", "Token does not match");
			return ResponseEntity.badRequest().body(map);
		}
	}
//	@RequestMapping(value = "/change-password", method = RequestMethod.PUT)
	@PutMapping("/change-password")
	public ResponseEntity<?> updateDetails(@RequestBody TokenData tokenData) {
		Map<String, Object> map = new HashMap<>();
		try {
			if (tokenValidationService.findByToken(tokenData.getToken()) != null) {
				if (tokenData != null) {
					boolean f = userService.updateUserPassword(tokenData);
					if (f) {
						map.put("message", "User Updated Successfully");
					}
				}
			}
			return ResponseEntity.ok().body(map);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("MESSAGE", "Token does not match");
			return ResponseEntity.badRequest().body(map);
		}
	}
}