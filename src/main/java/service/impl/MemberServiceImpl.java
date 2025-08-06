package service.impl;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;
import util.DbConnection;
import dao.MemberDao;
import java.sql.Connection;
import java.util.List;


public class MemberServiceImpl implements MemberService{
	private MemberDao memberDao = new MemberDaoImpl();
	private MemberDao dao;
	public MemberServiceImpl() {
        dao = new MemberDaoImpl();
    }

	public static void main(String[] args) {
		
		
		

	}

	private static MemberDaoImpl mdi=new MemberDaoImpl();
	
	
	@Override
	public boolean addMember(Member member) {
		/*
		 * 1.判斷帳號重複->null
		 * 2.null-->註冊-->true-->成功
		 * 3.!=null-->重複-->false-->失敗
		 */
		boolean isUsernameBeenUse=false;
		Member m=mdi.select(member.getUsername());
		if(m==null)
		{
			mdi.add(member);
			isUsernameBeenUse=true;
		}
				
		return isUsernameBeenUse;
	}

	@Override
	public Member login(String username, String password) {
		return memberDao.select(username, password);
	}

	@Override
	public boolean updateMember(Member member) {
		Member m = mdi.select(member.getUsername());
		  boolean username=false;
		  if(m!=null)
		  {
		   mdi.updateMember(member);
		   username=true;
		  }
		  return username;
		 
	}


	@Override
	public boolean deleteMember(Member member) {
		return dao.deleteMember(member);
	}

	@Override
	public boolean deleteMember(String username) {
		return dao.deleteMember(username);
	}

	@Override
	public List<Member> findAllMember() {
			// TODO Auto-generated method stub
			return mdi.selectAll();
	}
	

}