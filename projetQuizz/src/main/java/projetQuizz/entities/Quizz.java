package projetQuizz.entities;


public class Quizz {
    private Theme theme;
    
    private Question questions;

    public Quizz() {
    }

    public Quizz(Theme theme, Question questions) {
        this.theme = theme;
        this.questions = questions;
    }


    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Question getQuestions() {
        return questions;
    }

    public void setQuestion(Question questions) {
        this.questions = questions;
    }
    
}
