package com.boobalan.iEvolve;

import org.jetbrains.annotations.NotNull;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Student {
    public abstract String result(String marksOfStudent);

    public DecimalFormat df;

    public Student() {
        df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.DOWN);
    }

    protected double getGradePointForMarks(int mark) {
        if (mark < 40) {
            return 0;
        } else {
            int rangeBegin, rangeEnd;
            double gradePointBegin, gradePointEnd;
            if (mark >= 75) {
                rangeBegin = 75;
                rangeEnd = 100;
                gradePointBegin = 9.0;
                gradePointEnd = 10.0;
            } else if (mark >= 60) {
                rangeBegin = 60;
                rangeEnd = 74;
                gradePointBegin = 8.0;
                gradePointEnd = 8.9;
            } else if (mark >= 50) {
                rangeBegin = 50;
                rangeEnd = 59;
                gradePointBegin = 7.0;
                gradePointEnd = 7.9;
            } else {
                rangeBegin = 40;
                rangeEnd = 49;
                gradePointBegin = 6.0;
                gradePointEnd = 6.9;
            }
            double gradePoint = ((mark - rangeBegin) * (gradePointEnd - gradePointBegin) / (rangeEnd - rangeBegin)) + gradePointBegin;

            gradePoint = Double.valueOf(df.format(gradePoint));
            return gradePoint;

        }
    }

    @NotNull
    protected String calculate(final String marksOfStudent) {
        // "100 5,100 2,100 5|0,100,5|1,100,5"

        final String[] splits = marksOfStudent.split("\\|");
        final String subjectMarkSection = splits[0];
        String sportsMarkSection = null;
        String nccMarkSection = null;
        if (splits.length == 2) {
            sportsMarkSection = splits[1];
        } else {
            nccMarkSection = splits[1];
            sportsMarkSection = splits[2];
        }

        int creditPointSum = 0;
        double weightedGradePoint = 0.0;

        final String[] subjectMarks = subjectMarkSection.split(",");
        for (String subject :
                subjectMarks) {
            final String[] markAndCredit = subject.split(" ");
            int creditScored = Integer.parseInt(markAndCredit[1]);
            int mark = Integer.parseInt(markAndCredit[0]);
            final double gradePointForMarks = getGradePointForMarks(mark);
            weightedGradePoint += (gradePointForMarks * creditScored);
            creditPointSum += 5;

        }

        final String[] sportMarks = sportsMarkSection.split(",");
        if (sportMarks[0].equals("1")) {
            int credit = Integer.parseInt(sportMarks[2]);
            int mark = Integer.parseInt(sportMarks[1]);
            final double gradePointForMarks = getGradePointForMarks(mark);
            weightedGradePoint += (gradePointForMarks * credit);
            creditPointSum += credit;
        }

        if (nccMarkSection != null) {
            final String[] nccMarks = nccMarkSection.split(",");
            if (nccMarks[0].equals("1")) {
                int credit = Integer.parseInt(nccMarks[2]);
                int mark = Integer.parseInt(nccMarks[1]);
                final double gradePointForMarks = getGradePointForMarks(mark);
                weightedGradePoint += (gradePointForMarks * credit);
                creditPointSum += credit;
            }
        }

        final double finalCredit = weightedGradePoint / creditPointSum;
        return String.format("%.2f", finalCredit);
    }


}
