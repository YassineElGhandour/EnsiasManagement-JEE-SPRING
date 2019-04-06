package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.EmploiTempsRepository;
import dao.FiliereRepository;
import dao.GroupeRepository;
import dao.MatiereRepository;
import dao.ProfesseurRepository;
import dao.SalleRepository;
import dao.SemestreRepository;
import entities.EmploiTemps;
import entities.Filiere;
import entities.Groupe;
import entities.Matiere;
import entities.Professeur;
import entities.Salle;
import entities.Semestre;

@Controller
public class EmploiTempsContoller 
{
	@Autowired
	GroupeRepository groupeRepository;
	
	@Autowired
	FiliereRepository filiereRepository;
	
	@Autowired
	ProfesseurRepository professeurRepository;
	
	@Autowired
	SalleRepository salleRepository;

	@Autowired
	MatiereRepository matiereRepository;
	
	@Autowired
	EmploiTempsRepository emploiTempsRepository;
	
	@Autowired
	SemestreRepository semestreRepository;
	
	@RequestMapping(value="/insertemploi" , method = RequestMethod.GET)
	public String viewEmploiTemps(ModelMap model)
	{
		List<Matiere> matieres = matiereRepository.findAll();
		List<Filiere> filieres = filiereRepository.findAll();
		List<Professeur> professeurs = professeurRepository.findAll();
		List<Salle> salles = salleRepository.findAll();
		List<Groupe> groupes = groupeRepository.findAll();
		List<Semestre> semestres = semestreRepository.findAll();
		
		model.put("matieres", matieres);
		model.put("filieres", filieres);
		model.put("professeurs", professeurs);
		model.put("salles", salles);
		model.put("groupes", groupes);
		model.put("semestres", semestres);
		
		return "insertemploi";
	}	
	
	@RequestMapping(value="/insertemploi" , method = RequestMethod.POST)
	public String createEmploiTemps(ModelMap model, EmploiTemps emploiTemps, @RequestParam("DropBoxProf") String emailProf, @RequestParam("DropBoxSalle") Long idSalle,  @RequestParam("DropBoxGroupe") Long idGroupe,  @RequestParam("DropBoxMatiere") Long idMatiere, @RequestParam("DropBoxFiliere") Long idFiliere, @RequestParam("DropBoxSemestre") Long idSem)
	{
		Professeur prof = professeurRepository.findOneProfesseurByEmail(emailProf);
		emploiTemps.setProfesseur(prof);
	
		Groupe groupe = groupeRepository.findOneGroupeById(idGroupe);
		emploiTemps.setGroupe(groupe);
		
		Matiere matiere = matiereRepository.findOne(idMatiere);
		emploiTemps.setMatiere(matiere);
		
		Salle salle = salleRepository.findOne(idSalle);
		emploiTemps.setSalle(salle);
		
		Filiere filiere = filiereRepository.findOne(idFiliere);
		emploiTemps.setFiliere(filiere);
		
		Semestre sem = semestreRepository.findOne(idSem);
		emploiTemps.setSemestre(sem);

		emploiTempsRepository.save(emploiTemps);
		
		return "redirect:/insertemploi";
	}

	/*----------------------------- AFFICHER EMPL ----------------------*/
	
