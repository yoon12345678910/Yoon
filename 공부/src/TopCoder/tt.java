package TopCoder;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

public class tt {

	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studydb", "study", "study");

			stmt = con.createStatement();

			loop: while (true) {

				String[] token = command();
				switch (token[0]) {
				case "add":
					add();
					break;

				case "list":
					list();
					break;

				case "delete":
					delete(Integer.parseInt(token[1]));
					break;

				case "update":
					update(Integer.parseInt(token[1]));
					break;

				case "exit":
					exit();
					break loop;

				default:
					System.out.println("이 명령어를 지원하지 않습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
		}

	}

	private static void exit() {

		try {

			stmt.execute("exit");

		} catch (SQLException e) {
		}

	}

	public static void delete(int index) throws SQLException {
		String pname = null;
		rs = stmt.executeQuery("SELETE from PRODUCTS where PNO = " + index);
		
		while(rs.next()){
			 pname = rs.getString(2);
		}
		
		System.out.printf("\"%s\"를 삭제하시겠습니까?(Y/N)", pname);

		if (scanner.nextLine().equalsIgnoreCase("y")) {

			rs = stmt.executeQuery("DELETE from PRODUCTS where PNO = " + index);

		} else {

			System.out.println("삭제가 취소되엇씁니다.");

		}

	}

	public static void update(int index) throws Exception {

		rs = stmt.executeQuery("SELECT * from PRODUCTS where PNO = " + index);

		if (rs.next()) {

			System.out.printf("제품명(%s) : ", rs.getString(2));

			String pname = scanner.nextLine();

			if (pname.equals("")) {

				pname = rs.getString(2);

			}

			System.out.printf("수량(%s) : ", rs.getString(1));

			String qty = scanner.nextLine();

			if (qty.equals("")) {

				qty = rs.getString(1);

			}

			System.out.printf("제조사(%s) : ", rs.getString(4));

			String mkno = scanner.nextLine();

			if (mkno.equals("")) {

				mkno = rs.getString(4);

			}

			System.out.print("변경하시겠습니까?(Y/N)");

			if (scanner.nextLine().equalsIgnoreCase("y")) {

				try {

					stmt.executeUpdate("update PRODUCTS set " +

					" PNAME='" + rs.getString(2) + "'," +

					" QTY=" + Integer.parseInt(rs.getString(1)) +

					" where PNO = " + Integer.parseInt(rs.getString(4)));

				} catch (SQLException e) {

					e.printStackTrace();

				}

			} else {

				System.out.println("변경을 취소하였습니다.");
			}
		}
	}

	public static void add() {

		System.out.print("제품명 : ");
		String pname = scanner.nextLine();
		System.out.print("수량 : ");
		String qty = scanner.nextLine();
		System.out.print("제조사 : ");
		String mkno = scanner.nextLine();

		System.out.print("저장하시겠습니까?(Y/N)");
		if (scanner.nextLine().equalsIgnoreCase("y")) {

			try {

				stmt.executeUpdate("insert into PRODUCTS(PNAME,QTY,MKNO)" +

				" VALUES(" + pname + "," + qty + "," + mkno + ")");

			} catch (SQLException e) {

				e.printStackTrace();

			}

		} else {

			System.out.println("저장을 취소하였습니다.");

		}

	}

	public static void list() throws SQLException {

		rs = stmt.executeQuery("SELECT PNO, PNAME, QTY, T2.MKNAME"

		+ " FROM PRODUCTS T1 LEFT OUTER JOIN MAKERS T2 ON T1.MKNO = T2.MKNO");

		while (rs.next()) {

			System.out.printf("%-3d %-20s %7d %-10s \n"

			, rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));

		}

	}

	private static String[] command() {

		System.out.print("명령 > ");

		String[] token = scanner.nextLine().split(" ");

		return token;

	}

	public static void destroy() {

		scanner.close();

	}

}