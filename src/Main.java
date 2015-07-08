
import domain.*;
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jillianmirandilla
 */
public class Main {
    /* Test of MemberDAO and Member -- Not finished yet*/
    public static void main(String[] args){
        Member member1;
        member1 = new Member(
         "43535",
         "Mr",
         "Chris",
         "Evans",
         "Gym Instructor",
         "4 Abbey Road",
         null,
         "554-4534",
         "471-3523",
         "0204534523",
         "cevans@gmail.com",
         34,
         "American",
         "paid", "none");
        
        Member member2 = new Member(
         "45467",
         "Ms",
         "Lily",
         "Evans",
         "Student",
         "4 Abbey Road",
         null,
         "554-4534",
         null,
         "0204534523",
         "levans@gmail.com",
         10,
         "American Chinese",
         "paid", "none");
        
         Member member3 = new Member(
         "44543",
         "Mr",
         "James",
         "Evans",
         "Student",
         "4 Abbey Road",
         null,
         "554-4534",
         null,
         "0204534523",
         "jevans@gmail.com",
         15,
         "American Chinese",
         "paid", "none");
         
         Member member4 = new Member(
         "43463",
         "Mrs",
         "Elizabeth",
         "Evans",
         "Accountant",
         "4 Abbey Road",
         null,
         "554-4534",
         "342-4352",
         "0204534523",
         "elizabethevans@gmail.com",
         33,
         "Chinese",
         "paid", "none");
        
         
         Member member5 = new Member(
         "654656",
         "Mr",
         "DJ",
         "Crawford",
         "Doctor",
         "71 Carrol St",
         null,
         "554-4534",
         "342-4352",
         "0204534523",
         "djpadilla@gmail.com",
         50,
         "Chinese",
         "paid", "none");
         
         Member member6 = new Member(
         "654656",
         "Mr",
         "Billy",
         "Crawford",
         "Dancer",
         "71 Carrol St",
         null,
         "554-4534",
         "342-4352",
         "0204534523",
         "billycrawford@gmail.com",
         22,
         "Chinese",
         "paid", "none");
        
        member1.setChildren(member2);
        member1.setChildren(member3);
        member1.setPartner(member4);
        
        member4.setPartner(member1);
        
        //System.out.println(member1.getChildren());
        String children = "";
        for(Member c : member4.getChildren()){
            children += c.getFirstName() + ", ";
        }
        
        System.out.println(children);
        System.out.println(member4.getPartner().getFirstName());
        
    }
    
}
