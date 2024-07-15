package org.koreait.controller;

import org.koreait.service.MemberService;

import java.sql.Connection;
import java.util.Scanner;

public class MemberController {
    private Connection conn;
    private Scanner sc;

    private MemberService memberService;

    public MemberController(Scanner sc, Connection conn) {
        this.sc = sc;
        this.conn = conn;
        this.memberService = new MemberService(conn);
    }

    public void doJoin() {
        String loginId = null;
        String loginPw = null;
        String loginPwConfirm = null;
        String name = null;

        System.out.println("==회원가입==");
        while (true) {
            System.out.print("로그인 아이디 : ");
            loginId = sc.nextLine().trim();

            if (loginId.length() == 0 || loginId.contains(" ")) {
                System.out.println("아이디 똑바로 써");
                continue;
            }

            boolean isLoindIdDup = memberService.isLoginIdDup(conn, loginId);

            if (isLoindIdDup) {
                System.out.println(loginId + "는(은) 이미 사용중");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("비밀번호 : ");
            loginPw = sc.nextLine().trim();

            if (loginPw.length() == 0 || loginPw.contains(" ")) {
                System.out.println("비번 똑바로 입력해");
                continue;
            }

            boolean loginPwCheck = true;

            while (true) {
                System.out.print("비밀번호 확인 : ");
                loginPwConfirm = sc.nextLine().trim();

                if (loginPwConfirm.length() == 0 || loginPwConfirm.contains(" ")) {
                    System.out.println("비번 확인 똑바로 써");
                    continue;
                }
                if (loginPw.equals(loginPwConfirm) == false) {
                    System.out.println("일치하지 않아");
                    loginPwCheck = false;
                }
                break;
            }
            if (loginPwCheck) {
                break;
            }
        }

        while (true) {
            System.out.print("이름 : ");
            name = sc.nextLine();

            if (name.length() == 0 || name.contains(" ")) {
                System.out.println("이름 똑바로 써");
                continue;
            }
            break;
        }


        int id = memberService.doJoin(loginId, loginPw, name);

        System.out.println(id + "번 회원이 생성되었습니다");
    }
}