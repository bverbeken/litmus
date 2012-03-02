package litmus.util;

import play.mvc.results.NotFound;

public class PlayExceptionUtil {

	public static RuntimeException tryToFindNotFound(Throwable e) {
		if (e.getCause() != null) {
			if (e.getCause() instanceof NotFound) {
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
