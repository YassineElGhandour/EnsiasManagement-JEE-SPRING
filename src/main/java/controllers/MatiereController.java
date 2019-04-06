package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import org.springframework.web.bind.annotation.RequestParam;

import dao.MatiereRepository;
import dao.ProfesseurRepository;
import dao.SemestreRepository;
import dao.GroupeRepository;
import entities.Professeur;
import entities.Matiere;
import entities.Semestre;
import entities.Groupe;

@Controller
public class MatiereController {
	
	@Autowired
	MatiereRepository matiereRepository;
	
	@Autowired
	ProfesseurRepository professeurRepository;
	
	@Autowired
	SemestreRepository semestreRepository;
	
	@Autowired
	GroupeRepository groupeRepository;

	@RequestMapping(value="/addmatiere" , method = RequestMethod.GET)
	public String viewMatiere(ModelMap model)
	{
		List<Semestre> semestres = semestreRepository.findAll();
		List<Professeur> professeurs = professeurRepository.findAll();
		List<Groupe> groupes = groupeRepository.findAll();
		
		model.put("professeurs", professeurs);
		model.put("semestres", semestres);
		model.put("groupes", groupes);
		return "addmatiere";
	}	
	
	@RequestMapping(value="/addmatiere" , method = RequestMethod.POST)
	public String createMatiere(ModelMap model, Matiere matiere, @RequestParam("DropBoxProf") String emailProf, @RequestParam("DropBoxSemestre") Long idSemestre,  @RequestParam("DropBoxGroupe") Long idGroupe)
	{
		List<Professeur> profs = professeurRepository.findProfesseurByEmail(emailProf);
		matiere.setProfesseurs(profs); 
		System.out.println("LOL : " + profs);
	
		List<Groupe> groupes = groupeRepository.findGroupeById(idGroupe);
		matiere.setGroupes(groupes); 

		Semestre sem = semestreRepository.findOne(idSemestre);
		matiere.setSemestre(sem); 
		
		matiereRepository.save(matiere);
		return "redirect:/addmatiere";
	}	
	
	@RequestMapping(value="/deletematiere" , method = RequestMethod.GET)
	public String viewDeletedMatiere(ModelMap model)
	{
		List<Matiere> matieres = matiereRepository.findAll();
		model.put("matieres", matieres);
		return "deletematiere";
	}	
	
	@RequestMapping(value="/deletematiere" , method = RequestMethod.POST)
	public String deleteMatiere(ModelMap model, @RequestParam("DropBoxMatiere") Long idMatiere)
	{
		matiereRepository.delete(idMatiere);
		
		return "redirect:/deletematiere";
	}
	
}
