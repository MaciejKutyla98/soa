package pl.edu.agh.dao;

import pl.edu.agh.entity.HomeTownEntity;
import pl.edu.agh.soa.model.HomeTown;

public class HomeTownDao {
    public static HomeTownEntity modelToEntity(HomeTown homeTown){
        return  new HomeTownEntity(homeTown.getPostalCode());
    }

    public static  HomeTown entityToModel(HomeTownEntity homeTownEntity){
        return  new HomeTown(homeTownEntity.getPostalCode());
    }
}
