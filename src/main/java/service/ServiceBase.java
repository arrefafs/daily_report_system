package service;

import javax.persistence.EntityManager;

import utils.DBUtil;

public class ServiceBase {


    //EntityManagerインスタンス

    protected EntityManager em =DBUtil.creatEntityManager();

//EntityManagerのクローズ
    public void close() {
        if(em.isOpen()) {
            em.close();
        }
    }


}
