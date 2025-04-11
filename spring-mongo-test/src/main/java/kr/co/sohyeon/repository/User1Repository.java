package kr.co.sohyeon.repository;

import kr.co.sohyeon.document.User1Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User1Repository extends MongoRepository<User1Document, String> {

    public void deleteByUid(String uid);
    public boolean existsByUid(String uid);
    public Optional<User1Document> findByUid(String uid);
}
