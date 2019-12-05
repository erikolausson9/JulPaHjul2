package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberRepository {

    @Autowired
    DataSource dataSource;

    private List<Member> members;

    public MemberRepository () {
        members = new ArrayList<>();
    }

    public Member rsMember(ResultSet rs) throws SQLException{
        Member member = new Member();
        member.setId(rs.getInt("MedlemsId"));
        member.setAnvandarNamn(rs.getString("AnvandarNamn"));
        member.setLosenord(rs.getString("Losenord"));
        member.setEmailAdress(rs.getString("EmailAdress"));

        return member;
    }

    public void addMember(Member memberToAdd) {
        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Medlem(AnvandarNamn, Losenord, EmailAdress) VALUES(?, ?, ?)")) {
            ps.setString(1, memberToAdd.getAnvandarNamn());
            ps.setString(2, memberToAdd.getLosenord());
            ps.setString(3, memberToAdd.getEmailAdress());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

   public List<Member> getMembers(){
       try (Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Member")){
           while(rs.next()){
               members.add(rsMember(rs));
           }
       }
       catch(SQLException e){
           e.printStackTrace();
       }

       return members;
   }
}
