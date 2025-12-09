package oracle__java__connector;


//Steps to step up the connection between database and java program
//{think of a scenario : you need to get you result of exam from a friend}

// 1. import java.sql.{having a phone to call}*
//2. load and register the connector{network (sim) to call him}
//3. Establish the connection{call him to get connected}
//4. create the statement{should have question to ask(i,e about result }
//5.execute the query{need to tell him }
//6.process the request{he will tell the result}
//7. close

import java.sql.*;   // step 1

public class JdbcBasic {
    public static void main(String[] args) throws Exception {

        String url = "db_url";
        String uname = "db_user";   // it is you are db credentials
        String pass = "db_pass";
        String query = "select * from emp order by emp_id";

        try {
            Class.forName("oracle.jdbc.OracleDriver");  // Class.forName(className); --> forName is a method to load className: Driver
            Connection con = DriverManager.getConnection(url, uname, pass);// // DriverManager uses the Oracle JDBC driver to open a DB connection. The driver creates a Connection object and returns it.

            Statement st = con.createStatement();   // // Using the Connection object, we ask it to create a Statement. Statement is returned, and we store it in "st".
            ResultSet rs = st.executeQuery(query);


            //rs.next();  // first it points to the label
            while (rs.next()) {
                String data = rs.getInt("emp_id")+" : " +rs.getString("ename") + " --> "+ rs.getInt("salary");// labels should be named carefully : " "
                //String data = rs.getInt(1)+" : " +rs.getString(2) + " --> "+ rs.getInt(3); same as top

                System.out.println(data);
            }
            st.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("inValid credentials");
        } finally{

        }

    }
}


//DML == executeUpdate();
//table to crate in db;
//emp table{emp_id,ename,sal}
