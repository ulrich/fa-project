package org.uva.training.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uva.training.entity.Item;
import org.uva.training.entity.Type;
import org.uva.training.utils.RawEntry;

/**
 * Handler used to find cosmetic product in the entry.
 * 
 * @author uvachon
 */
public class CosmeticItemHandler extends ProductItemHandler {
   private static final String[] KEYWORDS = {"parfum"};
   private static final Log LOG = LogFactory.getLog(CosmeticItemHandler.class);

   public CosmeticItemHandler(Handler<Item, RawEntry> successor) {
      super(successor);
   }

   @Override
   public Item handlerRequest(RawEntry rawEntry) {
      if (null == rawEntry) {
         return null;
      }
      Item item = buildItem(rawEntry, Type.COSMETIC, KEYWORDS);
      if (null != item) {
         LOG.debug("Found and built a cosmetic item");
         return item;
      }
      return super.handlerRequest(rawEntry);
   }
}
