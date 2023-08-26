package ru.academits.gribukov.range;

import org.jetbrains.annotations.NotNull;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    /**
     * Получение длины диапазона
     *
     * @return double
     */
    public double getLength() {
        return to - from;
    }

    /**
     * Принадлежит ли число диапазону.
     * Принимает вещественное число и возвращает boolean – результат проверки
     *
     * @param number double
     * @return boolean
     */
    public boolean isInside(double number) {
        double epsilon = 1.0e-10;
        return number - from >= -epsilon && to - number >= -epsilon;
    }

    /**
     * Получение интервала-пересечения двух интервалов.
     * Если пересечения нет, выдать null.
     * Если есть, то выдать новый диапазон с соответствующими концами
     *
     * @param range Range
     * @return Range or null
     */
    public Range getIntersection(Range range) {
        if (from >= range.to || to <= range.from) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    /**
     * Получение объединения двух интервалов.
     * Может получиться 1 или 2 отдельных куска
     *
     * @param range Range
     * @return Range[1] or Range[2]
     */
    public Range[] getUnion(Range range) {
        if (from > range.to || to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    /**
     * Получение разности двух интервалов.
     * Может получиться 0, 1 или 2 отдельных куска
     *
     * @param range Range
     * @return Range[0] or Range[1] or Range[2]
     */
    public Range[] getDifference(Range range) {
        if (to <= range.from || from >= range.to) {
            return new Range[]{new Range(from, to)};
        }

        if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (from >= range.from && to <= range.to) {
            return new Range[]{};
        }

        if (to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        }

        return new Range[]{new Range(range.to, to)};
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", from, to);
    }
}
