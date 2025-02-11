package com.assignment.finalproject.bo;

import com.assignment.finalproject.bo.custom.impl.MainBOImpl.*;
import com.assignment.finalproject.bo.custom.impl.subBOImpl.HAllBOImpl;
import com.assignment.finalproject.bo.custom.impl.subBOImpl.SubjectBOImpl;

public class BOFactory {

    private static BOFactory boFactory;
    private BOFactory() {};
    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    public enum BOType {
        ADDEXAMLIST, ADDMARK, ADDPARENT, EXAMSCHEDULE, EXAMSUBJECT,
        LOGIN, MANAGEMARK, MANAGEEXAM, QUERY, SENDMAIL, SIGNIN,
        STUDENTMANAGE, CLASS, HALL, SUBJECT
    }

    public SuperBO getBO(BOType types) {
        switch (types) {
            case ADDEXAMLIST:
                return new AddExamListBOImpl();
            case ADDMARK:
                return new AddMarkBOImpl();
            case ADDPARENT:
                return new AddPararentBOImpl();
            case EXAMSCHEDULE:
                return new ExamShedulBOImpl();
            case EXAMSUBJECT:
                return new ExamShedulBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            case MANAGEMARK:
                return new ManageMarkBOImpl();
            case MANAGEEXAM:
                return new ManageExamBOImpl();
            case QUERY:
                return new QueryBOImpl();
            case SENDMAIL:
                return new SendMailBOImpl();
            case SIGNIN:
                return new SigninBOImpl();
            case SUBJECT:
                return new SubjectBOImpl();
            case HALL:
                return new HAllBOImpl();
        }
        return null;
    }
}
