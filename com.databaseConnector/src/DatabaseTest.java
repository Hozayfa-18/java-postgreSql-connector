import java.sql.*;

public class DatabaseTest {

    public static void main(String[] args){

//        try{
//            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Hh12-3456-789");
//            Statement st = con.createStatement();
//
//            ResultSet res = st.executeQuery("select * From product");
//
//            while(res.next()){
//                System.out.println(res.getString("product_name")+" ,"+res.getString("price"));
//            }
//        }catch(Exception e){
//            System.out.println(e);
//        }

        DatabaseConnector con = new DatabaseConnector("postgres","postgres","Hh12-3456-789");
        con.executeStatement("select * from product");
        QueryResult res = con.getCurrentQueryResult();
        if (res != null) {
            String[][] data = res.getData();
            for (int i = 0; i < res.getRowCount(); i++) {
                for(int j=0; j< res.getColumnCount();j++){
                    System.out.print(data[i][j]+" ,");
                }
                System.out.println();

            }
        }
        con.close();

    }
}
