package controllers;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DisponibiliteRepository;
import entities.Disponibilite;
import dao.ProfesseurRepository;
import entities.Professeur;

@Controller
public class DisponibiliteController 
{
	@Autowired
	DisponibiliteRepository disponibiliteRepository;
	
	@Autowired
	ProfesseurRepository professeurRepository;
	
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String dispoMethod(ModelMap model)
	{
		return "home";
	}
	
	@RequestMapping(value="/home",method = RequestMethod.POST)
	public String dispoMethodPost(ModelMap model, Disponibilite disponibilite,  HttpServletRequest request)
	{
		String username = request.getRemoteUser();
		
		Professeur professeur = professeurRepository.findOneProfesseurByUsername(username);
		
		disponibilite.setProfesseur(professeur);
		disponibiliteRepository.save(disponibilite);		
		return "redirect:/home";
	}
	
	
	/*-------------------------------------------------------*/
	

	@RequestMapping(value="/disponibilite" , method = RequestMethod.GET)
	public String viewDisponibilite(ModelMap model)
	{		
		return "disponibilite";
	}
	
	@RequestMapping(value="/disponibilite" , method = RequestMethod.POST)
	public String chooseEmploiTempsPerGroupe(ModelMap model, @RequestParam(value="DropBoxSemaine", required =false) String nomSemaine)
	{	
		String[] days = {"Lundi", "Mardi", "Mercredi","Jeudi","Vendredi"};
		String[] periodes = {"8h-10h", "10h-12h", "14h-16h", "16h-18h"};
		
		//Okay?
		//Lundi

		List<Disponibilite> emploiTempsLundiPerOne = disponibiliteRepository.findDisponibiliteBySemaine(periodes[0], days[0], nomSemaine);
		List<Disponibilite> emploiTempsLundiPerTwo = disponibiliteRepository.findDisponibiliteBySemaine(periodes[1], days[0], nomSemaine);
		List<Disponibilite> emploiTempsLundiPerThree = disponibiliteRepository.findDisponibiliteBySemaine(periodes[2], days[0], nomSemaine);
		List<Disponibilite> emploiTempsLundiPerFour = disponibiliteRepository.findDisponibiliteBySemaine(periodes[3], days[0], nomSemaine);

		//Mardi
		List<Disponibilite> emploiTempsMardiPerOne = disponibiliteRepository.findDisponibiliteBySemaine(periodes[0], days[1], nomSemaine);
		List<Disponibilite> emploiTempsMardiPerTwo = disponibiliteRepository.findDisponibiliteBySemaine(periodes[1], days[1], nomSemaine);
		List<Disponibilite> emploiTempsMardiPerThree = disponibiliteRepository.findDisponibiliteBySemaine(periodes[2], days[1], nomSemaine);
		List<Disponibilite> emploiTempsMardiPerFour = disponibiliteRepository.findDisponibiliteBySemaine(periodes[3], days[1], nomSemaine);

		
		//Mercredi 
		List<Disponibilite> emploiTempsMercrediPerOne = disponibiliteRepository.findDisponibiliteBySemaine(periodes[0], days[2], nomSemaine);
		List<Disponibilite> emploiTempsMercrediPerTwo = disponibiliteRepository.findDisponibiliteBySemaine(periodes[1], days[2], nomSemaine);
		List<Disponibilite> emploiTempsMercrediPerThree = disponibiliteRepository.findDisponibiliteBySemaine(periodes[2], days[2], nomSemaine);
		List<Disponibilite> emploiTempsMercrediPerFour = disponibiliteRepository.findDisponibiliteBySemaine(periodes[3], days[2], nomSemaine);

		//Jeudi
		List<Disponibilite> emploiTempsJeudiPerOne = disponibiliteRepository.findDisponibiliteBySemaine(periodes[0], days[3], nomSemaine);
		List<Disponibilite> emploiTempsJeudiPerTwo = disponibiliteRepository.findDisponibiliteBySemaine(periodes[1], days[3], nomSemaine);
		List<Disponibilite> emploiTempsJeudiPerThree = disponibiliteRepository.findDisponibiliteBySemaine(periodes[2], days[3], nomSemaine);
		List<Disponibilite> emploiTempsJeudiPerFour = disponibiliteRepository.findDisponibiliteBySemaine(periodes[3], days[3], nomSemaine);

		//Jeudi
		List<Disponibilite> emploiTempsVendrediPerOne = disponibiliteRepository.findDisponibiliteBySemaine(periodes[0], days[4], nomSemaine);
		List<Disponibilite> emploiTempsVendrediPerTwo = disponibiliteRepository.findDisponibiliteBySemaine(periodes[1], days[4], nomSemaine);
		List<Disponibilite> emploiTempsVendrediPerThree = disponibiliteRepository.findDisponibiliteBySemaine(periodes[2], days[4], nomSemaine);
		List<Disponibilite> emploiTempsVendrediPerFour = disponibiliteRepository.findDisponibiliteBySemaine(periodes[3], days[4],  nomSemaine);
		
		
		//models
		
		//Lundi
		model.put("emploiTempsLundiPerOne", emploiTempsLundiPerOne);
		model.put("emploiTempsLundiPerTwo", emploiTempsLundiPerTwo);
		model.put("emploiTempsLundiPerThree", emploiTempsLundiPerThree);
		model.put("emploiTempsLundiPerFour", emploiTempsLundiPerFour);
		
	
		//Mardi
		model.put("emploiTempsMardiPerOne", emploiTempsMardiPerOne);
		model.put("emploiTempsMardiPerTwo", emploiTempsMardiPerTwo);
		model.put("emploiTempsMardiPerThree", emploiTempsMardiPerThree);
		model.put("emploiTempsMardiPerFour", emploiTempsMardiPerFour);
		
		
		//Mercredi
		model.put("emploiTempsMercrediPerOne", emploiTempsMercrediPerOne);
		model.put("emploiTempsMercrediPerTwo", emploiTempsMercrediPerTwo);
		model.put("emploiTempsMercrediPerThree", emploiTempsMercrediPerThree);
		model.put("emploiTempsMercrediPerFour", emploiTempsMercrediPerFour);
		
		//Jeudi
		model.put("emploiTempsJeudiPerOne", emploiTempsJeudiPerOne);
		model.put("emploiTempsJeudiPerTwo", emploiTempsJeudiPerTwo);
		model.put("emploiTempsJeudiPerThree", emploiTempsJeudiPerThree);
		model.put("emploiTempsJeudiPerFour", emploiTempsJeudiPerFour);
		
		//Vendredi
		model.put("emploiTempsVendrediPerOne", emploiTempsVendrediPerOne);
		model.put("emploiTempsVendrediPerTwo", emploiTempsVendrediPerTwo);
		model.put("emploiTempsVendrediPerThree", emploiTempsVendrediPerThree);
		model.put("emploiTempsVendrediPerFour", emploiTempsVendrediPerFour);
			
		return "disponibilite";
	}	
	
	
	
}
