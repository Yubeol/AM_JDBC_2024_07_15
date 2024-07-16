package org.koreait.service;

import org.koreait.container.Container;
import org.koreait.dao.MemberDao;
import org.koreait.dto.Member;

public class MemberService {

    private MemberDao memberDao;

    public MemberService() {
        this.memberDao = Container.memberDao;
    }

    public boolean isLoginIdDup(String loginId) {
        return memberDao.isLoginIdDup(loginId);
    }

    public int doJoin(String loginId, String loginPw, String name) {
        return memberDao.doJoin(loginId, loginPw, name);
    }

    public Member getMemberByLoginId(String loginId) {
        return memberDao.getMemberByLoginId(loginId);
    }
}