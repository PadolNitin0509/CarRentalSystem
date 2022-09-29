package com.Project.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.entities.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback, Integer> {

}
