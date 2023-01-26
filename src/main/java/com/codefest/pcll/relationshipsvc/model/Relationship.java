package com.codefest.pcll.relationshipsvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name="relationships")
@IdClass(RelationshipKey.class)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Relationship {
    @Id
    @Column(name="name")
    String name;
    @Id
    @Column(name="parentName")
    String parentName;
    @Column(name="type")
    String type;
    @Column(name="parentType")
    String parentType;
    @Column(name="serviceEmail")
    String serviceEmail;

}
