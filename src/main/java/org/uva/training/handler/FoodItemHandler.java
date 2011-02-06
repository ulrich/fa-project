package org.uva.training.handler;

import org.uva.training.entity.Item;
import org.uva.training.entity.Type;
import org.uva.training.utils.RawEntry;

/**
 * Handler used to find food product in the entry.
 * 
 * @author uvachon
 */
public class FoodItemHandler extends ProductItemHandler {
   private static final String[] KEYWORDS = {"chocolat", "bonbon"};

   public FoodItemHandler(Handler<Item, RawEntry> successor) {
      super(successor);
   }

   @Override
   public Item handlerRequest(RawEntry rawEntry) {
      if (null == rawEntry) {
         return null;
      }
      Item item = buildItem(rawEntry, Type.FOOD, KEYWORDS);
      if (null != item) {
         log.debug("Found and built an food item");
         return item;
      }
      return super.handlerRequest(rawEntry);
   }
}
