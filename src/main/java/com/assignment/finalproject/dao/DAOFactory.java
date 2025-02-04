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
               return new AddExamListDAOImpl();
           case ADDMARK:
               return new AddMarkDAOImpl();
           case ADDPARENT:
               return new AddParentDAOImpl();
           case EXAMSCHEDULE:
               return new ExamShedulDAOImpl();
           case EXAMSUBJECT:
               return new ExamSubjectDAOImpl();
           case LOGIN:
               return new LoginDAOImpl();
           case MANAGEMARK:
               return new ManageMarkDAOImpl();
           case MANAGEEXAM:
               return new ManageExamDAOImpl();
           case QUERY:
               return new QueryDAOImpl();
           case SENDMAIL:
               return new SendMailDAOImpl();
           case SIGNIN:
               return new SigninDAOImpl();
           case STUDENTMANAGE:
               return new StudentManageDAOImpl();
           case CLASS:
               return new ClassDAOImpl();
           case HALL:
               return new HallDAOImpl();
           case SUBJECT:
               return new SubjectDAOImpl();
           default:
               return null;
       }
   }
}