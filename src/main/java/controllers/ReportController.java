package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.EmploiTempsRepository;
import dao.FiliereRepository;
import dao.SalleRepository;
import entities.EmploiTemps;
import entities.Filiere;
import entities.Salle;
import view.ExcelEmploiTempsReportView;
import view.TestClass;

@Controller
@RequestMapping(value="/")
public class ReportController 
{

  @Autowired
  SalleRepository salleRepository;
  
  @Autowired
  FiliereRepository filiereRepository;
  
  @Autowired
  EmploiTempsRepository emploiTempsRepository;

 
 @RequestMapping(value="/report", method=RequestMethod.GET)
 public ModelAndView userListReport(ModelMap model, HttpServletRequest req, HttpServletResponse res)
 	{
	 	String typeReport = req.getParameter("type");
	 
	 	List<Salle> salles = salleRepository.findAll();
	 	model.put("salles", salles);
	 	
	 	
	 	  if(typeReport != null && typeReport.equals("xls")){
	 		   return new ModelAndView(new ExcelEmploiTempsReportView(), "salleList", salles);
	 		  }
  
	 	return new ModelAndView("userListReport", "userList", salles);	
	 	//return "userListReport";
 	}


@RequestMapping(value="/reporttwo" , method = RequestMethod.GET)
public String getReport(ModelMap model, HttpServletRequest req, HttpServletResponse res, @RequestParam(value="DropBoxFilieres", required =false) Long idFiliere, @RequestParam(value="DropBoxSemaine", required =false) String nomSemaine)
{	
	List<Filiere> filieres = filiereRepository.findAll();
	model.put("filieres", filieres);


 	return "userListTwo";
}

@RequestMapping(value="/reporttwo" , method = RequestMethod.POST)
public ModelAndView postReport(ModelMap model, HttpServletRequest req, @RequestParam(value="DropBoxFilieres", required =false) Long idFiliere, @RequestParam(value="DropBoxSemaine", required =false) String nomSemaine)
{	

	String[] days = {"Lundi", "Mardi", "Mercredi","Jeudi","Vendredi"};
	String[] periodes = {"8h-10h", "10h-12h", "14h-16h", "16h-18h"};
	
	List<Filiere> filieres = filiereRepository.findAll();
	model.put("filieres", filieres);
	
	/* ------------------ Initializers ------------------ */
	//Lundi
	EmploiTemps emploiTempsLundiPerOne = new EmploiTemps();
	EmploiTemps emploiTempsLundiPerTwo = new EmploiTemps();
	EmploiTemps emploiTempsLundiPerThree = new EmploiTemps();
	EmploiTemps emploiTempsLundiPerFour = new EmploiTemps();

	//Mardi
	EmploiTemps emploiTempsMardiPerOne = new EmploiTemps();
	EmploiTemps emploiTempsMardiPerTwo = new EmploiTemps();
	EmploiTemps emploiTempsMardiPerThree = new EmploiTemps();
	EmploiTemps emploiTempsMardiPerFour = new EmploiTemps();

	//Mercredi
	EmploiTemps emploiTempsMercrediPerOne = new EmploiTemps();
	EmploiTemps emploiTempsMercrediPerTwo = new EmploiTemps();
	EmploiTemps emploiTempsMercrediPerThree = new EmploiTemps();
	EmploiTemps emploiTempsMercrediPerFour = new EmploiTemps();
	
	//Jeudi
	EmploiTemps emploiTempsJeudiPerOne = new EmploiTemps();
	EmploiTemps emploiTempsJeudiPerTwo = new EmploiTemps();
	EmploiTemps emploiTempsJeudiPerThree = new EmploiTemps();
	EmploiTemps emploiTempsJeudiPerFour = new EmploiTemps();

	//Vendredi
	EmploiTemps emploiTempsVendrediPerOne = new EmploiTemps();
	EmploiTemps emploiTempsVendrediPerTwo = new EmploiTemps();
	EmploiTemps emploiTempsVendrediPerThree = new EmploiTemps();
	EmploiTemps emploiTempsVendrediPerFour = new EmploiTemps();	


	/* --------------------------------------------------*/

	//Lundi
	emploiTempsLundiPerOne = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[0], days[0], idFiliere, nomSemaine);	
	emploiTempsLundiPerTwo = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[1], days[0], idFiliere, nomSemaine);
	emploiTempsLundiPerThree = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[2], days[0], idFiliere, nomSemaine);
	emploiTempsLundiPerFour = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[3], days[0], idFiliere, nomSemaine);

	//Mardi
	emploiTempsMardiPerOne = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[0], days[1], idFiliere, nomSemaine);
	emploiTempsMardiPerTwo = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[1], days[1], idFiliere, nomSemaine);
	emploiTempsMardiPerThree = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[2], days[1], idFiliere, nomSemaine);
	emploiTempsMardiPerFour = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[3], days[1], idFiliere, nomSemaine);

	//Mercredi 
	emploiTempsMercrediPerOne = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[0], days[2], idFiliere, nomSemaine);
	emploiTempsMercrediPerTwo = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[1], days[2], idFiliere, nomSemaine);
	emploiTempsMercrediPerThree = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[2], days[2], idFiliere, nomSemaine);
	emploiTempsMercrediPerFour = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[3], days[2], idFiliere, nomSemaine);

	//Jeudi
	emploiTempsJeudiPerOne = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[0], days[3], idFiliere, nomSemaine);
	emploiTempsJeudiPerTwo = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[1], days[3], idFiliere, nomSemaine);
	emploiTempsJeudiPerThree = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[2], days[3], idFiliere, nomSemaine);
	emploiTempsJeudiPerFour = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[3], days[3], idFiliere, nomSemaine);

	//Vendredi
	emploiTempsVendrediPerOne = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[0], days[4], idFiliere, nomSemaine);
	emploiTempsVendrediPerTwo = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[1], days[4], idFiliere, nomSemaine);
	emploiTempsVendrediPerThree = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[2], days[4], idFiliere, nomSemaine);
	emploiTempsVendrediPerFour = emploiTempsRepository.findOneEmploiByHourAndDayAndFiliereAndSemaine(periodes[3], days[4], idFiliere, nomSemaine);
	
	/*-------------------------------------------------------------------*/	

	//Lundi
	if(emploiTempsLundiPerOne == null)
	{
		emploiTempsLundiPerOne = new EmploiTemps();
	}
	if(emploiTempsLundiPerTwo == null)
	{
		emploiTempsLundiPerTwo = new EmploiTemps();
	}
	if(emploiTempsLundiPerThree == null)
	{
		emploiTempsLundiPerThree = new EmploiTemps();
	}
	if(emploiTempsLundiPerFour == null)
	{
		emploiTempsLundiPerFour = new EmploiTemps();
	}


	//Mardi
	if(emploiTempsMardiPerOne == null)
	{
			emploiTempsMardiPerOne = new EmploiTemps();
	}
	if(emploiTempsMardiPerTwo == null)
	{
		emploiTempsMardiPerTwo = new EmploiTemps();
	}
	if(emploiTempsMardiPerThree == null)
	{
		emploiTempsMardiPerThree = new EmploiTemps();
	}
	if(emploiTempsMardiPerFour == null)
	{
		emploiTempsMardiPerFour = new EmploiTemps();
	}	

	//Mercredi
	if(emploiTempsMercrediPerOne == null)
	{
		emploiTempsMercrediPerOne = new EmploiTemps();
	}
	if(emploiTempsMercrediPerTwo == null)
	{
		emploiTempsMercrediPerTwo = new EmploiTemps();
	}
	if(emploiTempsMercrediPerThree == null)
	{
		emploiTempsMercrediPerThree = new EmploiTemps();
	}
	if(emploiTempsMercrediPerFour == null)
	{
		emploiTempsMercrediPerFour = new EmploiTemps();
	}

	//Jeudi
	if(emploiTempsJeudiPerOne == null)
	{
		emploiTempsJeudiPerOne = new EmploiTemps();
	}
	if(emploiTempsJeudiPerTwo == null)
	{
		emploiTempsJeudiPerTwo = new EmploiTemps();
	}
	if(emploiTempsJeudiPerThree == null)
	{
		emploiTempsJeudiPerThree = new EmploiTemps();
	}
	if(emploiTempsJeudiPerFour == null)
	{
			emploiTempsJeudiPerFour = new EmploiTemps();
	}

	//Vendredi
	if(emploiTempsVendrediPerOne == null)
	{
		emploiTempsVendrediPerOne = new EmploiTemps();
	}
	if(emploiTempsVendrediPerTwo == null)
	{
		emploiTempsVendrediPerTwo = new EmploiTemps();
	}
	if(emploiTempsVendrediPerThree == null)
	{
		emploiTempsVendrediPerThree = new EmploiTemps();
	}
	if(emploiTempsVendrediPerFour == null)
	{
		emploiTempsVendrediPerFour = new EmploiTemps();
	}

	/* -----------------------------------------------*/

	System.out.println("Pour SSI : " + emploiTempsLundiPerOne.getFiliere().getNomFiliere()+ emploiTempsLundiPerOne.getSemaineEmploi()+"\n");
