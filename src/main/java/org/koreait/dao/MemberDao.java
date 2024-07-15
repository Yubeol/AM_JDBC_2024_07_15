package org.koreait.dao;

import org.koreait.util.DBUtil;
import org.koreait.util.SecSql;

import java.sql.Connection;

public class MemberDao {

    Connection conn;

    public MemberDao(Connection conn) {
        this.conn = conn;
    }

    public boolean isLoginIdDup(Connection conn, String loginId) {
        SecSql sql = new SecSql();

        sql.append("SELECT COUNT(*) > 0");
        sql.append("FROM `member`");
        sql.append("WHERE loginId = ?;", loginId);

        return DBUtil.selectRowBooleanValue(conn, sql);
    }

    public int doJoin(String loginId, String loginPw, String name) {
        SecSql sql = new SecSql();

        sql.append("INSERT INTO `member`");
        sql.append("SET regDate = NOW(),");
        sql.append("updateDate = NOW(),");
        sql.append("loginId = ?,", loginId);
        sql.append("loginPw= ?,", loginPw);
        sql.append("name = ?;", name);

        return DBUtil.insert(conn, sql);
    }
}