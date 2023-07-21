package ru.academits.gribukov.range;

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
     * Получения длины диапазона
     * @return double
     */
    public double getLength() {
        return to - from;
    }

    /**
     * Принадлежит ли число диапазону.
     * Принимает вещественное число и возвращает boolean – результат проверки
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
     * @param range Range
     * @return Range or null
     */
    public Range getIntersection(Range range) {
        double epsilon = 1.0e-10;

        if (this.isInside(range.from)) {
            this.setFrom(range.from);

            if (this.isInside(range.to)) {
                this.setTo(range.to);
            }

            if (Math.abs(this.from - this.to) <= epsilon) {
                return null;
            }

            return this;
        }

        if (range.isInside(this.from)) {
            range.setFrom(this.from);

            if (range.isInside(this.to)) {
                range.setTo(this.to);
            }

            if (Math.abs(range.from - range.to) <= epsilon) {
                return null;
            }

            return range;
        }

        return null;
    }
}
