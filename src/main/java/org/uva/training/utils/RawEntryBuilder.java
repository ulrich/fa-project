package org.uva.training.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * Builder used to validate and build raw entry. Moreover, it can define the import flag.<br/>
 * The common pattern for an entry is: <i>quantity, name, price.</i>
 * 
 * @author uvachon
 */
public class RawEntryBuilder {
   private static final String ENTRY_PATTERN = "^(\\d+)\\s(\\w+.*)\\s[à]\\s(\\d+.\\d+)$";
   private static final Pattern PATTERN = Pattern.compile(ENTRY_PATTERN);

   private RawEntryBuilder() {
   }

   /**
    * Builds a raw entry.
    * 
    * @param rawEntry the user-entered string.
    * @return a raw entry filled with properties.
    */
   public static RawEntry build(String string) {
      RawEntry rawEntry = null;

      if (StringUtils.isBlank(string)) {
         return rawEntry;
      }
      Matcher matcher = PATTERN.matcher(string);
      if (matcher.find()) {
         rawEntry = buildAndDefineOrigin(matcher);
      }
      return rawEntry;
   }

   // build a raw entry and help to define origin
   private static RawEntry buildAndDefineOrigin(Matcher matcher) {
      RawEntry rawEntry = new RawEntry(matcher.group(1), matcher.group(2), matcher.group(3));

      if (StringUtils.contains(rawEntry.getName(), "import")) {
         rawEntry.setImported(true);
      }
      return rawEntry;
   }
}
