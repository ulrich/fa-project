package org.uva.training.entity;

import java.util.ArrayList;
import java.util.Collection;

import org.uva.training.tax.Tax;

/**
 * This class aims to represent an entry item.
 * 
 * @author uvachon
 */
public class Item {
   private final Product product;
   private final int quantity;
   private final float price;
   private final Collection<Tax> taxes = new ArrayList<Tax>();

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

   public float finalPrice() {
      return price;
   }

   public Collection<Tax> getTaxes() {
      return taxes;
   }
}
