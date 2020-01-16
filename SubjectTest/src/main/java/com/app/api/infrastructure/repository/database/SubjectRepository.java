package com.app.api.infrastructure.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.app.api.infrastructure.dto.SubjectDto;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectDto, String> {

}
