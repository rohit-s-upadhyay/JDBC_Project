import java.util.*;
import java.sql.*;

public class CarWorld {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			
			System.out.println("-----------------------Welcome to Car World----------------------");
//			System.out.println();
//			System.out.println();
//			System.out.println();
			System.out.println();
			System.out.println("1] => Insert records in Latest Car");
			System.out.println("2] => Insert records in Cars");
			System.out.println("3] => Update record in Both Tables");
			System.out.println("4] => Show Collection of Latest Car");
			System.out.println("5] => Show Collection of Car and Latest Car");
			System.out.println("6] => Delete from Latest Car");
			try {
			int n = sc.nextInt();
			
			switch(n)
			{		
			case 1: System.out.println("Enter Latest CarNo");
					int lcNo = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Latest Car Name");
					String lcName = sc.nextLine();
					System.out.println("Enter Latest Car Color");
					String lcColor = sc.nextLine();
					System.out.println("Enter Latest Car Model");
					String lcModel = sc.nextLine();
					
					PreparedStatement pstmt = con.prepareStatement("insert into latestcar.latestcar values(?,?,?,?)");
					
					pstmt.setInt(1,lcNo);
					pstmt.setString(2, lcName);
					pstmt.setString(3, lcColor);
					pstmt.setString(4, lcModel);
					pstmt.executeUpdate();
					
					main(null);
					break;
					
			case 2:	 System.out.println("Enter CarNo");
					int cNo = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter CarName");
					String cName = sc.nextLine();
					System.out.println("Enter CarColor");
					String cColor = sc.nextLine();
					System.out.println("Enter CarModel");
					String cModel = sc.nextLine();
					
					PreparedStatement pstmt2 = con.prepareStatement("insert into cars.cars values(?,?,?,?)");
					pstmt2.setInt(1,cNo);
					pstmt2.setString(2, cName);
					pstmt2.setString(3, cColor);
					pstmt2.setString(4, cModel);
					pstmt2.executeUpdate();
					
					main(null);
					break;
					
			case 3: System.out.println("To Update Car       => 1]");
					System.out.println();
					System.out.println("To Update LatestCar => 2]");
					System.out.println();
					try {
					int no=sc.nextInt();
					switch(no) {
							case 1:System.out.println("Enter CarNo to Update");
									int lcNoUp = sc.nextInt();
									sc.nextLine();
									
									System.out.println("Enter Car Name to Update");
									String lcNameUp = sc.nextLine();
									
									System.out.println("Enter Car Color to Update");
									String lcColorUp = sc.nextLine();
									
									System.out.println("Enter Car Model to Update");
									String lcModelUp = sc.nextLine();
									
									PreparedStatement pstmt3 = con.prepareStatement("update cars.cars set Cname=? , Ccolor=? , Cmodel=? where Cno=?");
									PreparedStatement pstmt4 = con.prepareStatement("update latestcar.latestcar set Cname=? , Ccolor=? , Cmodel=? where Cno=?");
									
									pstmt3.setString(1, lcNameUp);
									pstmt3.setString(2, lcColorUp);
									pstmt3.setString(3, lcModelUp);
									pstmt3.setInt(4,lcNoUp);
									
									pstmt3.executeUpdate();
									
									pstmt4.setString(1, lcNameUp);
									pstmt4.setString(2, lcColorUp);
									pstmt4.setString(3, lcModelUp);
									pstmt4.setInt(4,lcNoUp);
									
									pstmt4.executeUpdate();
									main(null);
									break;
								
							case 2:System.out.println("Enter CarNo to Update");
									int Cno = sc.nextInt();
									sc.nextLine();
									
									System.out.println("Enter Car Name to Update");
									String lCNameUp = sc.nextLine();
									
									System.out.println("Enter Car Color to Update");
									String lCColorUp = sc.nextLine();
									
									System.out.println("Enter Car Model to Update");
									String lCModelUp = sc.nextLine();
									
									PreparedStatement pstmtlc = con.prepareStatement("update latestcar.latestcar set Cname=? , Ccolor=? , Cmodel=? where Cno=?");
									
									pstmtlc.setString(1, lCNameUp);
									pstmtlc.setString(2, lCColorUp);
									pstmtlc.setString(3, lCModelUp);
									pstmtlc.setInt(4,Cno);
									
									pstmtlc.executeUpdate();
									System.out.println("Record Updated Succesfully");
									main(null);
									break;
							default:System.err.println("Invali Input");
									main(null);
									break;
					}
					}catch(InputMismatchException e)
					{
						System.err.println("Inavlid Input");
						main(null);
						return;
					}
					break;
					
			case 4: PreparedStatement pstmt4 = con.prepareStatement("insert into cars.cars values(?,?,?,?)");
					ResultSet rs = pstmt4.executeQuery("select * from latestcar.latestcar");
					
					System.out.println("Collection of Latest Car");
					while(rs.next())
					{
						int lcno = rs.getInt(1);
						System.out.print(lcno+" ");
						String lcname = rs.getString(2);
						System.out.print(lcname+" ");
						String lccolor = rs.getString(3);
						System.out.print(lccolor+" ");
						String lcmodel = rs.getString(4);
						System.out.print(lcmodel+" ");
						System.out.println();
					}
					main(null);
					break;
					
			case 5: PreparedStatement pstmt5 = con.prepareStatement("insert into cars.cars values(?,?,?,?)");
					ResultSet rs2 = pstmt5.executeQuery("select * from cars.cars");
					
					System.out.println("-----Collection Of Car-----");
					while(rs2.next())
					{
						int cno = rs2.getInt(1);
						System.out.print(cno+" ");
						String cname =rs2.getString(2);
						System.out.print(cname+" ");
						String ccolor = rs2.getString(3);
						System.out.print(ccolor+" ");
						String cmodel = rs2.getString(4);
						System.out.print(cmodel+" ");
						System.out.println();
					}
					System.out.println();
					ResultSet rs3 = pstmt5.executeQuery("select * from latestcar.latestcar");
					
					System.out.println("-----Collection of Latest Car-----");
					while(rs3.next())
					{
						int lcno = rs3.getInt(1);
						System.out.print(lcno+" ");
						String lcname = rs3.getString(2);
						System.out.print(lcname+" ");
						String lccolor = rs3.getString(3);
						System.out.print(lccolor+" ");
						String lcmodel = rs3.getString(4);
						System.out.print(lcmodel+" ");
						System.out.println();
					}
					main(null);
					break;
					
			case 6: PreparedStatement pstmt6 = con.prepareStatement("delete from latestcar.latestcar where Cno=?");
					System.out.println("Enter LatestCar No to Delete");
					int Cno = sc.nextInt();
					pstmt6.setInt(1, Cno);
					
					pstmt6.executeUpdate();
					main(null);
					break;
					
			default:System.err.println("Invalid Input");		
					main(null);
					break;
					
			}
			}
			catch(Exception e)
			{
				System.err.println("Invalid Input");
				main(null);
			}
		
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
