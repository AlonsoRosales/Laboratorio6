package com.example.lab6.Repository;

import com.example.lab6.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobReporsitory extends JpaRepository<Job,String> {
}
