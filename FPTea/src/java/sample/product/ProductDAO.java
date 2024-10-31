/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author User
 */
public class ProductDAO {

    private static final String SEARCH_PRODUCT = "SELECT productID, productName, price, quantity, status  FROM tblProducts WHERE productName LIKE ?";
    private static final String SEARCH_8_FIRST_PRODUCTS = "SELECT TOP 8 productID, productName, price, quantity, status  FROM tblProducts ";
    private static final String CHECK_PRODUCT_QUANTITY = "SELECT productName FROM tblProducts WHERE productID=? and quantity>=?";
    private static final String UPDATE_QUANTITY = "UPDATE tblProducts SET quantity=quantity-? WHERE productID=?";
    private static final String CREATE_NEW_ORDER = "INSERT INTO tblOrders(orderDate, total, userID) VALUES(getdate(),?,?)";
    private static final String GET_ORDERID = "SELECT TOP 1 orderID FROM tblOrders ORDER BY orderID DESC";
    private static final String CREATE_NEW_ORDERDETAIL = "INSERT INTO tblOrderDetail(orderID, productID, price, quantity) VALUES(?,?,?,?)";

    public List<ProductDTO> getListProduct(String search) throws SQLException, ClassNotFoundException, NamingException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_PRODUCT);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    double price = Double.parseDouble(rs.getString("price"));
                    int quantiy = Integer.parseInt(rs.getString("quantity"));
                    boolean status = rs.getBoolean("status");
                    list.add(new ProductDTO(productID, productName, price, quantiy, status));

                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;

    }

    public List<ProductDTO> getListByPage(List<ProductDTO> list, int start, int end) {
        ArrayList<ProductDTO> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<ProductDTO> getFirst8Products() throws SQLException, ClassNotFoundException, NamingException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_8_FIRST_PRODUCTS);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    double price = Double.parseDouble(rs.getString("price"));
                    int quantiy = Integer.parseInt(rs.getString("quantity"));
                    boolean status = rs.getBoolean("status");
                    list.add(new ProductDTO(productID, productName, price, quantiy, status));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }

    public Boolean checkQuantity(String productID, int quantity) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_PRODUCT_QUANTITY);
                ptm.setString(1, productID);
                ptm.setInt(2, quantity);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

    public boolean checkUpdateQuantity(String productID, int quantity) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_QUANTITY);
                ptm.setInt(1, quantity);
                ptm.setString(2, productID);
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

    public boolean createNewOrder(double total, String userID) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_NEW_ORDER);
                ptm.setDouble(1, total);
                ptm.setString(2, userID);
                check = ptm.executeUpdate() > 0;
            }

        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

    public int getLastOrderID() throws SQLException, ClassNotFoundException, NamingException {
        int result = 0;

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ORDERID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    result = orderID;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return result;
    }

    public boolean createNewOrderDetail(int oderID, String productID, double price, int quantity) throws ClassNotFoundException, SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_NEW_ORDERDETAIL);
                ptm.setInt(1, oderID);
                ptm.setString(2, productID);
                ptm.setDouble(3, price);
                ptm.setInt(4, quantity);
                check = ptm.executeUpdate() > 0;
            }

        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

}
