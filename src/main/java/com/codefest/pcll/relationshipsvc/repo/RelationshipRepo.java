package com.codefest.pcll.relationshipsvc.repo;

import com.codefest.pcll.relationshipsvc.model.Relationship;
import com.codefest.pcll.relationshipsvc.model.RelationshipKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RelationshipRepo extends JpaRepository<Relationship, RelationshipKey>,
        JpaSpecificationExecutor<Relationship>, QueryByExampleExecutor<Relationship> {
    public List<Relationship> findRelationshipByName(String name);
}