TestClass testOne = 
new TestClass
(
	"Matiere : " +emploiTempsLundiPerOne.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsLundiPerOne.getProfesseur().getNomProfesseur()+ " " + emploiTempsLundiPerOne.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsLundiPerOne.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsLundiPerOne.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsLundiPerTwo.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsLundiPerTwo.getProfesseur().getNomProfesseur()+ " " + emploiTempsLundiPerTwo.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsLundiPerTwo.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsLundiPerTwo.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsLundiPerThree.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsLundiPerThree.getProfesseur().getNomProfesseur()+ " " + emploiTempsLundiPerThree.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsLundiPerThree.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsLundiPerThree.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsLundiPerFour.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsLundiPerFour.getProfesseur().getNomProfesseur()+ " " + 	emploiTempsLundiPerFour.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsLundiPerFour.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsLundiPerFour.getSalle().getNomSalle()

);	


TestClass testTwo = 
new TestClass
(
	"Matiere : " +emploiTempsMardiPerOne.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsMardiPerOne.getProfesseur().getNomProfesseur()+ " " + emploiTempsMardiPerOne.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsMardiPerOne.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsMardiPerOne.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsMardiPerTwo.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsMardiPerTwo.getProfesseur().getNomProfesseur()+ " " + emploiTempsMardiPerTwo.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsMardiPerTwo.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsMardiPerTwo.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsMardiPerThree.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsMardiPerThree.getProfesseur().getNomProfesseur()+ " " + emploiTempsMardiPerThree.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsMardiPerThree.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsMardiPerThree.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsMardiPerFour.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsMardiPerFour.getProfesseur().getNomProfesseur()+ " " + 	emploiTempsMardiPerFour.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsMardiPerFour.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsMardiPerFour.getSalle().getNomSalle()

);	


