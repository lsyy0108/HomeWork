package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao{

	public static void main(String[] args) {
		/*Porder p=new Porder("eee",1,4,2);
		new PorderDaoImpl().add(p);*/
	//	System.out.println(new PorderDaoImpl().selectAll());
		/*List<Porder> l=new PorderDaoImpl().selectAll();
		int sum=0;
		int count=0;
		for(Porder o:l)
		{
			System.out.println(o.getId()+"\t"+o.getName()+"\tlcd:"+o.getLcd());
			sum=sum+o.getLcd();
			count++;
			
		}
		System.out.println("筆數:"+count+"\tlcd共="+sum);*/
			/*Porder p=new PorderDaoImpl().selectById(5);
			
			
			new PorderDaoImpl().delete(p);*/
		
				
			}
	private Porder mapRowToPorder(ResultSet rs) throws SQLException {
	    Porder porder = new Porder();
	    porder.setId(rs.getInt("id"));           
	    porder.setName(rs.getString("name"));    
	    porder.setLcd(rs.getInt("lcd"));         
	    porder.setRam(rs.getInt("ram"));         
	    porder.setMouse(rs.getInt("mouse"));     
	    return porder;
	}
	private static Connection conn=DbConnection.getDb();
	@Override
	public void add(Porder porder) {
		String Sql="insert into porder(name,lcd,ram,mouse) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1,porder.getName());
			ps.setInt(2,porder.getLcd());
			ps.setInt(3,porder.getRam());
			ps.setInt(4,porder.getMouse());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Porder> selectAll() {
		String sql="select * from porder";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Porder p=new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setLcd(rs.getInt("lcd"));
				p.setRam(rs.getInt("ram"));
				p.setMouse(rs.getInt("mouse"));
				
				l.add(p);
			
			
			}
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public Porder selectById(int id) {
		String sql="select * from porder where id=?";
Porder p=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				p=new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setLcd(rs.getInt("lcd"));
				p.setRam(rs.getInt("ram"));
				p.setMouse(rs.getInt("mouse"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return p;
	}

	@Override
	public void update(Porder porder) {
		String sql="update porder set lcd=?,ram=?,mouse=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, porder.getLcd());
			ps.setInt(2, porder.getRam());
			ps.setInt(3, porder.getMouse());
			ps.setInt(4, porder.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void delete(Porder porder) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, porder.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}