/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Traductioncategorie;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antoine
 */
@Stateless
public class TraductioncategorieFacade extends AbstractFacade<Traductioncategorie> implements TraductioncategorieFacadeLocal {
    @PersistenceContext(unitName = "SiteWebNoel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TraductioncategorieFacade() {
        super(Traductioncategorie.class);
    }

    @Override
    public ArrayList<model.Categorie> getCategoryByLanguage(int langue) {
        ArrayList<model.Categorie> list = new ArrayList<>();
        list.add(new model.Categorie("Sapins"));
        list.add(new model.Categorie("Boules de noel"));
        list.add(new model.Categorie("Guirlandes"));
        list.add(new model.Categorie("Luminaires"));
        list.add(new model.Categorie("Etoiles"));
        return list;
    }
}
