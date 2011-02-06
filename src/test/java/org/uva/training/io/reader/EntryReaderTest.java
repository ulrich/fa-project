package org.uva.training.io.reader;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.uva.training.utils.RawEntry;

@RunWith(JUnit4.class)
public class EntryReaderTest {
   private static final String GOOD_INPUTS_FILE = "org/uva/training/io/reader/good-inputs.txt";
   private static final String BAD_INPUTS_FILE = "org/uva/training/io/reader/bad-inputs.txt";
   private Reader reader;

   @After
   public void after() throws IOException {
      reader.close();
   }

   @Test
   public void testReadWithAllGoodEntries() throws URISyntaxException, FileNotFoundException {
      File file = new File(EntryReader.class.getClassLoader().getResource(GOOD_INPUTS_FILE).toURI());

      reader = new FileReader(file);
      assertNotNull(reader);

      EntryReader entryReader = new EntryReader();
      Collection<RawEntry> rawEntries = entryReader.read(reader);
      assertNotNull(rawEntries);
      // know I had 9 good entries
      assertEquals(9, rawEntries.size());
   }

   @Test
   public void testReadWithAllBadEntries() throws URISyntaxException, FileNotFoundException {
      File file = new File(EntryReader.class.getClassLoader().getResource(BAD_INPUTS_FILE).toURI());

      reader = new FileReader(file);
      assertNotNull(reader);

      EntryReader entryReader = new EntryReader();
      Collection<RawEntry> rawEntries = entryReader.read(reader);
      assertNotNull(rawEntries);
      assertEquals(0, rawEntries.size());
   }
}
