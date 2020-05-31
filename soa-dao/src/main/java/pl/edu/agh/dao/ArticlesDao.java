package pl.edu.agh.dao;

import pl.edu.agh.entity.ArticlesEntity;
import pl.edu.agh.soa.model.Articles;

public class ArticlesDao {
    public static ArticlesEntity modelToEntity(Articles articles){
        return new ArticlesEntity(articles.getTittle());
    }

    public static  Articles entityToModel(ArticlesEntity articlesEntity ){
        return new Articles(articlesEntity.getTittle());
    }
}
