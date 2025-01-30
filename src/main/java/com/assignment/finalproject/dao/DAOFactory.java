package com.assignment.finalproject.dao;

import com.assignment.finalproject.dao.custom.Impl.mainMOdel.*;
import com.assignment.finalproject.dao.custom.Impl.subModel.*;


public class DAOFactory {
    private static DAOFactory daoFactory;

    public static DAOFactory getInstance() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        ADDEXAMLIST, ADDMARK, ADDPARENT, EXAMSCHEDULE, EXAMSUBJECT,
        LOGIN, MANAGEMARK, MANAGEEXAM, QUERY, SENDMAIL, SIGNIN,
        STUDENTMANAGE, CLASS, HALL, SUBJECT
    }

   public SuperDAO getDAO(DAOTypes types) {
       switch (types) {
           case ADDEXAMLIST:
               return new AddExamListImpl();
           case ADDMARK:
               return new AddMarkImpl();
           case ADDPARENT:
               return new AddParentImpl();
           case EXAMSCHEDULE:
               return new ExamShedulImpl();
           case EXAMSUBJECT:
               return new ExamSubjectImpl();
           case LOGIN:
               return new LoginImpl();
           case MANAGEMARK:
               return new ManageMarkImpl();
           case MANAGEEXAM:
               return new ManageExamImpl();
           case QUERY:
               return new QueryImpl();
           case SENDMAIL:
               return new SendMailImpl();
           case SIGNIN:
               return new SigninImpl();
           case STUDENTMANAGE:
               return new StudentManageImpl();
           case CLASS:
               return new ClassImpl();
           case HALL:
               return new HallImpl();
           case SUBJECT:
               return new SubjectImpl();
           default:
               return null;
       }
   }
}