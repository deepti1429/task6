package com.sample.loginform.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.loginform.Entity.PlanEntity;
import com.sample.loginform.Repository.PlanRepo;

@Service
public class PlanService {

    @Autowired
    private PlanRepo repo;

    public PlanEntity savePlan(PlanEntity plan) {
        return repo.save(plan);
    }

    public List<PlanEntity> getAllPlans() {
        return repo.findAll();
    }

    public Optional<PlanEntity> getPlanById(Long id) {
        return repo.findById(id);
    }

    public void deletePlanById(Long id) {
        repo.deleteById(id);
    }

    public PlanEntity updatePlan(Long id, PlanEntity planDetails) {
        return repo.findById(id)
                   .map(plan -> {
                       plan.setName(planDetails.getName());
                      plan.setDataLimit(planDetails.getDataLimit());
                      plan.setCallMinutes(plan.getCallMinutes());
                      plan.setDescription(plan.getDescription());
                      plan.setPrice(plan.getPrice());
                      plan.setSmsLimit(plan.getSmsLimit());
                      plan.setId(plan.getId());
                       return repo.save(plan);
                   })
                   .orElseGet(() -> {
                       planDetails.setId(id);
                       return repo.save(planDetails);
                   });
    }
}
