package com.jspiders.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jspiders.springboot.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

	Optional<Job> findById(Integer id);

	void deleteById(Integer id);

	@Query("SELECT j FROM Job j WHERE "
			+ "LOWER(CONCAT(j.jobProfile, ' ', j.jobDescription, ' ', j.reqExperience,' ', j.reqSkills)) Like %:keyword%")

	List<Job> search(String keyword);
}
