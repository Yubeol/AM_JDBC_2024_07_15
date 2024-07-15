package org.koreait;

import org.koreait.controller.ArticleController;
import org.koreait.controller.MemberController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    private int loginAttempts = 0;
    private final int MAX_LOGIN_ATTEMPTS = 3;

    public void run() {
        System.out.println("==프로그램 시작==");
        Scanner sc = new Scanner(System.in);

        while (true) {
            if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                System.out.println("로그인 시도 횟수 초과. 잠시 후 다시 시도해주세요.");
                break;
            }

            System.out.print("명령어 > ");
            String cmd = sc.nextLine().trim();

            Connection conn = null;

            try {
                Class.forName("org.mariadb.jdbc.Driver");
                String url = "jdbc:mariadb://127.0.0.1:3306/AM_JDBC_2024_07?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
                conn = DriverManager.getConnection(url, "root", "");

                int actionResult = action(conn, sc, cmd);

                if (actionResult == -1) {
                    System.out.println("==프로그램 종료==");
                    break;
                }

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("에러: " + e.getMessage());
            } finally {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        sc.close();
        System.out.println("==프로그램 종료==");
    }

    private boolean doLogin(Scanner sc) {
        System.out.print("아이디 입력: ");
        String id = sc.nextLine().trim();
        System.out.print("비밀번호 입력: ");
        String password = sc.nextLine().trim();


        return true;
    }

    private int action(Connection conn, Scanner sc, String cmd) {
        if (cmd.equals("exit")) {
            return -1;
        }

        MemberController memberController = new MemberController(sc, conn);
        ArticleController articleController = new ArticleController(conn, sc);

        if (cmd.equals("login")) {
            boolean loggedIn = doLogin(sc);
            if (!loggedIn) {
                loginAttempts++;
            } else {
                loginAttempts = 0;
            }
        } else if (cmd.equals("logout")) {
            System.out.println("로그아웃 되었습니다.");
            return -1;
        } else if (cmd.equals("member join")) {
            memberController.doJoin();
        } else if (cmd.equals("article write")) {
            articleController.doWrite();
        } else if (cmd.equals("article list")) {
            articleController.showList();
        } else if (cmd.startsWith("article modify")) {
            articleController.doModify(cmd);
        } else if (cmd.startsWith("article detail")) {
            articleController.showDetail(cmd);
        } else if (cmd.startsWith("article delete")) {
            articleController.doDelete(cmd);
        } else {
            System.out.println("사용할 수 없는 명령어");
        }
        return 0;
    }
}
