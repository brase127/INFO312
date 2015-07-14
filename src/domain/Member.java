/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.*;
/**
 *
 * @author jillianmirandilla
 */

//Class Member
public class Member {
    
    private String memberID;
    private String title;
    private String firstName, lastName;
    private String occupation;
    private Member partner;
    private static Collection<Member> children = new ArrayList<>();
    
    private String homeAddress, postalAddress;
    private String phHome, phWork, phMobile;
    private String email;
    
    private String membershipType, membershipStatus;
    private int age;
    private String ethnicity;
    
    private String paymentStatus;
    private String groupsAndTeams;

    //Constructor for member object
    public Member(String memberID, String title, String firstName, String lastName, String occupation, String homeAddress, String postalAddress, String phHome, String phWork, String phMobile, String email, int age, String ethnicity, String paymentStatus, String groupsAndTeams) {
        this.memberID = memberID;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.homeAddress = homeAddress;
        this.postalAddress = postalAddress;
        this.phHome = phHome;
        this.phWork = phWork;
        this.phMobile = phMobile;
        this.email = email;
        this.age = age;
        this.ethnicity = ethnicity;
        this.paymentStatus = paymentStatus;
        this.groupsAndTeams = groupsAndTeams;
    }


    
    public Member(){
    
    }
    
    //Method to GET the TITLE of the member.
    public String getTitle() {
        return title;
    }

    //Method to SET the TITLE of the member.
    public void setTitle(String title) {
        this.title = title;
    }
    
    //Method to GET the FIRSTNAME of the member.
    public String getFirstName() {
        return firstName;
    }
    
    //Method to SET the FIRSTNAME of the member.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Method to GET the LASTNAME of the member.
    public String getLastName() {
        return lastName;
    }

    //Method to SET the LASTNAME of the member.
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Method to GET the OCCUPATION of the member.
    public String getOccupation() {
        return occupation;
    }

    //Method to SET the OCCUPATION of the member.
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
   
    //Method to GET the PARTNER of the member.
    public Member getPartner() {
        return partner;
    }
    
    //Method to SET the PARTNER of the member.
    public void setPartner(Member partner) {
        this.partner = partner;
    }
   
    //Method to GET the collection of CHILDREN of the member.
    public Collection<Member> getChildren() {
        return children;
    }
   
    //Method to ADD to the collection of CHILDREN of the member.
    public void setChildren(Member child) {
        children.add(child);
    }

    //Method to GET the HOMEADDRESS of the member.
    public String getHomeAddress() {
        return homeAddress;
    }

    //Method to SET the HOMEADDRESS of the member.
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    //Method to GET the POSTALADDRESS of the member.
    public String getPostalAddress() {
        return postalAddress;
    }

    //Method to SET the POSTALADDRESS of the member.
    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    //Method to GET the PHONEHOME of the member.
    public String getPhHome() {
        return phHome;
    }

    //Method to SET the PHONEHOME of the member.
    public void setPhHome(String phHome) {
        this.phHome = phHome;
    }

    //Method to GET the PHONEWORK of the member.
    public String getPhWork() {
        return phWork;
    }

    //Method to SET the PHONEWORK of the member.
    public void setPhWork(String phWork) {
        this.phWork = phWork;
    }

    //Method to GET the PHONEMOBILE of the member.
    public String getPhMobile() {
        return phMobile;
    }

    //Method to SET the PHONEMOBILE of the member.
    public void setPhMobile(String phMobile) {
        this.phMobile = phMobile;
    }

    //Method to GET the EMAIL of the member.
    public String getEmail() {
        return email;
    }

    //Method to SET the EMAIL of the member.
    public void setEmail(String email) {
        this.email = email;
    }

    //Method to GET the MEMBERSHIPTYPE of the member.
    public String getMembershipType() {
        return membershipType;
    }

    //Method to SET the MEMBERSHIP of the member.
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    
    //Method to GET the MEMBERSHIPSTATUS of the member.
    public String getMembershipStatus() {
        return membershipStatus;
    }

    //Method to SET the MEMBERSHIPSTATUS of the member.
    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    //Method to GET the AGE of the member.
    public int getAge() {
        return age;
    }

    //Method to SET the AGE of the member.
    public void setAge(int age) {
        this.age = age;
    }

    //Method to GET the PAYMENTSTATUS of the member.
    public String getPaymentStatus() {
        return paymentStatus;
    }

    //Method to SET the PAYMENTSTATUS of the member.
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    //Method to GET the GROUPSANDTEAMS of the member.
    public String getGroupsAndTeams() {
        return groupsAndTeams;
    }

    //Method to SET the GROUPSANDTEAMS of the member.
    public void setGroupsAndTeams(String groupsAndTeams) {
        this.groupsAndTeams = groupsAndTeams;
    }
    
    
    
}
