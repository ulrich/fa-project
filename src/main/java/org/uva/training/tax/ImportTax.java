package org.uva.training.tax;

import org.uva.training.entity.Item;

/**
 * This tax calculates her value if the product is imported.
 * 
 * @author uvachon
 */
public class ImportTax implements Tax {

   @Override
   public float compute(Item item) {
      return item.getPrice() * 0.05f;
   }

   @Override
   public boolean isApplicable(Item item) {
      return item.getProduct().isImported();
   }
}
