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
public class TVATax implements Tax {
   private final Type[] includedTypes = {Type.CD, Type.COSMETIC};

   @Override
   public float compute(Item item) {
      return (item.getPrice() * 0.1f);
   }

   @Override
   public boolean isApplicable(Item item) {
      return ArrayUtils.contains(includedTypes, item.getProduct().getType());
   }
}
