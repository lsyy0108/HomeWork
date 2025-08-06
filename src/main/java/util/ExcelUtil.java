package util;

import java.util.List;

import model.Member;
import model.Porder;
import service.impl.MemberServiceImpl;
import service.impl.PorderServiceImpl;

public class ExcelUtil {

	public static void main(String[] args) {
		CreateExcel create=new CreateExcel();
		String[] pordeTitle=new String[] {"ID","名字","帳號","密碼","地址","電話"};
		
		create.create("Member.xls", "會員表", pordeTitle);
		
		CreateExcel create2=new CreateExcel();
		String[] pordeTitle2=new String[] {"ID","名字","肚皮舞課程","單人拉丁","芭蕾舞課程","總金額"};
		
		create2.create("Porder.xls", "周報表", pordeTitle2);
		
		/*Member m=new Member();
		
		m.setId(2);
		m.setName("teacher");
		m.setUsername("tt");
		m.setPassword("444");
		m.setAddress("台北");
		m.setPhone("0");
		
		create.insertMemberValue(m, "Member.xls", "會員表");*/
		
		/*Porder p=new Porder();
		p.setId(1);
		p.setName("teacher");
		p.setLcd(20);
		p.setRam(10);
		p.setMouse(5);
		
		create.insertPorderValue(p, "porder.xls", "周報表");*/
		
		
		List<Porder> l=new PorderServiceImpl().findAllPorder();
		
		for(Porder p:l)
		{
			create.insertPorderValue(p, "porder.xls", "周報表");
		}
		
		List<Member> q=new MemberServiceImpl().findAllMember();
		for(Member m:q)
		{
			create.insertMemberValue(m, "Member.xls", "會員表");
		}
		
		/*for(Porder p:l)
		{
			int sum=p.getLcd()*4999+p.getRam()*1280+p.getMouse()*700;
			System.out.println("id:"+p.getId()+
					"\tname:"+p.getName()+
					"\tlcd:"+p.getLcd()+
					"\tram:"+p.getRam()+
					"\tmouse:"+p.getMouse()+
					"\tsum:"+sum);
			
			
		}*/
	}

}
