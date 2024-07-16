package org.koreait.Service;

import org.koreait.container.Container;
import org.koreait.dao.ArticleDao;
import org.koreait.dto.Article;

import java.util.List;
import java.util.Map;

public class ArticleService {

    private ArticleDao articleDao;

    public ArticleService() {
        this.articleDao = Container.articleDao;
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