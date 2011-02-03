package org.uva.training.handler;

import org.uva.training.entity.Item;
import org.uva.training.entity.Type;
import org.uva.training.utils.RawEntry;

/**
 * Handler used to find CD product in the entry.
 * 
 * @author uvachon
 */
public class CDItemHandler extends ProductItemHandler {
   private static final String[] KEYWORDS = {"cd", "compact-disc"};

   public CDItemHandler(Handler<Item, RawEntry> successor) {
      super(successor);
   }

   @Override
   public Item handlerRequest(RawEntry rawEntry) {
      if (null == rawEntry) {
         return null;
      }
      Item item = buildItem(rawEntry, Type.COSMETIC, KEYWORDS);
      if (null != item) {
         return item;
      }
      return super.handlerRequest(rawEntry);
   }
}
