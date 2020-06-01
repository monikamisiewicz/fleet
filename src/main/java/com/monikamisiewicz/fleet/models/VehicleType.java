package com.monikamisiewicz.fleet.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
//generate implementations of the equals(Object other) and hashCode() methods
//By setting callSuper to true, you can include the equals and hashCode methods of your superclass in the generated methods.
//Normally, auto-generating hashCode and equals implementations in a subclass is a bad idea
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleType extends CommonObject {

}