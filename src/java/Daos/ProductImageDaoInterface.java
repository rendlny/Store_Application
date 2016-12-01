/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.ProductImage;

/**
 *
 * @author Ren
 */
public interface ProductImageDaoInterface {
    public boolean addImageToProduct(ProductImage img);
    public boolean deleteProductImage(ProductImage img);
}
