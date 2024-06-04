package com.sample.loginform.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.loginform.Entity.Subscription;
import com.sample.loginform.Repository.SubscriptionRepo;

@Service
public class SubscriptionService {

	@Autowired
	public SubscriptionRepo repo;
	
	public Subscription createSubscription(Subscription subscription) {
        return repo.save(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return repo.findAll();
    }

    public Optional<Subscription> getSubscriptionById(Long id) {
        return repo.findById(id);
    }

    public Subscription updateSubscription(Long id, Subscription subscriptionDetails) {
        Subscription subscription = repo.findById(id).orElseThrow(() -> new RuntimeException("Subscription not found"));
        subscription.setCustomer(subscriptionDetails.getCustomer());
        subscription.setPlan(subscriptionDetails.getPlan());
        subscription.setStartDate(subscriptionDetails.getStartDate());
        subscription.setEndDate(subscriptionDetails.getEndDate());
        subscription.setStatus(subscriptionDetails.getStatus());
        return repo.save(subscription);
    }

    public void deleteSubscription(Long id) {
        repo.deleteById(id);
    }
}