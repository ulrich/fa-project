package org.uva.training.io.reader;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.uva.training.utils.RawEntry;
import org.uva.training.utils.RawEntryBuilder;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class EntryReader {
   private static final Log LOG = LogFactory.getLog(EntryReader.class);

   public Collection<RawEntry> read(Reader reader) {
      List<String> entriesByString = null;
      try {
         entriesByString = IOUtils.readLines(reader);
      } catch (IOException e) {
         LOG.error("Unable to read the entries from reader, aborting!");
         throw new RuntimeException(e);
      }
      return Collections2.filter(Lists.<String, RawEntry> transform(entriesByString, new RawEntryTransformer()), Predicates.notNull());
   }

   // private function based on class used to transform list
   private class RawEntryTransformer implements Function<String, RawEntry> {
      @Override
      public RawEntry apply(String input) {
         return RawEntryBuilder.build(input);
      }
   }
}
