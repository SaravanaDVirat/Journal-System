package com.example.journal.system.Service;

import com.example.journal.system.Entity.journey;
import com.example.journal.system.Repository.JourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JourService {
    @Autowired
    public JourRepository jourrepository;
    public journey getById(Long id)
    {
        return jourrepository.findById(id).get();
    }
    public journey saveJourney(journey journey)
    {
       return jourrepository.save(journey);
    }
    public journey updateJourney(journey journey, Long id)
    {
        journey journey1=jourrepository.findById(id).get();
        if(journey1!=null)
        {
            journey1.setUsername(journey.getUsername());
            journey1.setEmail(journey.getEmail());
            journey1.setSource(journey.getSource());
            journey1.setDestination(journey.getDestination());
        }
        return jourrepository.save(journey1);
    }
    public journey deleteJourney(Long id)
    {
        journey journey=jourrepository.findById(id).get();
        if(journey!=null)
        {
            jourrepository.delete(journey);
        }
        return journey;
    }
}
