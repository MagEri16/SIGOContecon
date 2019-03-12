package com.calymayor.sigoContecon.interactors;

import java.util.List;

import com.calymayor.sigoContecon.daos.VistaDao;
import com.calymayor.sigoContecon.modelos.Usuario;
import com.calymayor.sigoContecon.modelos.Vista;
import com.calymayor.sigoContecon.services.SigoConteconService;
import com.calymayor.sigoContecon.daos.UsuarioDao;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by etorres on 28/02/17.
 */

public class ServiceManagerInteractor {

    public static SigoConteconService mService;
    public static UsuarioDao mUsuarioDao;
    public  static List<Usuario> listaUsuarios;


    public ServiceManagerInteractor() {
        mService = new SigoConteconService();
        //listaReportes = new ArrayList<ReporteDiario>();
    }


    //Métodos GET
    //Personal
    public void getUsuariosFromWebService(final UsuarioDao mUsuarioDao) {
        System.out.println("dentro del getPostsFromWebService de TiposEnsayos");
        mService.getApi().getUsuarios().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Usuario>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted Usuarios");

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                        System.out.println(e.getLocalizedMessage());
                        System.out.println("No se porque me mandó aquí");


                    }

                    @Override
                    public void onNext(List<Usuario> usuarios) {
                        System.out.println("Estos son Usuarios " + usuarios.size());
                        insertUsuariosToLocalDB(usuarios, mUsuarioDao);
                    }
                });
    }

    public void insertUsuariosToLocalDB(List<Usuario> usuarios, UsuarioDao mUsuarioDao) {
        System.out.println("dentro del insertUsuariosToLocalDB");
        mUsuarioDao.addUsuarios(usuarios);
        System.out.println("al final del insertUsuariosEnsayoToLocalDB");
    }

/*-----------------Vistas--------------*/

    //Métodos GET
    public void getVistasFromWebService(final VistaDao mVistaDao) {
        System.out.println("dentro del getPostsFromWebService de TiposEnsayos");
        mService.getApi().getVistas().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Vista>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted Usuarios");

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                        System.out.println(e.getLocalizedMessage());
                        System.out.println("No se porque me mandó aquí");


                    }

                    @Override
                    public void onNext(List<Vista> vistas) {
                        System.out.println("Tengo estas vistas " + vistas.size());
                        insertVistasToLocalDB(vistas, mVistaDao);
                    }
                });
    }

    public void insertVistasToLocalDB(List<Vista> vistas, VistaDao mVistaDao) {
        System.out.println("dentro del insertVistasToLocalDB");
        mVistaDao.addVistas(vistas);
        System.out.println("al final del insertVistasToLocalDB");
    }


}
