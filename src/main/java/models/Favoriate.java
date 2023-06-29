package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//いいねのDTOモデル

@Table(name = JpaConst.TABLE_FEP)
@NamedQueries({
        @NamedQuery(name = JpaConst.Q_FEP_GET_ALL, query = JpaConst.Q_FEP_GET_ALL_DEF),
        @NamedQuery(name = JpaConst.Q_FEP_COUNT, query = JpaConst.Q_FEP_COUNT_DEF),
        @NamedQuery(name = JpaConst.Q_FEP_COUNT_ALL_MINE, query = JpaConst. Q_FEP_COUNT_ALL_MINE_DEF),

})

@Getter
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity

public class Favoriate {
    /*
     * id
     */

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*
     * favoriate
     */

    /**
     * 日報を登録した従業員
     */
    @ManyToOne
    @JoinColumn(name = JpaConst.REP_COL_EMP, nullable = false)
    private Employee employee;

    /*
     *report_id
     */

    @ManyToOne
    @JoinColumn(name = JpaConst.FEP_COL_REPORT_ID, nullable = false)
    private Report report;

}
