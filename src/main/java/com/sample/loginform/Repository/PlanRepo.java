package com.sample.loginform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.loginform.Entity.PlanEntity;

@Repository
public interface PlanRepo extends JpaRepository<PlanEntity,Long>{

}
