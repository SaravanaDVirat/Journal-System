package com.example.journal.system.Controller;

import com.example.journal.system.Entity.journey;
import com.example.journal.system.Repository.JourRepository;
import com.example.journal.system.Service.JourService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.exceptions.TemplateInputException;


@Controller
public class JourController {

    @Autowired
    public JourService jourservice;
    public JourRepository jourrepository;

    @GetMapping("/")

    public String getIndex(Model model)
    {
        model.addAttribute("journey",new journey());
        return "index";
    }

    @GetMapping("/addJourney")
    public String showaddJourney(Model model)
    {
        model.addAttribute("journey",new journey());
        return "addJourney";
    }
    @GetMapping("/updateJourney")
    public String showupdateJourney(Model model)
    {
        model.addAttribute("journey",new journey());
        return "updateJourney";
    }
    @GetMapping("/deleteJourney")
    public String showdeleteJourney(Model model)
    {
        model.addAttribute("journey",new journey());
        return "deleteJourney";
    }

    @GetMapping("/searchJourney")
    public String showsearchjourney(Model model)
    {
        model.addAttribute("journey",new journey());
        return "searchJourney";
    }

    @PostMapping("/searchJourney")
    public String getJourneyById(Model model, String id) {
        try {
            Long journeyid = null;

            if (id != null) {
                    journeyid = Long.parseLong(id);
                }

            if (journeyid == null) {
                model.addAttribute("journey", null);
                model.addAttribute("error", "Please enter a valid id");
            }

            journey journey1 = jourservice.getById(journeyid);

            if (journey1 != null) {
                model.addAttribute("journey", journey1);
                model.addAttribute("success", "Journey details fetched successfully.");
            } else {
                model.addAttribute("journey", null);
                model.addAttribute("error", " the given ID not found.");
            }
        }
        catch(NumberFormatException ae)
        {
            model.addAttribute("journey",null);
            model.addAttribute("error","id is not found please enter a number");
        }
        catch (Exception e) {
            model.addAttribute("journey", null);
            model.addAttribute("error", "id is not found please enter valid id");
        }

        return "searchJourney";
    }


    @PostMapping("/addJourney")
    public String saveData(@ModelAttribute journey journey,Model model)
    {
       journey journey1=jourservice.saveJourney(journey);
       if(journey1!=null)
       {
           model.addAttribute("success","journey list added successfully");
       }
       else
       {
           model.addAttribute("error","error to add list");
       }
       return "addJourney";
    }

    @PostMapping("/updateJourney")
    public String updateData(@ModelAttribute journey journey, Model model,String id) {
        try {
            Long jourid = null;

            if(id != null) {
                    jourid = Long.parseLong(id);

            }
            if (jourid == null) {
                model.addAttribute("journey", null);
                model.addAttribute("error1", "Please enter a valid id");
            }
            journey journey1 = jourservice.updateJourney(journey, jourid);

            if (journey1 != null) {
                model.addAttribute("journey", journey1);
                model.addAttribute("success1", "Journey list updated successfully");
            }
        }
        catch(NumberFormatException ae)
        {
            model.addAttribute("journey",null);
            model.addAttribute("error1","id is not found please enter a number");
        }
        catch (Exception e) {
            model.addAttribute("journey", null);
            model.addAttribute("error1", "id is not found");
        }
        return "updateJourney";
    }



    @PostMapping("/deleteJourney")

    public String deleteData(Model model,String id)
    {
        try {
            Long jourid=null;
            if(id != null) {
                    jourid = Long.parseLong(id);
            }
            if (jourid == null) {
                model.addAttribute("journey", null);
                model.addAttribute("error", "Please enter a valid id");
            }

            journey journey1 = jourservice.deleteJourney(jourid);
            if (journey1 != null) {
                model.addAttribute("journey", journey1);
                model.addAttribute("success", "journey list deleted successfully");
            }
        }
        catch(NumberFormatException ae)
        {
            model.addAttribute("journey",null);
            model.addAttribute("error","id is not found please enter a number");
        }
        catch (Exception e)
        {
            model.addAttribute("journey",null);
            model.addAttribute("error","id is not found");
        }
        return "deleteJourney";
    }

}
