/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadePackage;

import entityPackage.Lignecommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Antoine
 */
@Local
public interface LignecommandeFacadeLocal {

    void create(Lignecommande lignecommande);

    void edit(Lignecommande lignecommande);

    void remove(Lignecommande lignecommande);

    Lignecommande find(Object id);

    List<Lignecommande> findAll();

    List<Lignecommande> findRange(int[] range);

    int count();
    
}
