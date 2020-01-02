package com.humanup.matrix.qcm.dao.entities;


import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerId", updatable = false, nullable = false)
    private Long answerId;
    private String emailPerson;

    @OneToOne(optional = false)
    @JoinColumn(name = "choice_id", nullable = false)
    private Choice choice;


    public Answer(Choice choice, String emailPerson) {
        this.choice = choice;
        this.emailPerson = emailPerson;
    }

    public Answer() {
    }

    public Long getAnswerId() {
        return answerId;
    }

    public Choice getChoice() {
        return choice;
    }

    public String getEmailPerson() {
        return emailPerson;
    }

    public static class Builder{
        private long answerId;
        private Choice choice;
        private String emailPerson;

        public Builder(){
        }

        public Answer.Builder setAnswerId(long answerId){
            this.answerId = answerId;
            return this;
        }

        public Answer.Builder setChoice(Choice choice){
            this.choice = choice;
            return this;
        }

        public Answer.Builder setEmailPerson(String emailPerson){
            this.emailPerson = emailPerson;
            return this;
        }
        public Answer build(){ return new Answer(choice, emailPerson);}
    }
}
