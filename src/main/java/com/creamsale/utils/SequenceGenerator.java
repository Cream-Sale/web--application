package com.creamsale.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequenceGenerator {
    private int begin;
    private int end;
    private int step;

    public SequenceGenerator(int begin, int end, int step) throws Exception {
        if (((begin < end) && (step < 0))
                || ((begin > end) && (step > 0))
                || (step == 0)
                || (Math.abs(begin - end) <= Math.abs(step))) {
            throw new Exception();
        }

        this.begin = begin;
        this.end = end;
        this.step = step;
    }

    public List<Integer> generate() {
        return Stream.iterate(begin, i -> i + step).limit(Math.abs((end - begin) / step) + 1).collect(Collectors.toList());
    }
}
