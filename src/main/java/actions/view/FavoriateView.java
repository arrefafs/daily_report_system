package actions.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Getter
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
public class FavoriateView {

    /*
     * id
     */

    // TODO 自動生成されたコンストラクター・スタブ

    private Integer id;

    /*
     * いいね押した従業員
     */

    private EmployeeView employee;

    /*
     * どの日報が押されたか
     */

    private ReportView report;

}

