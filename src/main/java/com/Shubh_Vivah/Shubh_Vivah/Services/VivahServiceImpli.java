package com.Shubh_Vivah.Shubh_Vivah.Services;

import java.io.File;
import java.util.List;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Shubh_Vivah.Shubh_Vivah.Model.VivahModel;
import com.Shubh_Vivah.Shubh_Vivah.Repository.VivahRepository;

@Service
public class VivahServiceImpli implements VivahService{
	
	@Autowired
private VivahRepository vivahRepository;
	private final String uploadDir = "file:D:/SpringProject/Shubh_Vivah/upload/images/";
	
	@Override
	public boolean joinUser(VivahModel vivahmodel) {
		try {
			MultipartFile imgFile=vivahmodel.getProfilePhotoFile();
			if (imgFile ==null || imgFile.isEmpty()) {
					return false;
					}
		String fileName=System.currentTimeMillis() + "_" +imgFile.getOriginalFilename();
			Path uploadPath=Paths.get(uploadDir);
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			try(InputStream inputStream=imgFile.getInputStream()) {
				Files.copy(inputStream, uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
				}
			 System.out.println(">>> SAVED AT: " + uploadPath.resolve(fileName).toAbsolutePath());
			vivahmodel.setProfilePhoto(fileName);
			vivahRepository.save(vivahmodel);
			return true;
			} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
			return false;
		}}
	public List<VivahModel> searchProfiles(String gender, String religion, String country, String state, String language){
		 return vivahRepository.findAll(VivahSpecification.filterBy(gender, religion, country, state, language)
		    );
		}}
