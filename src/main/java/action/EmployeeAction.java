package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import constants.AttributeConst;
import constants.ForwardConst;
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


        //セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
        String flush = getSessionScope(AttributeConst.FLUSH);
        if(flush != null) {
            putRequestScope(AttributeConst.FLUSH,flush);
            removeSessionScope(AttributeConst.FLUSH);
        }
        forward(ForwardConst.FW_EMP_INDEX);

    }

}