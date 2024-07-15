package org.koreait.service;

import org.koreait.Article;
import org.koreait.dao.ArticleDao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ArticleService {

    private ArticleDao articleDao;

    public ArticleService(Connection conn) {
        this.articleDao = new ArticleDao(conn);
    }

    public int doWrite(String title, String body) {
        return articleDao.doWrite(title, body);

    }

    public List<Article> getArticles() {
        return articleDao.getArticles();
    }

    public Map<String, Object> getArticleById(int id) {
        return articleDao.getArticleById(id);
    }

    public void doUpdate(int id, String title, String body) {
        articleDao.doUpdate(id, title, body);
    }

    public void doDelete(int id) {
        articleDao.doDelete(id);
    }
}