/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author brase127
 */
public class MembersCollectionDAO implements MemberDAO{
    
    Map<String, Member> memberCollection = new TreeMap<>();


    public void add(String id, Member member) {
        memberCollection.put(id, member); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        memberCollection.remove(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(String id, Member member) {
        memberCollection.replace(id, member); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map getMembers() {
        return memberCollection; //To change body of generated methods, choose Tools | Templates.
    }

}
