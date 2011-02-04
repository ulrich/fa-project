package org.uva.training.tax;

import org.uva.training.entity.Item;

public interface Tax {
   float compute(Item item);

   boolean isApplicable(Item item);
}
