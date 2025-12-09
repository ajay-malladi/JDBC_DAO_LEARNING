package oracle__java__connector;

import java.sql.*;

public class  Dao_FetchData {   // class
    public static void main(String[] args) throws Exception {

        Student s = new Student();
        s.roll = 2;
        String nam = s.getName(2);
        System.out.println("roll : "+s.roll+" and Name : "+ nam);

    }
}

// we cant define a class inside a class,  instance variable and methods

class Student {
    int roll;
    String Name;

    Student() {
        this.roll = roll;
        this.Name = Name;

    }

    public String getName(int roll) throws Exception {

        Class.forName("oracle.jdbc.OracleDriver");

        Connection con = DriverManager.getConnection("Db_url", "Db_user", "Db_password");

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from student where id =" + roll);  // be careful with table name

        rs.next();
        String output = rs.getString(2);

        return output;

    }

}

//crate db student table
//{id,Name,Marks}
