package org.codecraftlabs.leetcode;

import javax.annotation.Nonnull;

public class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    @Nonnull
    public final T getFirst() {
        return first;
    }

    @Nonnull
    public final U getSecond() {
        return second;
    }
}
