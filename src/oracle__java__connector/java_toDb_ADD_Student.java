package oracle__java__connector;

import java.sql.*;
// DA0 == Data Accessing Object , Inserting the values using the dao

public class java_toDb_ADD_Student {
    public static void main(String[] args) throws Exception {

        Cricketer c = new Cricketer(7, "jordon", 500);
        c.AddStudent();
        c.show();


    }
}


class Cricketer {
    int rank;
    String Name;
    int runs;

    Cricketer(int rank, String Name, int runs) {// if the argumenta are passed then , we should give parameters
        this.rank = rank;
        this.Name = Name;
        this.runs = runs;
    }

    Connection conn() throws Exception {
        Connection con = null;
        Class.forName("oracle.jdbc.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/freepdb1", "dbdb", "7013197589");
        return con;

    }


    void AddStudent() throws Exception {

        String query = "insert into cricketer values(?,?,?)";
        Connection con = conn();


        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, rank);
        st.setString(2, Name);
        st.setInt(3, runs);
        int count = st.executeUpdate();  // returns the counts
        System.out.println(count + " rows updated");


        st.close();
        con.close();


    }

    void show() throws Exception {
        String query = "select * from cricketer order by rank";
        Connection con = conn();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            System.out.println(rs.getInt(1)+ " - "+ rs.getString(2)+ "  -  "+ rs.getInt(3));
        }

        st.close();
        con.close();


    }


}
