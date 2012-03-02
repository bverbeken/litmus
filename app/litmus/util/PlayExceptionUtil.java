package litmus.util;

import play.mvc.results.Result;

public class PlayExceptionUtil {

	public static RuntimeException tryToFindNotFound(Throwable e) {
		if (e.getCause() != null) {
			if (e.getCause() instanceof Result) {
				return (RuntimeException) e.getCause();
			} else {
				return tryToFindNotFound(e.getCause());
			}
		} else {
			if (e instanceof RuntimeException) {
				return (RuntimeException) e;
			} else {
				return new RuntimeException(e);
			}
		}
	}

}
