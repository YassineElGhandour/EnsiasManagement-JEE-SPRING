package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.GroupeRepository;
import dao.FiliereRepository;
import dao.UserRepository;
import entities.Filiere;

@Controller
public class FiliereController {
	
	@Autowired
	GroupeRepository groupeRepository;
	
	@Autowired
	FiliereRepository filiereRepository;
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value="/addfiliere" , method = RequestMethod.GET)
	public String viewFiliere(ModelMap model)
	{
		List<Filiere> filieres = filiereRepository.findAll();
		model.put("filieres", filieres);
		return "addfiliere";
	}	
	
	@RequestMapping(value="/addfiliere" , method = RequestMethod.POST)
	public String createFiliere(ModelMap model, Filiere filiere)
	{
		filiereRepository.save(filiere);
		return "redirect:/addfiliere";
	}	
	
	@RequestMapping(value="/deletefiliere" , method = RequestMethod.GET)
	public String viewDeleteFiliere(ModelMap model)
	{
		List<Filiere> filieres = filiereRepository.findAll();
		model.put("filieres", filieres);
		return "deletefiliere";
	}	
	
	
	@RequestMapping(value="/deletefiliere" , method = RequestMethod.POST)
	public String deleteFiliere(ModelMap model, @RequestParam("DropBoxFiliere") Long idFiliere)
	{
		filiereRepository.delete(idFiliere);
		
		return "redirect:/deletefiliere";
	}	
	
}
