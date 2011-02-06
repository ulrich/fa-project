package org.uva.training;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uva.training.entity.Item;
import org.uva.training.io.reader.EntryReader;
import org.uva.training.tax.TaxParser;
import org.uva.training.utils.RawEntry;
import org.uva.training.utils.RawEntryHandler;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;

/**
 * Entry point of FA project.<br/>
 * This dummy implementation works with a simple file reader.
 * 
 * @author uvachon
 */
public class Main {
   private static final Log LOG = LogFactory.getLog(Main.class);
   private File source = null;

   public Main(String file) {
      source = new File(file);

      if (!source.exists()) {
         throw new RuntimeException("Unable to find the source file, aborting!");
      }
      LOG.info("The file: + " + source.getName() + "of entry is ready to be parse");
   }

   /**
    * 
    */
   public void doJob() {
      // building raw entries list
      Collection<RawEntry> rawEntries = getRawEntries();
      if (CollectionUtils.isEmpty(rawEntries)) {
         LOG.info("No correct entry found");
         return;
      }
      // building items list
      Collection<Item> items = getItems(rawEntries);
      if (CollectionUtils.isEmpty(items)) {
         LOG.info("No items found");
         return;
      }

      LOG.info("Found " + items.size() + " item(s), it's time to compute");

      TaxParser taxParser = new TaxParser();
      for (Item item : items) {
         taxParser.parse(item);
      }
   }

   // returns collection of raw entries
   private Collection<RawEntry> getRawEntries() {
      FileReader fileReader = null;
      Collection<RawEntry> rawEntries = null;

      try {
         fileReader = new FileReader(source);
         rawEntries = new EntryReader().read(fileReader);
      } catch (FileNotFoundException e) {
         throw new RuntimeException("Unable to find the source file, aborting!");
      } finally {
         IOUtils.closeQuietly(fileReader);
      }
      return rawEntries;
   }

   // returns collection of item
   private Collection<Item> getItems(Collection<RawEntry> rawEntries) {
      return Collections2.filter(Collections2.<RawEntry, Item> transform(rawEntries, new ItemTransformer()), Predicates.notNull());
   }

   // private function based on class used to transform list
   private class ItemTransformer implements Function<RawEntry, Item> {
      RawEntryHandler rawEntryHandler = new RawEntryHandler();

      @Override
      public Item apply(RawEntry input) {
         return rawEntryHandler.handle(input);
      }
   }

   //
   public static void main(String[] args) {
      if (1 != args.length) {
         System.err.println("Missing parameter, you must to give the file of entries...");
         System.exit(-1);
      }
      new Main(args[0]).doJob();
   }
}
