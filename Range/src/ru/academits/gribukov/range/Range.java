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
        double epsilon = 1.0e-10;
        Range newRange = new Range(this.from, this.to);

        if (this.isInside(range.from)) {
            newRange.setFrom(range.from);

            if (this.isInside(range.to)) {
                newRange.setTo(range.to);
            }

            if (Math.abs(newRange.from - newRange.to) <= epsilon) {
                return null;
            }

            return newRange;
        }

        newRange.setFrom(range.from);
        newRange.setTo(range.to);

        if (range.isInside(this.from)) {
            newRange.setFrom(this.from);

            if (range.isInside(this.to)) {
                newRange.setTo(this.to);
            }

            if (Math.abs(range.from - range.to) <= epsilon) {
                return null;
            }

            return newRange;
        }

        return null;
    }

    /**
     * Получение объединения двух интервалов.
     * Может получиться 1 или 2 отдельных куска
     *
     * @param range Range
     * @return Range[1] or Range[2]
     */
    public Range[] getUnion(Range range) {
        Range firstRange = new Range(this.from, this.to);
        Range secondRange = new Range(range.from, range.to);


        if (this.isInside(range.from)) {
            if (!this.isInside(range.to)) {
                firstRange.setTo(range.to);
            }

            return new Range[]{firstRange};
        }

        if (this.isInside(range.to)) {
            firstRange.setFrom(range.from);

            return new Range[]{firstRange};
        }

        if (range.isInside(this.to)) {
            firstRange.setFrom(range.from);
            firstRange.setTo(range.to);

            return new Range[]{firstRange};
        }

        return new Range[]{firstRange, secondRange};
    }

    /**
     * Получение разности двух интервалов.
     * Может получиться 0, 1 или 2 отдельных куска
     *
     * @param range Range
     * @return Range[0] or]Range[1] or Range[2]
     */
    public Range[] getDifference(Range range) {
        double epsilon = 1.0e-10;
        Range firstRange = new Range(this.from, this.to);
        Range secondRange = new Range(this.from, this.to);

        if (this.isInside(range.from)) {
            firstRange.setTo(range.from);

            if (this.isInside(range.to)) {
                secondRange.setFrom(range.to);

                if (Math.abs(firstRange.from - firstRange.to) <= epsilon && !secondRange.equals(this)) {
                    return new Range[]{secondRange};
                }

                if (Math.abs(secondRange.from - secondRange.to) <= epsilon) {
                    return new Range[]{firstRange};
                }

                return new Range[]{firstRange, secondRange};
            }

            return new Range[]{firstRange};
        }

        if (this.isInside(range.to)) {
            firstRange.setFrom(range.to);
            return new Range[]{firstRange};
        }

        return new Range[]{};
    }

    public boolean equals(Range range) {
        double epsilon = 1.0e-10;

        return Math.abs(this.from - range.from) <= epsilon && Math.abs(this.to - range.to) <= epsilon;
    }
}
