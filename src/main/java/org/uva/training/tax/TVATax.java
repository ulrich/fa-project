package org.uva.training.tax;

import org.apache.commons.lang.ArrayUtils;
import org.uva.training.entity.Item;
import org.uva.training.entity.Type;

/**
 * This tax calculates her value based on price (HT) and if the product is not of type: {@link Type.BOOK}, {@link Type.FOOD}, {@link Type.DRUG}.<br/>
 * We could split the calculation of tax to another implementation (for better performance...) and the rule.
 * 
 * @author uvachon
 */
public class TVATax extends AbstractTax {
   private final Type[] includedTypes = {Type.CD, Type.COSMETIC};
   private Item item;

   public TVATax(Item item) {
      this.item = item;
   }

   @Override
   public boolean isApplicable() {
      return ArrayUtils.contains(includedTypes, item.getProduct().getType());
   }

   @Override
   public float getValue() {
      return item.getPrice() * 0.1f;
   }
}
