package com.nothouse.itsroom.publicdata;

import java.sql.*;
import java.util.Properties;

/**
 * DatabaseConnection
 * 여기는 로컬상에서 한거 인데 addbatch로 일괄작업 가능
 * 웹으로 옮기는 중
 */
public class DatabaseConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/mrkim";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "mrkim");
        props.setProperty("ssl", "false");
        Connection conn = DriverManager.getConnection(url, props);
        // Statement st = conn.createStatement();
        // ResultSet rs = st.executeQuery("SELECT * FROM test");
        // while (rs.next()) {
        //     System.out.print("Column 1 returned ");
        //     System.out.println(rs.getString(1));
        // }
        // rs.close();
        // st.close();

        PreparedStatement st = conn.prepareStatement("INSERT INTO public.stanregincd (region_cd, sido_cd, sgg_cd, umd_cd, ri_cd, locatjumin_cd, locatjijuk_cd, locatadd_nm, locat_order, locat_rm, locathigh_cd, locallow_nm, adpt_de) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        st.setString(1, "2");
        st.setString(2, "2");
        st.setString(3, "2");
        st.setString(4, "2");
        st.setString(5, "2");
        st.setString(6, "2");
        st.setString(7, "2");
        st.setString(8, "2");
        st.setString(9, "2");
        st.setString(10, "2");
        st.setString(11, "2");
        st.setString(12, "2");
        st.setString(13, "2");
        st.addBatch();
        int[] result = st.executeBatch();
        int rowsDeleted = st.executeUpdate();
        System.out.println(rowsDeleted + " rows deleted");
        st.close();
    }
}