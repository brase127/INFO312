
import dao.Member;
import dao.MembersCollectionDAO;
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
    
    public static MembersCollectionDAO mdao = new MembersCollectionDAO();
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
        
        mdao.add(member1.getMemberID(), member1);
        
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

        mdao.add(member2.getMemberID(), member2);
        
        member1.setChildren(member2);
        
        member2.setPartner(member1);
        
        //System.out.println(member1.getChildren());
        String children = "";
        for(Member c : member1.getChildren()){
            children += c.getFirstName() + ", ";
        }
        
        System.out.println(mdao);        
    }
    
}
