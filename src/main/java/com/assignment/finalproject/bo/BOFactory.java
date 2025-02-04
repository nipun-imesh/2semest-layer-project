package com.assignment.finalproject.bo;

import com.assignment.finalproject.bo.custom.impl.MainBOImpl.AddExamListBOImpl;
import com.assignment.finalproject.bo.custom.impl.MainBOImpl.AddMarkBOImpl;

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
                return null;
            case EXAMSCHEDULE:
                return null;
            case EXAMSUBJECT:
                return null;
            case LOGIN:
                return null;
            case MANAGEMARK:
                return null;
            case MANAGEEXAM:
                return null;
            case QUERY:
                return null;
            case SENDMAIL:
                return null;
            case SIGNIN:}
        return null;
    }
}
