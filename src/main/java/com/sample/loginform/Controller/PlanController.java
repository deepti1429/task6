package com.sample.loginform.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.loginform.Entity.PlanEntity;
import com.sample.loginform.Service.PlanService;

@RestController
@RequestMapping("/api")
public class PlanController {

    @Autowired
    private PlanService serv;

    @PostMapping("/plan")
    public ResponseEntity<PlanEntity> createPlan(@RequestBody PlanEntity plan) {
        PlanEntity savedPlan = serv.savePlan(plan);
        return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);
    }

    @GetMapping("/plans")
    public List<PlanEntity> getAllPlans() {
        return serv.getAllPlans();
    }

    @GetMapping("/plan/{id}")
    public ResponseEntity<Optional<PlanEntity>> getPlanById(@PathVariable Long id) {
        Optional<PlanEntity> plan = serv.getPlanById(id);
        return plan.isPresent() ? new ResponseEntity<>(plan, HttpStatus.OK)
                                : new ResponseEntity<>(plan, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/plan/{id}")
    public ResponseEntity<Void> deletePlanById(@PathVariable Long id) {
        serv.deletePlanById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/plan/{id}")
    public ResponseEntity<PlanEntity> updatePlan(@PathVariable Long id, @RequestBody PlanEntity planDetails) {
        PlanEntity updatedPlan = serv.updatePlan(id, planDetails);
        return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
    }
}
