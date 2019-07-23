package com.hcl.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.dto.AdminResDTO;
import com.hcl.entity.Admin;

public interface AdminService {
	public AdminResDTO login(@RequestBody Admin admin);

}
