package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.view.EmployeeView;
import actions.view.FavoriateView;
import actions.view.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import services.EmployeeService;
import services.FavoriateService;
import services.ReportService;

public class FavoriateAction extends ActionBase {

    private FavoriateService fservice;
    private ReportService rservice;
    private EmployeeService service;

    //メゾットを実行する
    @Override
    public void process() throws ServletException, IOException {

        fservice = new FavoriateService();
        rservice = new ReportService();
        service = new EmployeeService();

        //メソッドを実行
        invoke();
        fservice.close();
        rservice.close();
        service.close();
    }

    //いいね新規登録
    //* @throws ServletException
    //* @throws IOException

    public void  create() throws ServletException, IOException {

        //セッションからログイン中の従業員情報を取得
        EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);
        ReportView rv = rservice.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));
        //CSRF対策 tokenのチェック



        FavoriateView fv = new FavoriateView(
                null,
                //ログインしている従業員をいいねを押したとして登録する
                ev,
                rv


                );

        forward(ForwardConst.FW_REP_SHOW);
       List<String> errors = fservice.create(fv);


       if(errors.size()>0) {
           putRequestScope(AttributeConst.TOKEN, getTokenId());
           putRequestScope(AttributeConst.FAVORIATE,fv);
           putRequestScope(AttributeConst.ERR, errors);

           forward(ForwardConst.FW_REP_NEW);

       }else {
           redirect(ForwardConst.ACT_REP, ForwardConst.CMD_INDEX);
       }





        }}
    //いいね詳細
    //@throws ServletException
    //@throws IOException
    //













