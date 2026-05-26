package org.technew.linkedin2.controllers.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.technew.linkedin2.services.jobs.DTOs.JobDTO;
import org.technew.linkedin2.services.jobs.JobsService;
@RequiredArgsConstructor
@RestController
@RequestMapping("/enterprise/jobs")
public class JobsController {
    private final JobsService jobsService;

    @PostMapping
    public ResponseEntity<Void> newJob(@RequestBody JobDTO jobDTO){
        jobsService.newJob(jobDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
