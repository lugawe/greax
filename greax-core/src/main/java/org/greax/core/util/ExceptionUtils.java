package org.greax.core.util;

public final class ExceptionUtils {

    private ExceptionUtils() {
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> T sneakyThrow0(Throwable t) throws T {
        throw (T) t;
    }

    public static RuntimeException sneakyThrow(Throwable t) {
        if (t == null) throw new NullPointerException("t");
        return ExceptionUtils.sneakyThrow0(t);
    }

}
