package org.uva.training.utils;

/**
 * This the raw representation of an entry.
 * 
 * @author uvachon
 */
public class RawEntry {
   private final String quantity;
   private final String name;
   private final String price;
   private boolean imported = false;

   public RawEntry(String quantity, String name, String price) {
      this.quantity = quantity;
      this.name = name;
      this.price = price;
   }

   public String getQuantity() {
      return quantity;
   }

   public String getName() {
      return name;
   }

   public String getPrice() {
      return price;
   }

   public boolean isImported() {
      return imported;
   }

   public void setImported(boolean imported) {
      this.imported = imported;
   }
}
