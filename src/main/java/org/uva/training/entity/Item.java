package org.uva.training.entity;

/**
 * This class aims to represent an entry item.
 * 
 * @author uvachon
 */
public class Item {
   private final Product product;
   private final int quantity;
   private final float price;

   public Item(Product product, int quantity, float price) {
      this.product = product;
      this.quantity = quantity;
      this.price = price;
   }

   public Product getProduct() {
      return product;
   }

   public int getQuantity() {
      return quantity;
   }

   public float getPrice() {
      return price;
   }
}
