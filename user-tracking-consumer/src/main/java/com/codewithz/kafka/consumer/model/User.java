package com.codewithz.kafka.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.codewithz.kafka.consumer.enums.UserId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public User(UserId userId) {
        this.userId = userId;
        this.preferences = new ArrayList<>();
        this.suggestions = new ArrayList<>();
    }

    private UserId userId;

    private List<PreferredProduct> preferences;

    private List<String> suggestions;

	public UserId getUserId() {
		return userId;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	public List<PreferredProduct> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<PreferredProduct> preferences) {
		this.preferences = preferences;
	}

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}
    
    
}
