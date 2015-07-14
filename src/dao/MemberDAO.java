/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Map;

/**
 *
 * @author jillianmirandilla
 */
public interface MemberDAO {
    public void add(String id, Member member);
    
    public void delete (String id);
    
    public void edit(String id, Member memver);
    
    public Map getMembers();
}