	@RequestMapping(value="/afficherempl" , method = RequestMethod.GET)
	public String viewEmploiTempsTwo(ModelMap model)
	{	
		String[] days = {"Lundi", "Mardi", "Mercredi","Jeudi","Vendredi"};
		String[] periodes = {"8h-10h", "10h-12h", "14h-16h", "16h-18h"};
		
		List<Filiere> filieres = filiereRepository.findAll();
		model.put("filieres", filieres);
		
		//Okay?
		//Lundi

		List<EmploiTemps> emploiTempsLundiPerOne = emploiTempsRepository.findEmploiByHourAndDay(periodes[0], days[0]);
		List<EmploiTemps> emploiTempsLundiPerTwo = emploiTempsRepository.findEmploiByHourAndDay(periodes[1], days[0]);
		List<EmploiTemps> emploiTempsLundiPerThree = emploiTempsRepository.findEmploiByHourAndDay(periodes[2], days[0]);
		List<EmploiTemps> emploiTempsLundiPerFour = emploiTempsRepository.findEmploiByHourAndDay(periodes[3], days[0]);

		//Mardi
		List<EmploiTemps> emploiTempsMardiPerOne = emploiTempsRepository.findEmploiByHourAndDay(periodes[0], days[1]);
		List<EmploiTemps> emploiTempsMardiPerTwo = emploiTempsRepository.findEmploiByHourAndDay(periodes[1], days[1]);
		List<EmploiTemps> emploiTempsMardiPerThree = emploiTempsRepository.findEmploiByHourAndDay(periodes[2], days[1]);
		List<EmploiTemps> emploiTempsMardiPerFour = emploiTempsRepository.findEmploiByHourAndDay(periodes[3], days[1]);

		
		//Mercredi 
		List<EmploiTemps> emploiTempsMercrediPerOne = emploiTempsRepository.findEmploiByHourAndDay(periodes[0], days[2]);
		List<EmploiTemps> emploiTempsMercrediPerTwo = emploiTempsRepository.findEmploiByHourAndDay(periodes[1], days[2]);
		List<EmploiTemps> emploiTempsMercrediPerThree = emploiTempsRepository.findEmploiByHourAndDay(periodes[2], days[2]);
		List<EmploiTemps> emploiTempsMercrediPerFour = emploiTempsRepository.findEmploiByHourAndDay(periodes[3], days[2]);

		//Jeudi
		List<EmploiTemps> emploiTempsJeudiPerOne = emploiTempsRepository.findEmploiByHourAndDay(periodes[0], days[3]);
		List<EmploiTemps> emploiTempsJeudiPerTwo = emploiTempsRepository.findEmploiByHourAndDay(periodes[1], days[3]);
		List<EmploiTemps> emploiTempsJeudiPerThree = emploiTempsRepository.findEmploiByHourAndDay(periodes[2], days[3]);
		List<EmploiTemps> emploiTempsJeudiPerFour = emploiTempsRepository.findEmploiByHourAndDay(periodes[3], days[3]);

		//Vendredi
		List<EmploiTemps> emploiTempsVendrediPerOne = emploiTempsRepository.findEmploiByHourAndDay(periodes[0], days[4]);
		List<EmploiTemps> emploiTempsVendrediPerTwo = emploiTempsRepository.findEmploiByHourAndDay(periodes[1], days[4]);
		List<EmploiTemps> emploiTempsVendrediPerThree = emploiTempsRepository.findEmploiByHourAndDay(periodes[2], days[4]);
		List<EmploiTemps> emploiTempsVendrediPerFour = emploiTempsRepository.findEmploiByHourAndDay(periodes[3], days[4]);
		
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
			
		return "afficherempl";
	}
	
	@RequestMapping(value="/afficherempl" , method = RequestMethod.POST)
	public String chooseEmploiTemps(ModelMap model, @RequestParam(value="DropBoxFilieres", required =false) Long idFiliere, @RequestParam(value="DropBoxSemaine", required =false) String nomSemaine)
	{	
		String[] days = {"Lundi", "Mardi", "Mercredi","Jeudi","Vendredi"};
		String[] periodes = {"8h-10h", "10h-12h", "14h-16h", "16h-18h"};
		
		List<Filiere> filieres = filiereRepository.findAll();
		model.put("filieres", filieres);
		
		//Okay?
		//Lundi

		List<EmploiTemps> emploiTempsLundiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[0], days[0], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsLundiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[1], days[0], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsLundiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[2], days[0], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsLundiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[3], days[0], idFiliere, nomSemaine);