TestClass testThree = 
new TestClass
(
	"Matiere : " +emploiTempsMercrediPerOne.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsMercrediPerOne.getProfesseur().getNomProfesseur()+ " " + emploiTempsMercrediPerOne.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsMercrediPerOne.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsMercrediPerOne.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsMercrediPerTwo.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsMercrediPerTwo.getProfesseur().getNomProfesseur()+ " " + emploiTempsMercrediPerTwo.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsMercrediPerTwo.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsMercrediPerTwo.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsMercrediPerThree.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsMercrediPerThree.getProfesseur().getNomProfesseur()+ " " + emploiTempsMercrediPerThree.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsMercrediPerThree.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsMercrediPerThree.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsMercrediPerFour.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsMercrediPerFour.getProfesseur().getNomProfesseur()+ " " + 	emploiTempsMercrediPerFour.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsMercrediPerFour.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsMercrediPerFour.getSalle().getNomSalle()

);

TestClass testFour = 
new TestClass
(
	"Matiere : " +emploiTempsJeudiPerOne.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsMercrediPerOne.getProfesseur().getNomProfesseur()+ " " + emploiTempsMercrediPerOne.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsMercrediPerOne.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsMercrediPerOne.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsJeudiPerTwo.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsJeudiPerTwo.getProfesseur().getNomProfesseur()+ " " + emploiTempsJeudiPerTwo.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsJeudiPerTwo.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsJeudiPerTwo.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsJeudiPerThree.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsJeudiPerThree.getProfesseur().getNomProfesseur()+ " " + emploiTempsJeudiPerThree.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsJeudiPerThree.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsJeudiPerThree.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsJeudiPerFour.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsJeudiPerFour.getProfesseur().getNomProfesseur()+ " " + 	emploiTempsJeudiPerFour.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsJeudiPerFour.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsJeudiPerFour.getSalle().getNomSalle()

);

TestClass testFive = 
new TestClass
(
	"Matiere : " +emploiTempsVendrediPerOne.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsVendrediPerOne.getProfesseur().getNomProfesseur()+ " " + emploiTempsVendrediPerOne.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsVendrediPerOne.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsVendrediPerOne.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsVendrediPerTwo.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsVendrediPerTwo.getProfesseur().getNomProfesseur()+ " " + emploiTempsVendrediPerTwo.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsVendrediPerTwo.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsVendrediPerTwo.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsVendrediPerThree.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsVendrediPerThree.getProfesseur().getNomProfesseur()+ " " + emploiTempsVendrediPerThree.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsVendrediPerThree.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsVendrediPerThree.getSalle().getNomSalle(),

	"Matiere : " +emploiTempsVendrediPerFour.getMatiere().getNomMatiere()+
	"\n Professeur : " +emploiTempsVendrediPerFour.getProfesseur().getNomProfesseur()+ " " + 	emploiTempsVendrediPerFour.getProfesseur().getPrenomProfesseur()+ 
	"\n Groupe : " +emploiTempsVendrediPerFour.getProfesseur().getNomProfesseur()+
	"\n Salle : " +emploiTempsVendrediPerFour.getSalle().getNomSalle()

);	


List<TestClass> listclasse = new ArrayList<TestClass>();
listclasse.add(testOne);
listclasse.add(testTwo);
listclasse.add(testThree);
listclasse.add(testFour);
listclasse.add(testFive);


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
	
/* ------------------------------------------------ */

return new ModelAndView(new ExcelEmploiTempsReportView(), "listClasse", listclasse);
	
}
}
