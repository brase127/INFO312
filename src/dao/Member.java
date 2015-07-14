/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.*;
/**
 *
 * @author jillianmirandilla
 */
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Member getPartner() {
        return partner;
    }

    public void setPartner(Member partner) {
        this.partner = partner;
    }

    public Collection<Member> getChildren() {
        return children;
    }

    public void setChildren(Member child) {
        children.add(child);
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPhHome() {
        return phHome;
    }

    public void setPhHome(String phHome) {
        this.phHome = phHome;
    }

    public String getPhWork() {
        return phWork;
    }

    public void setPhWork(String phWork) {
        this.phWork = phWork;
    }

    public String getPhMobile() {
        return phMobile;
    }

    public void setPhMobile(String phMobile) {
        this.phMobile = phMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getGroupsAndTeams() {
        return groupsAndTeams;
    }

    public void setGroupsAndTeams(String groupsAndTeams) {
        this.groupsAndTeams = groupsAndTeams;
    }
    
    
    
}
