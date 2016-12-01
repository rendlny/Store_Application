/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Product;
import Dtos.ProductImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ren
 */
public class ProductDao extends Dao implements ProductDaoInterface {

    public ProductDao(String database) {
        super(database);
    }

    @Override
    public boolean addProduct(Product p) {
        boolean added = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String query = "INSERT INTO products(product_id, product_name, "
                    + "product_desc, product_price, vat_percentage, stock) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, p.getProduct_id());
            ps.setString(2, p.getProduct_name());
            ps.setString(3, p.getProduct_desc());
            ps.setDouble(4, p.getProduct_price());
            ps.setDouble(5, p.getVat_percentage());
            ps.setInt(6, p.getStock());

            ps.executeUpdate();
            added = true;
        } catch (SQLException e) {
            System.out.println("Exception occured in the ProductDaoInterface() method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the ProductDaoInterface() method: " + e.getMessage());
            }
        }

        return added;
    }

    @Override
    public boolean deleteProduct(Product p) {
        boolean deleted = false;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = "DELETE FROM products WHERE product_id = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, p.getProduct_id());
            int affected_rows = ps.executeUpdate();

            if (affected_rows > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the deleteProduct()"
                    + " method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of"
                        + " the deleteProduct() method: " + e.getMessage());
            }
        }

        return deleted;
    }

    @Override
    public ArrayList<Product> listAllProducts() {

        ArrayList<Product> allProducts = new ArrayList();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM products";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_desc"),
                        rs.getDouble("product_price"),
                        rs.getDouble("vat_percentage"),
                        rs.getInt("stock")
                );
                allProducts.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the listAllProducts() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the listAllProducts() method: " + e.getMessage());
            }
        }

        return allProducts;
    }

    @Override
    public ArrayList<Product> searchProducts(String searchTerm) {
        ArrayList<Product> searchResults = new ArrayList();
        Product p = null;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();

            String query = "SELECT * FROM products WHERE product_name = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, searchTerm);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_desc"),
                        rs.getDouble("product_price"),
                        rs.getDouble("vat_percentage"),
                        rs.getInt("stock")
                );
                searchResults.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the searchProducts() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the searchProducts() method: " + e.getMessage());
            }
        }

        return searchResults;
    }

    @Override
    public ArrayList<Product> searchProductsLike(String searchTerm) {
        ArrayList<Product> searchResults = new ArrayList();
        Product p = null;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();

            String query = "SELECT * FROM products WHERE product_name LIKE ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + searchTerm + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_desc"),
                        rs.getDouble("product_price"),
                        rs.getDouble("vat_percentage"),
                        rs.getInt("stock")
                );
                searchResults.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the searchProductsLike() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the searchProductsLike() method: " + e.getMessage());
            }
        }

        return searchResults;
    }

    @Override
    public Product getProductById(int product_id) {
        Product p = null;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "SELECT * FROM products WHERE product_id = ?";

            ps = con.prepareStatement(query);

            ps.setInt(1, product_id);

            rs = ps.executeQuery();

            if (rs.next()) {
                p = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_desc"),
                        rs.getDouble("product_price"),
                        rs.getDouble("vat_percentage"),
                        rs.getInt("stock")
                );
            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the getProductById()"
                    + " method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of"
                        + " the getProductById() method: " + e.getMessage());
            }
        }

        return p;
    }

}
