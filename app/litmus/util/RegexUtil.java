package litmus.util;

import org.apache.ivy.plugins.matcher.Matcher;
import org.apache.ivy.plugins.matcher.RegexpPatternMatcher;

public class RegexUtil {
	public static String createNonMatchingString(String regex) {
		Matcher matcher = new RegexpPatternMatcher().getMatcher(regex);
		for (String str : new String[]{"a", "A", "ù", "1", "!", "$", "-"}) {
			if (!matcher.matches(str)) {
				return str;
			}
		}
		throw new UnsupportedOperationException("No non-matching string found. Please provide one yourself and call .with(\"invalidValue\").isInvalidBecause(MATCH)");
	}
}
