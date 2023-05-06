package org.greax.core.util.checked;

import org.greax.core.util.ExceptionUtils;

import java.util.function.Function;

@FunctionalInterface
public interface CheckedFunction<T, R> extends Function<T, R> {

    R checkedApply(T t) throws Exception;

    @Override
    default R apply(T t) {
        try {
            return checkedApply(t);
        } catch (Exception e) {
            throw ExceptionUtils.sneakyThrow(e);
        }
    }

}
