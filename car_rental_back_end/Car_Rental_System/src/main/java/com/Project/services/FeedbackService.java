package com.Project.services;

import java.util.List;

import com.Project.entities.Feedback;

public interface FeedbackService {
	Feedback saveFeedback(Feedback feedback);
	
	List<Feedback> displayAll();
	

	
}
