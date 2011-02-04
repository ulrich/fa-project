package org.uva.training.tax;

import org.uva.training.entity.Item;

/**
 * This tax calculates her value if the product is imported.
 * 
 * @author uvachon
 */
public class ImportTax implements Tax {
   private Item item;

   public ImportTax(Item item) {
      this.item = item;
   }

   @Override
   public boolean isApplicable() {
      return item.getProduct().isImported();
   }

   @Override
   public float getValue() {
      return item.getPrice() * 0.05f;
   }
}
