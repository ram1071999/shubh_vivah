package com.Shubh_Vivah.Shubh_Vivah.Services;

import java.util.List;

import com.Shubh_Vivah.Shubh_Vivah.Model.VivahModel;

public interface VivahService  {
	
	public boolean joinUser(VivahModel vivahmodel);
	List<VivahModel> searchProfiles(String gender, String religion, String country, String state, String language);
	

}
