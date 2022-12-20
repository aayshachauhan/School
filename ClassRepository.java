package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.school.entity.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long>{


}
