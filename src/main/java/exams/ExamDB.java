package exams;

import java.util.ArrayList;
import java.util.List;

public class ExamDB {

    private List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int actualPoints) {
        exam.calculateExamResult(actualPoints);
        exam.setExamResult(exam.getExamResult());
        exams.add(exam);
    }

    public int countPassedExams() {
        return (int) exams
                .stream()
                .filter(exam -> !exam.getExamResult().equals(ExamResult.NOT_PASSED))
                .count();
    }


    public List<Exam> findById(long studentId){
        return exams
                .stream()
                .filter(exam -> exam.getStudentId() == studentId)
                .toList();
    }

    public List<String> findTopicByPrefix(String prefix) {
        return exams
                .stream()
                .map(Exam::getTopic)
                .filter(s -> s.startsWith(prefix))
                .distinct()
                .toList();
    }


    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }


}
