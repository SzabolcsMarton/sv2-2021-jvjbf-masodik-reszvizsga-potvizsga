package exams;

public class MultipleChoiceExam extends Exam{

    private static final int LIMIT_TO_PASS = 51;

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        new ExamHelpers().checkIfPointIsValid(actualPoints,getMaxPoints());
        int resultPercent = new ExamHelpers().getExamResultInPercent(actualPoints, getMaxPoints());
        if( resultPercent>= LIMIT_TO_PASS){
            this.setExamResult(ExamResult.PASSED);
        }else {
            this.setExamResult(ExamResult.NOT_PASSED);
        }
    }
}
