package com.example.DailyPe.dailype.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DailyPe.dailype.Models.Manager;
@Repository
public interface ManagerRepository extends	JpaRepository<Manager, UUID> {

}
