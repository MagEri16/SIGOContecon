package com.calymayor.sigoContecon.daos.interfaces;

import java.util.List;

import com.calymayor.sigoContecon.modelos.Usuario;

/**
 * Created by etorres on 26/01/17.
 */

public interface IUsuarioDao {
    public Usuario fetchUsuarioById(int usuarioId);
    public List<Usuario> fetchAllUsuarios();
    // add personal
    public boolean addUsuario(Usuario usuario);
    // add usuarios in bulk
    public boolean addUsuarios(List<Usuario> usuarios);
    public boolean deleteAllUsuarios();
}
