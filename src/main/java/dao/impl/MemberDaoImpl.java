package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao {

    private Connection conn;
    
    public MemberDaoImpl() {
        this.conn = DbConnection.getDb();
    }

    public static void main(String[] args) {
        System.out.println(new MemberDaoImpl().select("qqwe", "1234"));
    }

    private static List<Member> members = new ArrayList<>();

    @Override
    public void add(Member member) {
        String sql = "insert into member(name, username, password, address, phone) values (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getName());
            ps.setString(2, member.getUsername());
            ps.setString(3, member.getPassword());
            ps.setString(4, member.getAddress());
            ps.setString(5, member.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Member select(String username, String password) {
        Member member = null;
        String sql = "select * from member where username=? and password=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    member = new Member();
                    member.setId(rs.getInt("id"));
                    member.setName(rs.getString("name"));
                    member.setUsername(rs.getString("username"));
                    member.setPassword(rs.getString("password"));
                    member.setAddress(rs.getString("address"));
                    member.setPhone(rs.getString("phone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public Member select(String username) {
        Member member = null;
        String sql = "select * from member where username=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    member = new Member();
                    member.setId(rs.getInt("id"));
                    member.setName(rs.getString("name"));
                    member.setUsername(rs.getString("username"));
                    member.setPassword(rs.getString("password"));
                    member.setAddress(rs.getString("address"));
                    member.setPhone(rs.getString("phone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public boolean updateMember(Member member) {
        String sql = "update member set password=? where username=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getPassword());
            ps.setString(2, member.getUsername());
            int rows = ps.executeUpdate();
            return rows > 0; // 回傳是否更新成功
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMember(Member member) {
        String sql = "delete from member where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, member.getId());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteMember(String username) {
        String sql = "delete from member where username = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public List<Member> selectAll() {
		String sql="select * from member";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Member member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("Password"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				
				l.add(member);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}
}
