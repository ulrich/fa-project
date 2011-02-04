package org.uva.training.tax;

import org.uva.training.entity.Item;

public interface Tax {
   float getValue();

   void compute(Item item);
}
