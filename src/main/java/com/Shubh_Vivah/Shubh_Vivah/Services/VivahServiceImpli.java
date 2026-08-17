package com.Shubh_Vivah.Shubh_Vivah.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Shubh_Vivah.Shubh_Vivah.Model.VivahModel;
import com.Shubh_Vivah.Shubh_Vivah.Repository.VivahRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class VivahServiceImpli implements VivahService {

    @Autowired
    private VivahRepository vivahRepository;

    @Value("${cloudinary.cloud-name}")
    private String cloudName;

    @Value("${cloudinary.api-key}")
    private String apiKey;

    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    @Override
    public boolean joinUser(VivahModel vivahmodel) {
        try {
            MultipartFile imgFile = vivahmodel.getProfilePhotoFile();
            if (imgFile == null || imgFile.isEmpty()) {
                return false;
            }

            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", cloudName,
                    "api_key", apiKey,
                    "api_secret", apiSecret,
                    "secure", true
            ));

            Map uploadResult = cloudinary.uploader().upload(imgFile.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = uploadResult.get("secure_url").toString();

            System.out.println(">>> UPLOADED TO CLOUDINARY: " + imageUrl);
            vivahmodel.setProfilePhoto(imageUrl);
            vivahRepository.save(vivahmodel);
            return true;
        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage());
            return false;
        }
    }

    public List<VivahModel> searchProfiles(String gender, String religion, String country, String state, String language) {
        return vivahRepository.findAll(VivahSpecification.filterBy(gender, religion, country, state, language));
    }
}
