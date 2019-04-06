package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.MatiereRepository;
import dao.SalleRepository;
import entities.Matiere;
import entities.Salle;

@Controller
public class SalleController {
	
	@Autowired
	MatiereRepository matiereRepository;
	
	@Autowired
	SalleRepository salleRepository;
	
	@RequestMapping(value="/addsalle" , method = RequestMethod.GET)
	public String viewSalle(ModelMap model)
	{
		List<Matiere> matieres = matiereRepository.findAll();
		
		model.put("matieres", matieres);
		return "addsalle";
	}	
	
	@RequestMapping(value="/addsalle" , method = RequestMethod.POST)
	public String createSalle(ModelMap model, Salle salle)
	{
 	
		/*Matiere matiere = matiereRepository.findOne(idMatiere);
		salle.setMatiere(matiere);*/ 
	
		salleRepository.save(salle);
		return "redirect:/addsalle";
	}	
	
	@RequestMapping(value="/deletesalle" , method = RequestMethod.GET)
	public String viewDeleteSalle(ModelMap model)
	{
		List<Salle> salles = salleRepository.findAll();
		
		model.put("salles", salles);
		return "deletesalle";
	}	
	
    @RequestMapping(value="/deletesalle",method = RequestMethod.POST)
    public String deleteSalle(ModelMap model, @RequestParam("DropBoxSalle") Long chosenId)
    {

        salleRepository.delete(chosenId);
        
        return "redirect:/deletesalle";
    }
}
