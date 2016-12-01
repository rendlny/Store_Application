/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Product;
import Dtos.ProductImage;
import java.util.ArrayList;

/**
 *
 * @author Ren
 */
public interface ProductDaoInterface {
    public boolean addProduct(Product p);
    public boolean deleteProduct(Product p);
    public ArrayList<Product> listAllProducts();
    public ArrayList<Product> searchProducts(String searchTerm);
    public ArrayList<Product> searchProductsLike(String searchTerm);
    public Product getProductById(int product_id);
    
}
