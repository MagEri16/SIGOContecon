package com.calymayor.sigoContecon.daos.interfaces;

import java.util.List;

import com.calymayor.sigoContecon.modelos.Vista;

/**
 * Created by etorres on 26/01/17.
 */

public interface IVistaDao {
    public Vista fetchVistaById(int vistaId);
    public List<Vista> fetchAllVistas();
    // add vista
    public boolean addVista(Vista vista);
    // add vistas in bulk
    public boolean addVistas(List<Vista> vistas);
    public boolean deleteAllVistas();
}
