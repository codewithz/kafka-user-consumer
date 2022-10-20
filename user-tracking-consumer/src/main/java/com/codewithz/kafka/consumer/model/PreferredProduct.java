package com.codewithz.kafka.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PreferredProduct {

    private String color;

    private String type;

    private String designType;

	public PreferredProduct(String color, String type, String designType) {
		super();
		this.color = color;
		this.type = type;
		this.designType = designType;
	}

	public PreferredProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesignType() {
		return designType;
	}

	public void setDesignType(String designType) {
		this.designType = designType;
	}
    
    

}
