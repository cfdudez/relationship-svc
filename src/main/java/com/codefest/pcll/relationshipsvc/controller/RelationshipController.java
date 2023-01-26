package com.codefest.pcll.relationshipsvc.controller;

import com.codefest.pcll.relationshipsvc.model.Relationship;
import com.codefest.pcll.relationshipsvc.repo.RelationshipRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class RelationshipController {

    @Autowired
    RelationshipRepo repo;
    @GetMapping("/")
    public ResponseEntity<List<Relationship>> findRelationships(@RequestParam String searchName){
        List<Relationship> finalList = new ArrayList<Relationship>();
        List<Relationship> relationshipList = repo.findRelationshipByName(searchName);
        System.out.println(relationshipList);
        for (Relationship e:relationshipList){
            finalList.add(e);
            lookupChildren(e,finalList);
        }
        return new ResponseEntity<>(finalList, HttpStatus.OK);
    }

    public void lookupChildren(Relationship r,List<Relationship> list){
        List<Relationship> lookupList = repo.findRelationshipByName(r.getParentName());
        System.out.println(lookupList);
        for(Relationship l:lookupList){
            if(list.contains(l)){
                return;
            }
            list.add(l);
            lookupChildren(l,list);
        }
    }
}
