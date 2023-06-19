package services;

import java.util.List;

import actions.view.FavoriateView;
import actions.view.ReportView;
import constants.JpaConst;
import models.Favoriate;
import models.Report;


//Favoriateテーブルの操作にかかわるクラス

public class FavoriateService extends ServiceBase{





    //指定した日報データを、指定した
public List<FavoriateView> getMinePerPage(ReportView report, int page){

    List<Favoriate> favoriates = em.createNamedQuery(JpaConst.Q_REP_COUNT_ALL_MINE, Report.class)
            )
}



}
