package com.sample.loginform.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String description;
	    private Double price;
	    private Integer dataLimit;  
	    private Integer callMinutes;
	    private Integer smsLimit;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public Integer getDataLimit() {
			return dataLimit;
		}
		public void setDataLimit(Integer dataLimit) {
			this.dataLimit = dataLimit;
		}
		public Integer getCallMinutes() {
			return callMinutes;
		}
		public void setCallMinutes(Integer callMinutes) {
			this.callMinutes = callMinutes;
		}
		public Integer getSmsLimit() {
			return smsLimit;
		}
		public void setSmsLimit(Integer smsLimit) {
			this.smsLimit = smsLimit;
		}
		
	    
}
