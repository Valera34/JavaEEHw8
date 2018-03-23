package com.entities;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="TEACHERS")
@NamedQueries({ 
@NamedQuery(name = "findAll", query="select t from Teacher t"),
@NamedQuery(name = "findValera", query="select t from Teacher t  where t.firstname = 'Valera'"),
@NamedQuery(name = "findWithParam", query="select t from Teacher t where t.id = :fid")
})
public class Teacher {
@Id
@GeneratedValue
private int teacherId; 

@Column(name="firstname")
private String firstname;
     
@Column(name="lastname")
private String lastname;
     
@Column(name="birth_date")
private Date birthDate;
    
@Column(name="cell_phone")
private String cellphone;

public int getTeacherId() {
    return teacherId;
}
public void setTeacherId(  int teacherId) {
    this.teacherId = teacherId;
}
public String getFirstname() {
    return firstname;
}
public void setFirstname(  String firstname) {
    this.firstname = firstname;
}
public String getLastname() {
    return lastname;
}
public void setLastname(  String lastname) {
    this.lastname = lastname;
}
public Date getBirthDate() {
    return birthDate;
}
public void setBirthDate( Date birthDate) {
    this.birthDate = birthDate;
}
public String getCellphone() {
    return cellphone;
}
public void setCellphone(  String cellphone) {
    this.cellphone = cellphone;
}
public String toString() {
	String result=teacherId+" "+firstname+" "+lastname+" "+birthDate+" "+cellphone;
	return result;
}
}
