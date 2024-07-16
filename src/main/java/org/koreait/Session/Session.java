package org.koreait.session;

import org.koreait.dto.Member;

public class Session {
    public Member loginedMember;
    public int loginedMemberId;

    public Session() {
        loginedMember = null;
        loginedMemberId = -1;
    }
}