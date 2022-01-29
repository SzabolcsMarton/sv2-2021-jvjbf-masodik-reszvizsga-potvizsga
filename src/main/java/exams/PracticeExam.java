package exams;

import java.util.List;

public class PracticeExam extends Exam {

    public PracticeExam(long studentId, String topic, List<Integer> points) {
        super(studentId, topic);
        this.setMaxPoints(getSumMaxPoints(points));
    }

    private int getSumMaxPoints(List<Integer> points) {
        int result = points
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        checkMaxPointIValid(result);
        return result;
    }

    public void checkMaxPointIValid(int maxPoints) {
        if (maxPoints < 10 || maxPoints > 150) {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual:" + maxPoints);
        }
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        new ExamHelpers().checkIfPointIsValid(actualPoints,super.getMaxPoints());
        int resultPercent = new ExamHelpers().getExamResultInPercent(actualPoints, getMaxPoints());
        if(resultPercent < 51){
            this.setExamResult(ExamResult.NOT_PASSED);
        }else if (resultPercent >= 51 && resultPercent < 76){
            this.setExamResult(ExamResult.OK);
        }else {
            this.setExamResult(ExamResult.PERFECT);
        }


    }
}
