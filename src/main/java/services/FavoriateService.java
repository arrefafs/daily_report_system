package services;

import java.util.List;

import actions.view.FavoriateConverter;
import actions.view.FavoriateView;
import models.Favoriate;

//Favoriateテーブルの操作にかかわるクラス

public class FavoriateService extends ServiceBase {

    //指定した従業員が作成した日報データを、指定されたページ数の一覧画面に表示する分取得しReportViewのリストで返却する

    public List<String> create(FavoriateView fv) {

        createInternal(fv);

        //バリデーションで発生したエラーを返却（エラーがなければ0件の空リスト）
        return null;
    }



    /**
     * idを条件にデータを1件取得する
     * @param id
     * @return 取得データのインスタンス
     */
    private Favoriate findOneInternal(int id) {
        return em.find(Favoriate.class, id);
    }

    /**
     * 日報データを1件登録する
     * @param rv 日報データ
     */
    private void createInternal(FavoriateView fv) {

        em.getTransaction().begin();
        em.persist(FavoriateConverter.toModel(fv));
        em.getTransaction().commit();

    }

}
