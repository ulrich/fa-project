package org.uva.training.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uva.training.entity.Item;
import org.uva.training.entity.Type;
import org.uva.training.utils.RawEntry;

/**
 * Handler used to find CD product in the entry.
 * 
 * @author uvachon
 */
public class CDItemHandler extends ProductItemHandler {
   private static final String[] KEYWORDS = {"CD", "compact-disc"};
   private static final Log LOG = LogFactory.getLog(CDItemHandler.class);

   public CDItemHandler(Handler<Item, RawEntry> successor) {
      super(successor);
   }

   @Override
   public Item handlerRequest(RawEntry rawEntry) {
      if (null == rawEntry) {
         return null;
      }
      Item item = buildItem(rawEntry, Type.CD, KEYWORDS);
      if (null != item) {
         LOG.debug("Found and built a CD item");
         return item;
      }
      return super.handlerRequest(rawEntry);
   }
}
