package org.codecraftlabs.leetcode.tripletsum;

import java.util.Objects;

public final class Triplet<T> {
    private final T first;
    private final T second;
    private final T third;

    private Triplet(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static <T> Triplet<T> of(T first, T second, T third) {
        return new Triplet<>(first, second, third);
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public T getThird() {
        return third;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof Triplet<?> instance)) {
            return false;
        }

        return Objects.equals(this.first, instance.first) &&
                Objects.equals(this.second, instance.second) &&
                Objects.equals(this.third, instance.third);
    }
}
