package com.codefest.pcll.relationshipsvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelationshipKey implements Serializable {
    private String name;
    private String parentName;
}
