package actions.view;

import java.util.ArrayList;
import java.util.List;

import models.Favoriate;

/*
 *
 * FavoriateのDTOモデルからViewモデルの変換を行うクラス
 *
 */

public class FavoriateConverter {

    /*
     *
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param fv FavoriateViewのインスタンス
     * @return Favoriteのインスタンス
     */

    public static Favoriate toModel(FavoriateView fv) {
        return new Favoriate(
                fv.getId(),
                EmployeeConverter.toModel(fv.getEmployee()),
                ReportConverter.toModel(fv.getReport()));

    }

    // *DTOモデルのインスタンスからViewモデルのインスタンスを作成する
    // *@param f Favoriateのインスタンス
    // *@return  FavoriateViewのインスタンス
    //*

    public static FavoriateView toView(Favoriate f) {
        // TODO 自動生成されたメソッド・スタブ
        if (f == null) {
            return null;
        }

        return new FavoriateView(
                f.getId(),
                EmployeeConverter.toView(f.getEmployee()),
                ReportConverter.toView(f.getReport()));
    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<FavoriateView> toViewList(List<Favoriate> list) {
        List<FavoriateView> evs = new ArrayList<>();

        for (Favoriate f : list) {
            evs.add(toView(f));
        }

        return evs;
    }

}
