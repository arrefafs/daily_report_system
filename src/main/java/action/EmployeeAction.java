package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import constants.AttributeConst;
import constants.ForwardConst;
import constants.MessageConst;
import constants.PropertyConst;
import constants.jpaConst;
import service.EmployeeService;
import views.EmployeeView;

//従業員に関わる処理を行うActionクラス

public class EmployeeAction extends ActionBase {

    private EmployeeService service;

    //メゾットを実行する

    @Override
    public void process() throws ServletException,IOException{

        service = new EmployeeService();

        //メゾットを実行
        invoke();

        service.close();
    }


    //一覧画面を表示する

    public void index() throws ServletException, IOException {

        //指定されたページ数の一覧画面に表示するデータを取得
        int page = getPage();
        List<EmployeeView> employees = service.getPerPage(page);
        //全ての従業員データの件数を取得
        long employeeCount = service.countAll();


        putRequestScope(AttributeConst.EMPLOYEES,employees);//取得した従業員データ
        putRequestScope(AttributeConst.EMP_COUNT, employeeCount);//全ての従業員データの件数
        putRequestScope(AttributeConst.PAGE,page);//ページ数
        putRequestScope(AttributeConst.MAX_ROW, jpaConst.ROW_PER_PAGE);

    }
        public void entryNew() throws ServletException, IOException {

            putRequestScope(AttributeConst.TOKEN,getTokenId());
            putRequestScope(AttributeConst.EMPLOYEE,new EmployeeView());

        }

        public void create() throws ServletException, IOException{

            //CSRF対策 tokenのチェック
            if(checkToken()) {

                EmployeeView ev = new EmployeeView(
                        null,
                        getRequestParam(AttributeConst.EMP_CODE),
                        getRequestParam(AttributeConst.EMP_NAME),
                        getRequestParam(AttributeConst.EMP_PASS),
                        toNumber(getRequestParam(AttributeConst.EMP_ADMIN_FIG)),
                        null,
                        null,
                        AttributeConst.DEL_FLAG_FALSE.getIntegerValue());

                        //アプリケーションスコープからpepper文字列を取得
                        String pepper = getContextScope(PropertyConst.PEPPER);

                        //従業員情報登録
                        List<String> errors = service.create(ev, pepper);

                        if(errors.size()>0) {


                            //登録中にエラーがあった場合

                            putRequestScope(AttributeConst.TOKEN, getTokenId());//CSRF対策用トークン
                            putRequestScope(AttributeConst.EMPLOYEE,ev);//入力された従業員情報
                            putRequestScope(AttributeConst.ERR,errors);//エラーのリスト


                            //新規登録画面を再表示
                            forward(ForwardConst.FW_EMP_NEW);
                        }else {
                            putSessionScope(AttributeConst.FLUSH,MessageConst.I_REGISTERED.getMessage());

                            redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_INDEX);









































                        }









            }






        //セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
        String flush = getSessionScope(AttributeConst.FLUSH);
        if(flush != null) {
            putRequestScope(AttributeConst.FLUSH,flush);
            removeSessionScope(AttributeConst.FLUSH);
        }
        forward(ForwardConst.FW_EMP_INDEX);

    }

}
