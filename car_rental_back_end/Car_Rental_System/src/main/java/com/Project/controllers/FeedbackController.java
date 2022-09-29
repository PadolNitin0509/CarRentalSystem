package com.Project.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.entities.Feedback;
import com.Project.models.Response;
import com.Project.models.feedback.FeedbackDto;
import com.Project.models.feedback.FeedbackInDto;
import com.Project.services.FeedbackService;

@CrossOrigin
@RequestMapping("/feedback")
@RestController
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/")
	public ResponseEntity<?> save(FeedbackInDto feedbackDto){
		Feedback feedback = FeedbackInDto.toEntity(feedbackDto);
		feedback = feedbackService.saveFeedback(feedback);
		return Response.success(feedback);
	}
	

	
	@GetMapping("/")
	public ResponseEntity<?> findAllFeedback(){
		List<Feedback> feedbackList = feedbackService.displayAll();
		Stream<FeedbackDto> result = feedbackList.stream().map(feedback -> FeedbackDto.fromEntity(feedback));
		return Response.success(result);
	}
	
}
