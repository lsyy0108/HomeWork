package service;

import java.util.List;

import model.Member;

public interface MemberService {
	//create
	boolean addMember(Member member);//判斷帳號+新增
	
	
	//read
	Member login(String username,String password);//登入
	List<Member> findAllMember();
	//update
	boolean updateMember(Member member);
	//delete
	boolean deleteMember(Member member); 
    boolean deleteMember(String username);

}