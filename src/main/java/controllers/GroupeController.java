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
import entities.Groupe;

@Controller
public class GroupeController {
	
	@Autowired
	GroupeRepository groupeRepository;
	
	@Autowired
	FiliereRepository filiereRepository;
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value="/addgroup" , method = RequestMethod.GET)
	public String viewGroup(ModelMap model)
	{
		List<Filiere> filieres = filiereRepository.findAll();
		model.put("filieres", filieres);
		return "addgroup";
	}	
	
	@RequestMapping(value="/addgroup" , method = RequestMethod.POST)
	public String createGroup(ModelMap model, Groupe groupe,@RequestParam("DropBoxFiliere") Long idFiliere)
	{

		Filiere fil = filiereRepository.findOne(idFiliere);
		groupe.setFiliere(fil);
		groupeRepository.save(groupe);
		return "redirect:/addgroup";
	}	
	
	@RequestMapping(value="/deletegroup" , method = RequestMethod.GET)
	public String viewDeletedGroupe(ModelMap model)
	{
		List<Groupe> groupes = groupeRepository.findAll();
		model.put("groupes", groupes);
		return "deletegroup";
	}	
	
	@RequestMapping(value="/deletegroup" , method = RequestMethod.POST)
	public String deleteGroupe(ModelMap model, @RequestParam("DropBoxGroup") Long idGroupe)
	{
		groupeRepository.delete(idGroupe);
		
		return "redirect:/deletegroup";
	}
	
}
