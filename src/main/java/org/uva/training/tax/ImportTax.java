package org.uva.training.tax;

import org.uva.training.entity.Item;

/**
 * This tax calculates her value if the product is imported.
 * 
 * @author uvachon
 */
public class ImportTax implements Tax {
   private float value = 0f;

   @Override
   public void compute(Item item) {
      if (!item.getProduct().isImported()) {
         return;
      }
      value = (item.getPrice() * 0.05f);
   }

   @Override
   public float getValue() {
      return value;
   }
}
