package org.koreait.container;

import org.koreait.Controller.ArticleController;
import org.koreait.Controller.MemberController;
import org.koreait.dao.ArticleDao;
import org.koreait.dao.MemberDao;
import org.koreait.Service.ArticleService;
import org.koreait.service.MemberService;
import org.koreait.session.Session;

import java.sql.Connection;
import java.util.Scanner;

public class Container {

    public static ArticleController articleController;
    public static MemberController memberController;

    public static ArticleService articleService;
    public static MemberService memberService;

    public static ArticleDao articleDao;
    public static MemberDao memberDao;

    public static Scanner sc;

    public static Connection conn;

    public static Session session;

    public static void init() {
        sc = new Scanner(System.in);

        session = new Session();

        articleDao = new ArticleDao();
        memberDao = new MemberDao();

        articleService = new ArticleService();
        memberService = new MemberService();

        articleController = new ArticleController();
        memberController = new MemberController();
    }

}
