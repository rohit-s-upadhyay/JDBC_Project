import java.util.*;
import java.sql.*;

public class demo {
	public static void insertIntoLatestCar()
	{
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			
			 System.out.println("Enter Latest CarNo");
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
				
				System.out.println();
				System.out.println("Record Inserted Successfully");
				System.out.println();
				main(null);
//				System.out.println("Press Any Button For Main Page");
//				System.out.println();
//				System.out.println("To Exit Press => 0]");
//				try {
//				int m = sc.nextInt();
//				
//				switch(m)
//				{
//				case 0:System.out.println("Thank You For Coming");
//				       System.exit(10);
//				default:main(null);
//						break;
//				}
//				}catch(InputMismatchException e)
//				{
//					System.err.println("   INVALID INPUT");
//					main(null);
//					return;
//				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			main(null);
			return;
		}
	}
	
	public static void insertIntoCar()
	{
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			
			 System.out.println("Enter CarNo");
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
				
				System.out.println();
				System.out.println("Record Inserted Successfully");
				System.out.println();
				
				main(null);
//				System.out.println("For HomePage Press => 1]");
//				System.out.println();
//				System.out.println("To Exit Press => 0]");
//				int m = sc.nextInt();
//				
//				switch(m)
//				{
//				case 0:System.out.println("Thank You For Coming");
//				       System.exit(10);
//				case 1:main(null);
//						break;
//				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public static void showCollectionOfLatestCar()
	{
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			
			PreparedStatement pstmt4 = con.prepareStatement("insert into latestcar.latestcar values(?,?,?,?)");
			ResultSet rs = pstmt4.executeQuery("select * from latestcar.latestcar");
			
			//System.out.println("Enter LatestCar No");
			//int id = sc.nextInt();
			
			int count =0;
			System.out.println("The LatestCar Collection is:-");
			while(rs.next())
			{
				int lcno = rs.getInt(1);
				//if(id==lcno)
				//{
					System.out.print(lcno+" ");
					String lcname = rs.getString(2);
					System.out.print(lcname+" ");
					String lccolor = rs.getString(3);
					System.out.print(lccolor+" ");
					String lcmodel = rs.getString(4);
					System.out.print(lcmodel+" ");
					System.out.println();
					count++;
			//	}
				
			}
			main(null);
			if(count==0)
			{
				System.err.println("There Are No LatestCars");
				System.out.println();
				main(null);
			}
				//System.out.println();
				//main(null);
				
//				System.out.println("For HomePage Press => 1]");
//				System.out.println();
//				System.out.println("To Exit Press => 0]");
//				int m = sc.nextInt();
//				
//				switch(m)
//				{
//				case 0:System.out.println("Thank You For Coming");
//				       System.exit(10);
//				case 1:main(null);
//						break;
//				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public static void showCollection()
	{
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			
			PreparedStatement pstmt5 = con.prepareStatement("insert into cars.cars values(?,?,?,?)");
			
			System.out.println();
			System.out.println("For Car Collection       => 1]");
			System.out.println();
			System.out.println("For LatestCar Collection => 2]");
			try {
			int m = sc.nextInt();
			
			switch(m)
			{
			case 1:	ResultSet rs2 = pstmt5.executeQuery("select * from cars.cars");
//					System.out.println("For Specific Car Details    => 1]");
//					System.out.println();
//					System.out.println("For Entire Car Collection   => 2]");
//					try {
//					int a = sc.nextInt();
//					
//					switch(a)
//					{
//					case 1: demo.specificCar();
//							break;
							
					//case 2:	
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
							main(null);
//							break;
//					default:System.err.println("    INVALID INPUT    ");
//							showCollection();
//							break;
//					}
//					}catch(InputMismatchException e)
//					{
//						System.err.println("    INVALID INPUT");
//						showCollection();
//						return;
//					}
							break;
					case 2:	ResultSet rs3 = pstmt5.executeQuery("select * from latestcar.latestcar");
			
//							System.out.println("For Specific Car Details    => 1]");
//							System.out.println();
//							System.out.println("For Entire Car Collection   => 2]");
//							try {
//							int a=sc.nextInt();
							//switch(a)
							//{
//							case 1: demo.specificLatestCar();
//									break;
							//case 2:	
								System.out.println("Collection Of LatestCar:-");
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
//									break;
//							default:System.err.println("   INVALID INPUT");
//									showCollection();
//							}
//							}catch(InputMismatchException e)
//							{
//								System.err.println("    INVALID INPUT");
//								showCollection();
//								return;
//							}
					default:System.out.println();
							System.err.println("    INVALID INPUT  ");	
							showCollection();
							break;
			}
			}catch(InputMismatchException e)
			{
				System.out.println();
				System.err.println("   INVALID INPUT");
				showCollection();
				return;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
			System.out.println("    INVALID INPUT");
			showCollection();
			return;
		}

		
	}
	public static void specificCar()
	{
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			
			PreparedStatement pstmt5 = con.prepareStatement("insert into cars.cars values(?,?,?,?)");
			
			ResultSet rs2 = pstmt5.executeQuery("select * from cars.cars");
			
			System.out.println("Enter Car No");
			int id = sc.nextInt();
			
			int count =0;
			//System.out.println("The Car Collection is:-");
			while(rs2.next())
			{
				int lcno = rs2.getInt(1);
				if(id==lcno)
				{	
					System.out.println("The Car Collection is:-");

					System.out.print(lcno+" ");
					String lcname = rs2.getString(2);
					System.out.print(lcname+" ");
					String lccolor = rs2.getString(3);
					System.out.print(lccolor+" ");
					String lcmodel = rs2.getString(4);
					System.out.print(lcmodel+" ");
					System.out.println();
					count++;
				}
			}
			if (count==0)
			{
				System.out.println("Invalid CarNo");
				specificCar();
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void specificLatestCar()
	{
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			
			PreparedStatement pstmt = con.prepareStatement("insert into latestcar.latestcar values(?,?,?,?)");
			
			ResultSet rs2 = pstmt.executeQuery("select * from latestcar.latestcar");
			
			System.out.println("Enter LatestCar no");
			int id =sc.nextInt();
			int count=0;
			while(rs2.next())
			{
				int Cno = rs2.getInt(1);
				//System.out.print(Cno+" ");
				if(id==Cno)
				{
					System.out.println("The LatestCar Collection is:-");

					System.out.print(Cno+" ");
					String lcname = rs2.getString(2);
					System.out.print(lcname+" ");
					String lccolor = rs2.getString(3);
					System.out.print(lccolor+" ");
					String lcmodel = rs2.getString(4);
					System.out.print(lcmodel+" ");
					System.out.println();
					count++;
				}
			}
			if(count==0)
			{
				System.err.println("   INVALID INPUT  ");
				specificLatestCar();
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteLatestCar()
	{
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
			
			PreparedStatement pstmt = con.prepareStatement("delete from latestcar.latestcar where Cno=?");
			
			System.out.println("Enter LatestCar No");
			int n =sc.nextInt();
			
			ResultSet rs =pstmt.executeQuery("select * from latestcar.latestcar");
			if(rs.next())
			{
				int m = rs.getInt(1);
				if(n==m)
				{
					pstmt.setInt(1,n);
					pstmt.executeUpdate();
					System.out.println();
					System.out.println("Record Deleted Successfully");
				}else {
					System.err.println("This LatestCar No is Not In The DB");
					System.out.println();
					deleteLatestCar();
					return;
				}
			}		
			System.out.println();
			main(null);
//			System.out.println("Press Any No to Go Back");
//			System.out.println();
//			System.out.println("Press 0 To Exit");
//			try {
//			int m=sc.nextInt();
//			switch(m)
//			{
//			case 0:System.out.println("Thank You");
//			       System.exit(10);
//			       break;
//			default:main(null);
//					break;
//			}
//			}catch(InputMismatchException e)
//			{
//				System.out.println("   INVALID INPUT  ");
//				main(null);
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----------------------Welcome to Car World----------------------");
//		System.out.println();
//		System.out.println();
//		System.out.println();
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
			case 1: demo.insertIntoLatestCar();
					break;
			case 2:demo.insertIntoCar();
					break;
			case 3:	System.out.println("Record Updated Successfully");
					System.out.println();
			        main(null);
					break;
			case 4:demo.showCollectionOfLatestCar();
					break;
			case 5:showCollection();
					break;
			case 6:	deleteLatestCar();
					break;
			default:System.err.println("     INVALID INPUT     ");
			        main(null);
			        break;
		}
		}catch(InputMismatchException e)
		{
			System.err.println("     Please Enter Given Input      ");
			main(null);
		}
		
	}
}
