package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.AdminResDTO;
import com.hcl.entity.Admin;
import com.hcl.entity.Registration;
import com.hcl.repository.AdminRepository;
import com.hcl.repository.RegistrationRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	RegistrationRepository registrationRepository;
	

	@Override
	public AdminResDTO login(Admin admin) {

		AdminResDTO adminResDTO = new AdminResDTO();
		Admin admin2 = adminRepository.findByUserId(admin.getUserId());
		Registration registration = registrationRepository.findByUserIdAndPassword(admin.getUserId(),admin.getPassword());
		//System.out.println(registration.getAccountNumber());

		if (admin2 != null) {

			if ((admin2.getUserId() == (admin.getUserId())) && (admin2.getPassword().equals(admin.getPassword()))) {
				adminResDTO.setAdminUserID(admin2.getUserId());
				adminResDTO.setAdminMessage("admin successful");

				return adminResDTO;
			} 
		} if (registration != null) {
	

				if ((registration.getUserId() == (registration.getUserId()))
						&& (registration.getPassword().equals(registration.getPassword())))

				{
					adminResDTO.setAdminUserID(registration.getUserId());
					adminResDTO.setAdminMessage("user Successfull");
					return adminResDTO;
				} 
			}else {
				adminResDTO.setAdminMessage("login failed");
				return adminResDTO;
			}
		
		
		return adminResDTO;

	}

	/*s*/
}
