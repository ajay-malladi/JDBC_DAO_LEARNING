package oracle__java__connector;

import java.sql.*;


public class insert_java_toDb {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url = "jdbc:oracle:thin:@//localhost:1521/freepdb1";
        String uname = "dbdb";
        String pass = "7013197589";

        int emp_id = 8;
        String ename = "laya";
        int deptid = 50;
        int salary = 1000;

        String query = "insert into emp values(?,?,?,?)";
        String q1 = "select * from emp order by emp_id";

        Class.forName("oracle.jdbc.OracleDriver");  // what does it do?   (x.y.z)

        Connection con = DriverManager.getConnection(url, uname, pass);


        Statement st1 = con.createStatement();
        PreparedStatement st = con.prepareStatement(query);    // creating a prepared statement



        st.setInt(1, emp_id);  //(column number , column name);
        st.setString(2, ename);
        st.setInt(3, deptid);
        st.setInt(4, salary);

        int count = st.executeUpdate();
        ResultSet rs = st1.executeQuery(q1);


        System.out.println(count + " rows effected");
        while (rs.next()) {
            String data = rs.getInt("emp_id") + " : " + rs.getString("ename") + " --> " + rs.getInt("salary");// labels should be named carefully : " "

            System.out.println(data);
        }
        st.close();
        con.close();


    }
}
