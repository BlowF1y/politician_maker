package politician_maker.DATA;


import politician_maker.Main;
import politician_maker.Panel.GamePanel;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DBconnect {
    private PreparedStatement pstmt;
    private String u_name;
    private int chr_num,PP,Approval_R;
    private ArrayList<ArrayList> listGroup;

    public void connectDB(String name){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/politician_maker", "root","1234");
            String name1 = name;
            String query = "select * from user_save where name = '"+name1+"'";
            pstmt = conn.prepareStatement(query);
            ResultSet srs = pstmt.executeQuery(query);
            while (srs.next()) {
               this.u_name = srs.getString("name");
               this.chr_num = srs.getInt("chr_img");
               this.PP = srs.getInt("politician_party");
               this.Approval_R = srs.getInt("Approval_rating");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 오류");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB 연결 오류");
        }
    }
    public void addDB(String name, int chr, int poli_party){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/politician_maker", "root","1234");
            int chr_num = chr;
            int politician_party = poli_party;
            String query = "insert into user_save";
            query += "(name,chr_img,politician_party,Approval_rating)";
            query += " values(?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, Integer.toString(chr_num));
            pstmt.setString(3, Integer.toString(politician_party));
            pstmt.setString(4,"1");

            pstmt.executeUpdate();
            pstmt.close();
            Main.movePage(5);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 오류");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(Main.f,"이미 있는 이름입니다");
            System.out.println("DB 연결 오류");
        }
    }
    public void updateDB(String name, int count){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/politician_maker", "root","1234");
            String query = "update user_save set Approval_rating = '"+count+"' where name = '"+name+"'";
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate(query);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 오류");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB 연결 오류");
        }
    }
    public void saveloadDB(){
        try {
            ArrayList list = new ArrayList();
            listGroup = new ArrayList();
            String name, a, b;
            int c;
            GamePanel gp = new GamePanel();



            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/politician_maker", "root","1234");
            String query = "select * from user_save";

            pstmt = conn.prepareStatement(query);
            ResultSet srs = pstmt.executeQuery(query);

            while (srs.next()) {
                name = srs.getString("name");
                a = srs.getString("chr_img");
                b = srs.getString("politician_party");
                c = srs.getInt("Approval_rating");
                list.add(name);
                if (a.equals("1")){
                    list.add("이재명");
                } else if (a.equals("2")){
                    list.add("이준석");
                } else if (a.equals("c")){
                    list.add("허경영");
                }

                if (b.equals("1")) {
                    list.add("더불어 민주당");
                }else if (b.equals("2")){
                    list.add("국민의 힘");
                }else if (b.equals("3")){
                    list.add("국가혁명 배당금당");
                }

                list.add(c+"/"+Math.round((double)c / (double)gp.president * 100)/1.0+"%");

                listGroup.add(list);
                list = new ArrayList();
            }

        }catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 오류");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB 연결 오류");
        }

    }

    public void deleteDB(String name){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/politician_maker", "root","1234");
            String Delname = name;
            String query = "delete from user_save where name = '"+Delname+"';";
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate(query);
            pstmt.executeUpdate();
            pstmt.close();
        }catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 오류");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB 연결 오류");
        }
    }
    public int Get_PP(){
        return this.PP;
    }
    public int Get_chr(){
        return this.chr_num;
    }
    public int Get_rating() {return this.Approval_R;}
    public ArrayList Get_list(){
        return this.listGroup;
    }
}
