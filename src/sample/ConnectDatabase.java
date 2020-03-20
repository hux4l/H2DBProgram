package sample;


import java.sql.*;

public class ConnectDatabase extends Controller{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/data";

    //  Database credentials
    static final String USER = "";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 3: Execute a query
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT meno, priezvisko FROM test";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
//                int id  = rs.getInt("id");
//                int age = rs.getInt("age");
                String meno = rs.getString("meno");
                String priezvisko = rs.getString("priezvisko");

                // Display values
//                System.out.print("ID: " + id);
//                System.out.print(", Age: " + age);
                System.out.print(" Meno: " + meno);
                System.out.println(", Priezvisko: " + priezvisko);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(Exception se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }// Handle errors for Class.forName
        finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException ignored) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }
//     JDBC driver name and database URL
//    static final String JDBC_DRIVER = "org.h2.Driver";
//    static final String DB_URL = "jdbc:h2:~/data";


    //  Database credentials
//    static final String USER = "";
//    static final String PASS = "";

//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            // STEP 1: Register JDBC driver
//            Class.forName("org.h2.Driver");
//
//            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            //STEP 3: Execute a query
//            System.out.println("Creating table in given database...");
//            stmt = conn.createStatement();
//            String sql =  "CREATE TABLE   REGISTRATION " +
//                    "(id INTEGER not NULL, " +
//                    " first VARCHAR(255), " +
//                    " last VARCHAR(255), " +
//                    " age INTEGER, " +
//                    " PRIMARY KEY ( id ))";
//            stmt.executeUpdate(sql);
//            System.out.println("Created table in given database...");
//
//            // STEP 4: Clean-up environment
//            stmt.close();
//            conn.close();
//        } catch(SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        } catch(Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            //finally block used to close resources
//            try{
//                if(stmt!=null) stmt.close();
//            } catch(SQLException se2) {
//            } // nothing we can do
//            try {
//                if(conn!=null) conn.close();
//            } catch(SQLException se){
//                se.printStackTrace();
//            } //end finally try
//        } //end try
//        System.out.println("Goodbye!");
//    }
}
