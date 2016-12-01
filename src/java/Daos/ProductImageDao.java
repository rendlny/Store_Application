/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.ProductImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ren
 */
public class ProductImageDao extends Dao implements ProductImageDaoInterface {

    public ProductImageDao(String database) {
        super(database);
    }

    @Override
    public boolean addImageToProduct(ProductImage img) {
        boolean added = false;
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            String query = "INSERT INTO product_images(image_id, product_id, image_url) "
                    + "VALUES(?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, img.getImage_id());
            ps.setInt(2, img.getProduct_id());
            ps.setString(3, img.getImage_url());

            ps.executeUpdate();
            added = true;
        } catch (SQLException e) {
            System.out.println("Exception occured in the addImageToProduct() method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the addImageToProduct() method: " + e.getMessage());
            }
        }

        return added;
    }

    @Override
    public boolean deleteProductImage(ProductImage img) {
    boolean deleted = false;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = "DELETE FROM product_images WHERE image_id = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, img.getImage_id());
            int affected_rows = ps.executeUpdate();

            if (affected_rows > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the deleteProductImage()"
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
                        + " the deleteProductImage() method: " + e.getMessage());
            }
        }

        return deleted;
    }

}
