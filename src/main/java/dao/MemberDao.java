package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	//create
	void add(Member member);
	
	//read
	Member select(String username,String password);
	Member select(String username);
	List<Member> selectAll();
	//update
	boolean updateMember(Member member);

	
	
	//delete
	boolean deleteMember(Member member); 
    boolean deleteMember(String username);
}
