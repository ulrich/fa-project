package org.uva.training.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uva.training.entity.Item;
import org.uva.training.entity.Type;
import org.uva.training.utils.RawEntry;

/**
 * Handler used to find book product in the entry.
 * 
 * @author uvachon
 */
public class BookItemHandler extends ProductItemHandler {
   private static final String[] KEYWORDS = {"livre", "ouvrage", "roman"};
   private static final Log LOG = LogFactory.getLog(BookItemHandler.class);

   public BookItemHandler(Handler<Item, RawEntry> successor) {
      super(successor);
   }

   @Override
   public Item handlerRequest(RawEntry rawEntry) {
      if (null == rawEntry) {
         return null;
      }
      Item item = buildItem(rawEntry, Type.BOOK, KEYWORDS);
      if (null != item) {
         LOG.debug("Found and built a book item");
         return item;
      }
      return super.handlerRequest(rawEntry);
   }
}
