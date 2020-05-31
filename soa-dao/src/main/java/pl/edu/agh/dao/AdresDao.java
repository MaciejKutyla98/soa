package pl.edu.agh.dao;

import pl.edu.agh.entity.AdresEntity;
import pl.edu.agh.soa.model.Adres;

public class AdresDao {
    public static AdresEntity modelToEntity(Adres adres){
        return new AdresEntity(adres.getAdres());
    }

    public static Adres entityToModel(AdresEntity adresEntity){
        return new Adres(adresEntity.getAdres());
    }
}
