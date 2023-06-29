package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.view.EmployeeView;
import actions.view.FavoriateView;
import actions.view.ReportView;
import constants.AttributeConst;
import services.FavoriateService;

public class FavoriateAction extends ActionBase {

    private FavoriateService service;

    //メゾットを実行する
    @Override
    public void process() throws ServletException, IOException {

        service = new FavoriateService();

        //メソッドを実行
        invoke();
        service.close();
    }

    //いいね新規登録
    //* @throws ServletException
    //* @throws IOException

    public void create() throws ServletException, IOException {

        //セッションからログイン中の従業員情報を取得
        EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);
        ReportView rv = (ReportView) getSessionScope(AttributeConst.FEP_EMPLOYEE_ID);

        //パラメータの値をもとにFavoriateインスタンスを作成する
        FavoriateView fv = new FavoriateView(
                null, //ログインしている従業員をいいねを押したとして登録する
                ev,
                rv);

        //いいね情報取得
        List<String> errors = service.create(fv);
    }
    //いいね詳細
    //@throws ServletException
    //@throws IOException
    //







    }



