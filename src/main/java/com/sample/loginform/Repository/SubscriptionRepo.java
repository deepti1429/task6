package com.sample.loginform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.loginform.Entity.Subscription;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription,Long>{

}
