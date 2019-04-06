package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.ProfesseurRepository;
import entities.Professeur;

@Controller
public class ProfesseurController {
	
	@Autowired
	ProfesseurRepository professeurRepository;
	
	@RequestMapping(value="/signup" , method = RequestMethod.GET)
	public String viewSignup()
	{
		return "signup";
	}

	@RequestMapping(value="/signup" , method = RequestMethod.POST)
	public String createProfesseur(ModelMap model, Professeur professeur)
	{
		professeur.setRole("ROLE_PROF");
		professeurRepository.save(professeur);
		
		return "redirect:/login";
	}
	
	
	
}
