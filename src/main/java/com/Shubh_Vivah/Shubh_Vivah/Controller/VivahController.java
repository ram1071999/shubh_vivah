package com.Shubh_Vivah.Shubh_Vivah.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.Shubh_Vivah.Shubh_Vivah.Model.User;
import com.Shubh_Vivah.Shubh_Vivah.Model.VivahModel;
import com.Shubh_Vivah.Shubh_Vivah.Services.VivahService;
@Controller
public class VivahController {
	@GetMapping("/wedding")
	public String ShowIndex() {
				return "index";}
		@Autowired
	private VivahService vivahService;
	@GetMapping("/JoinWedding")
	public String CreateJoinpage(Model model) {
				model.addAttribute("join", new VivahModel());
				return "Join";	}
	@PostMapping("/join")
	public String SubmitJoinWedding(@ModelAttribute("join") VivahModel vivahModel,RedirectAttributes redirectAttributes) {
		boolean status=vivahService.joinUser(vivahModel);
		if (status) {
	        redirectAttributes.addFlashAttribute("successMsg", "User Join Wedding Successfully");
	    } else {
	        redirectAttributes.addFlashAttribute("errorMsg", "User Not Join Wedding due to some error");
	    }
		return "redirect:/JoinWedding";	}
	@GetMapping("/search")
	public String searchProfiles(
	        @RequestParam(required = false) String gender,
	        @RequestParam(required = false) String religion,
	        @RequestParam(required = false) String country,
	        @RequestParam(required = false) String state,
	        @RequestParam(required = false) String language,
	        Model model) {
		    List<VivahModel> results = vivahService.searchProfiles(gender, religion, country, state, language);
	    model.addAttribute("results", results);
	    return "search-results";}   
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
	
	@GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    // Handle form submission
    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                              BindingResult result,
                              @RequestParam("confirmPassword") String confirmPassword,
                              Model model) {

        // Bean validation errors (blank fields, bad email/phone format, etc.)
        if (result.hasErrors()) {
            return "registration";
        }

        // Password match check
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("errorMessage", "Password and Confirm Password do not match.");
            return "registration";
        }

        // Duplicate email check
        if (userRepository.existsByEmail(user.getEmail())) {
            model.addAttribute("errorMessage", "This email is already registered.");
            return "registration";
        }

        // Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        model.addAttribute("fullName", user.getFullName());
        return "success";
    }
	

		 
}
