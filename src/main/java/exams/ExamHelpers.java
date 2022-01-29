package exams;

public class ExamHelpers {

    public void checkIfPointIsValid(int points, int maxPoints) {
        if(  points < 0 || points > maxPoints) {
            throw new IllegalArgumentException("Actual points must be between 0  and Max Points");
        }
    }

    public int getExamResultInPercent(int actualPoints, int maxPoints){
       return (int)(actualPoints / (maxPoints/ 100.0));
    }
}