		//Mardi
		List<EmploiTemps> emploiTempsMardiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[0], days[1], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsMardiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[1], days[1], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsMardiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[2], days[1], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsMardiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[3], days[1], idFiliere, nomSemaine);

		
		//Mercredi 
		List<EmploiTemps> emploiTempsMercrediPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[0], days[2], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsMercrediPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[1], days[2], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsMercrediPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[2], days[2], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsMercrediPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[3], days[2], idFiliere, nomSemaine);

		//Jeudi
		List<EmploiTemps> emploiTempsJeudiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[0], days[3], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsJeudiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[1], days[3], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsJeudiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[2], days[3], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsJeudiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[3], days[3], idFiliere, nomSemaine);

		//Jeudi
		List<EmploiTemps> emploiTempsVendrediPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[0], days[4], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsVendrediPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[1], days[4], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsVendrediPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[2], days[4], idFiliere, nomSemaine);
		List<EmploiTemps> emploiTempsVendrediPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaine(periodes[3], days[4], idFiliere, nomSemaine);
		
		
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
			
		/*
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<5; j++)
			{
				List<EmploiTemps> emploiTempss = emploiTempsRepository.findEmploiByHourAndDay(periodes[0], days[1]);
				model.put("emploiTempss", emploiTempss);
				//System.out.println("\n Lets try it : "+ emploiTempss.get(0).getSalle().getIdSalle() +"\n");
			}
		} 
		*/
		return "afficherempl";
	}	

	/*----------------------------- AFFICHER GRP ----------------------*/
	
	
	@RequestMapping(value="/afficherpargrp" , method = RequestMethod.GET)
	public String viewEmploiTempsPerGroupe(ModelMap model)
	{	
		List<Filiere> filieres = filiereRepository.findAll();
		model.put("filieres", filieres);
		
		List<Groupe> groupes = groupeRepository.findAll();
		model.put("groupes", groupes);
		
			
		return "afficherpargrp";
	}
	
	@RequestMapping(value="/afficherpargrp" , method = RequestMethod.POST)
	public String chooseEmploiTempsPerGroupe(ModelMap model, @RequestParam(value="DropBoxFilieres", required =false) Long idFiliere, @RequestParam(value="DropBoxSemaine", required =false) String nomSemaine, @RequestParam("DropBoxGroupe") Long idGroupe)
	{	
		String[] days = {"Lundi", "Mardi", "Mercredi","Jeudi","Vendredi"};
		String[] periodes = {"8h-10h", "10h-12h", "14h-16h", "16h-18h"};
		
		List<Filiere> filieres = filiereRepository.findAll();
		model.put("filieres", filieres);
		
		List<Groupe> groupes = groupeRepository.findAll();
		model.put("groupes", groupes);
		
		//Okay?
		//Lundi

		List<EmploiTemps> emploiTempsLundiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[0], days[0], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsLundiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[1], days[0], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsLundiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[2], days[0], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsLundiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[3], days[0], idFiliere, nomSemaine, idGroupe);

		//Mardi
		List<EmploiTemps> emploiTempsMardiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[0], days[1], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsMardiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[1], days[1], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsMardiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[2], days[1], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsMardiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[3], days[1], idFiliere, nomSemaine, idGroupe);

		
		//Mercredi 
		List<EmploiTemps> emploiTempsMercrediPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[0], days[2], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsMercrediPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[1], days[2], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsMercrediPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[2], days[2], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsMercrediPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[3], days[2], idFiliere, nomSemaine, idGroupe);

		//Jeudi
		List<EmploiTemps> emploiTempsJeudiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[0], days[3], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsJeudiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[1], days[3], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsJeudiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[2], days[3], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsJeudiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[3], days[3], idFiliere, nomSemaine, idGroupe);

		//Jeudi
		List<EmploiTemps> emploiTempsVendrediPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[0], days[4], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsVendrediPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[1], days[4], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsVendrediPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[2], days[4], idFiliere, nomSemaine, idGroupe);
		List<EmploiTemps> emploiTempsVendrediPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndGroupe(periodes[3], days[4], idFiliere, nomSemaine, idGroupe);
		
		
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
			
		return "afficherpargrp";
	}	

	/*----------------------------- AFFICHER PROF ----------------------*/
	
	@RequestMapping(value="/afficherparprof" , method = RequestMethod.GET)
	public String viewEmploiTempsPerProf(ModelMap model)
	{	
		List<Filiere> filieres = filiereRepository.findAll();
		model.put("filieres", filieres);
		
		List<Professeur> professeurs = professeurRepository.findAll();
		model.put("professeurs", professeurs);
	
		return "afficherparprof";
	}
	
	@RequestMapping(value="/afficherparprof" , method = RequestMethod.POST)
	public String chooseEmploiTempsPerSalle(ModelMap model, @RequestParam(value="DropBoxSemaine", required =false) String nomSemaine, @RequestParam("DropBoxProf") String emailProf)
	{	
		String[] days = {"Lundi", "Mardi", "Mercredi","Jeudi","Vendredi"};
		String[] periodes = {"8h-10h", "10h-12h", "14h-16h", "16h-18h"};
		
		List<Filiere> filieres = filiereRepository.findAll();
		model.put("filieres", filieres);
		
		List<Professeur> professeurs = professeurRepository.findAll();
		model.put("professeurs", professeurs);
		
		//Okay?
		//Lundi

		List<EmploiTemps> emploiTempsLundiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[0], days[0], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsLundiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[1], days[0], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsLundiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[2], days[0], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsLundiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[3], days[0], nomSemaine, emailProf);

		//Mardi
		List<EmploiTemps> emploiTempsMardiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[0], days[1], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsMardiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[1], days[1], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsMardiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[2], days[1], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsMardiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[3], days[1], nomSemaine, emailProf);

		
		//Mercredi 
		List<EmploiTemps> emploiTempsMercrediPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[0], days[2], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsMercrediPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[1], days[2], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsMercrediPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[2], days[2], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsMercrediPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[3], days[2], nomSemaine, emailProf);

		//Jeudi
		List<EmploiTemps> emploiTempsJeudiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[0], days[3],nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsJeudiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[1], days[3], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsJeudiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[2], days[3], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsJeudiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[3], days[3],  nomSemaine, emailProf);

		//Jeudi
		List<EmploiTemps> emploiTempsVendrediPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[0], days[4], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsVendrediPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[1], days[4], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsVendrediPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[2], days[4], nomSemaine, emailProf);
		List<EmploiTemps> emploiTempsVendrediPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndProf(periodes[3], days[4], nomSemaine, emailProf);
		
		
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
			
		return "afficherparprof";
	}
	
	/*----------------------------- AFFICHER SALLE ----------------------*/
	
	@RequestMapping(value="/afficherparsalle" , method = RequestMethod.GET)
	public String viewEmploiTempsPerSalle(ModelMap model)
	{	
		List<Salle> salles = salleRepository.findAll();
		model.put("salles", salles);
	
		return "afficherparsalle";
	}
	
	@RequestMapping(value="/afficherparsalle" , method = RequestMethod.POST)
	public String chooseEmploiTempsPerSalle(ModelMap model, @RequestParam(value="DropBoxSemaine", required =false) String nomSemaine, @RequestParam("DropBoxSalle") Long idSalle)
	{	
		String[] days = {"Lundi", "Mardi", "Mercredi","Jeudi","Vendredi"};
		String[] periodes = {"8h-10h", "10h-12h", "14h-16h", "16h-18h"};
		
		List<Salle> salles = salleRepository.findAll();
		model.put("salles", salles);
		
		List<Professeur> professeurs = professeurRepository.findAll();
		model.put("professeurs", professeurs);
		
		//Okay?
		//Lundi

		List<EmploiTemps> emploiTempsLundiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[0], days[0], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsLundiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[1], days[0], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsLundiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[2], days[0], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsLundiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[3], days[0], nomSemaine, idSalle);

		//Mardi
		List<EmploiTemps> emploiTempsMardiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[0], days[1], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsMardiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[1], days[1], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsMardiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[2], days[1], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsMardiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[3], days[1], nomSemaine, idSalle);

		
		//Mercredi 
		List<EmploiTemps> emploiTempsMercrediPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[0], days[2], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsMercrediPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[1], days[2], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsMercrediPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[2], days[2], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsMercrediPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[3], days[2], nomSemaine, idSalle);

		//Jeudi
		List<EmploiTemps> emploiTempsJeudiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[0], days[3],nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsJeudiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[1], days[3], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsJeudiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[2], days[3], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsJeudiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[3], days[3],  nomSemaine, idSalle);

		//Jeudi
		List<EmploiTemps> emploiTempsVendrediPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[0], days[4], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsVendrediPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[1], days[4], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsVendrediPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[2], days[4], nomSemaine, idSalle);
		List<EmploiTemps> emploiTempsVendrediPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndSalle(periodes[3], days[4], nomSemaine, idSalle);
		
		
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
			
		return "afficherparsalle";
	}
	
	/*----------------------------- AFFICHER MATIERE ----------------------*/
	
	@RequestMapping(value="/afficherparmat" , method = RequestMethod.GET)
	public String viewEmploiTempsPerMatiere(ModelMap model)
	{	
		List<Matiere> matieres = matiereRepository.findAll();
		model.put("matieres", matieres);
	
		return "afficherparmat";
	}
	
	@RequestMapping(value="/afficherparmat" , method = RequestMethod.POST)
	public String chooseEmploiTempsPerMatiere(ModelMap model, @RequestParam(value="DropBoxSemaine", required =false) String nomSemaine, @RequestParam("DropBoxMat") Long idMatiere)
	{	
		String[] days = {"Lundi", "Mardi", "Mercredi","Jeudi","Vendredi"};
		String[] periodes = {"8h-10h", "10h-12h", "14h-16h", "16h-18h"};
		
		List<Matiere> matieres = matiereRepository.findAll();
		model.put("matieres", matieres);
		
		//Okay?
		//Lundi

		List<EmploiTemps> emploiTempsLundiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[0], days[0], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsLundiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[1], days[0], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsLundiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[2], days[0], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsLundiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[3], days[0], nomSemaine, idMatiere);

		//Mardi
		List<EmploiTemps> emploiTempsMardiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[0], days[1], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsMardiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[1], days[1], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsMardiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[2], days[1], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsMardiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[3], days[1], nomSemaine, idMatiere);

		
		//Mercredi 
		List<EmploiTemps> emploiTempsMercrediPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[0], days[2], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsMercrediPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[1], days[2], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsMercrediPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[2], days[2], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsMercrediPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[3], days[2], nomSemaine, idMatiere);

		//Jeudi
		List<EmploiTemps> emploiTempsJeudiPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[0], days[3],nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsJeudiPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[1], days[3], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsJeudiPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[2], days[3], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsJeudiPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[3], days[3],  nomSemaine, idMatiere);

		//Jeudi
		List<EmploiTemps> emploiTempsVendrediPerOne = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[0], days[4], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsVendrediPerTwo = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[1], days[4], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsVendrediPerThree = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[2], days[4], nomSemaine, idMatiere);
		List<EmploiTemps> emploiTempsVendrediPerFour = emploiTempsRepository.findEmploiByHourAndDayAndFiliereAndSemaineAndMat(periodes[3], days[4], nomSemaine, idMatiere);
		
		
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
			
		return "afficherparmat";
	}
	
}
