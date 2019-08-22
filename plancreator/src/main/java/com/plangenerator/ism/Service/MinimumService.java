package com.plangenerator.ism.Service;


import com.plangenerator.ism.Model.Minimum;
import com.plangenerator.ism.Repository.MinimumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinimumService {
    @Autowired
    private MinimumRepository minimumRepository;



    public List<Minimum> getMinimumList(){
        return minimumRepository.findAll();
    }
   public int countPlan(){
       return getMinimumList().size();
   }

}


