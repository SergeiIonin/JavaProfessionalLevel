package Lesson_2;

import java.sql.*;

import static java.lang.Integer.valueOf;

public class HandleGoodsDB {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement prstmt;
    private static int rows = 100;
    private static ResultSet rs;

    public static void main(String[] args){


        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       try {

           // 0) if table not exists
           stmt.execute("CREATE TABLE IF NOT EXISTS goods (" +
                   "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                   "prodid TEXT," +
                   "title TEXT," +
                   "cost INTEGER)");

           prstmt = connection.prepareStatement("INSERT INTO goods (prodid, title, cost)" +
                   " VALUES (?,?,?)");

           connection.setAutoCommit(false);
           for (int i = 1; i < rows; i++) {
               prstmt.setString(1, "id_good" + i);
               prstmt.setString(2, "good" + i);
               prstmt.setInt(3, 10 * i);
               prstmt.addBatch();
           }
           prstmt.executeBatch();
           connection.setAutoCommit(true);

           //1) Price query
           System.out.println("1) Price query");
           String costQuery = "price good500";
           String goodFromQuery = costQuery.split(" ")[1];
           prstmt = connection.prepareStatement("SELECT * FROM goods where title = ?");
           prstmt.setString(1, goodFromQuery);

           ResultSet rs = prstmt.executeQuery();
           if (!rs.isClosed()){
               System.out.println("Price for " + goodFromQuery + " is " + rs.getInt(4));
           }
           else System.out.println("There's no such good");
             // 2) Change of price

           System.out.println("2) Change of price");
           String changePriceCommand = "changePrice good10 22000";
             String titleAltered = changePriceCommand.split(" ")[1];
             int costNew = valueOf(changePriceCommand.split(" ")[2]);

             //connection.setAutoCommit(false);
             prstmt = connection.prepareStatement("UPDATE goods SET cost = ? WHERE title = ?");
             prstmt.setInt(1,costNew);
             prstmt.setString(2,titleAltered);
             prstmt.executeUpdate();

           prstmt = connection.prepareStatement("SELECT * FROM goods WHERE title = ?");
           prstmt.setString(1,titleAltered);
           rs = prstmt.executeQuery();

           System.out.println(rs.getInt("id") + " " + rs.getString("prodid") + " " + rs.getString("title") + " " + rs.getInt("cost"));

                //3) Select goods from  the cost range of (100, 600)
           System.out.println("3) Select goods from  the cost range of (100, 600)");
           String getGoodsCommand = "GoodsAtPrice " +
                "100" +
                " 600";
        int lowerPrice = Integer.valueOf(getGoodsCommand.split(" ")[1]);
        int upperPrice = Integer.valueOf(getGoodsCommand.split(" ")[2]);

        prstmt = connection.prepareStatement("SELECT * FROM (SELECT * FROM goods WHERE cost > ?) WHERE cost < ?;");

        prstmt.setInt(1,lowerPrice);
        prstmt.setInt(2,upperPrice);

        rs = prstmt.executeQuery();

        while (rs.next()){
            System.out.println(rs.getInt("id") + " " + rs.getString("prodid") + " " + rs.getString("title") + " " + rs.getInt("cost") + "\n");
        }

    } catch (SQLException e) {
             e.printStackTrace();
         }

        disconnect();


    }

    public static void connect() throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:goodsDB.db");
        stmt = connection.createStatement();

    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



