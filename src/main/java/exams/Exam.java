package exams;

public abstract class Exam {

    private final long studentId;
    private final String topic;
    private  int maxPoints;
    private ExamResult examResult;
    private static final int DEFAULT_MAX_POINTS = 100;

    public Exam(long studentId, String topic, int maxPoints) {
        this.studentId = studentId;
        this.topic = topic;
        this.maxPoints = maxPoints;
    }

    public Exam(long studentId, String topic){
        this.studentId = studentId;
        this.topic = topic;
        this.maxPoints = DEFAULT_MAX_POINTS;
    }

    public void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    public abstract void calculateExamResult(int actualPoints);

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getTopic() {
        return topic;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public ExamResult getExamResult() {
        return examResult;
    }
}
