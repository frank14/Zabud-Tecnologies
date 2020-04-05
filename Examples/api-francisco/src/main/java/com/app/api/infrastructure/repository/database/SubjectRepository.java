package com.app.api.infrastructure.repository.database;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.api.infrastructure.dto.SubjectDto;
@Repository
public interface SubjectRepository extends MongoRepository<SubjectDto, String> {

}
