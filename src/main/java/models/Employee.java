package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.jpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//従業員データのDTOモデル


@Table(name = jpaConst.TABLE_EMP)
@NamedQueries({

        @NamedQuery(
                name = jpaConst.Q_EMP_GET_ALL,
                query = jpaConst.Q_EMP_GET_ALL_DEF),
        @NamedQuery(
                name = jpaConst.Q_EMP_COUNT,
                query = jpaConst.Q_EMP_COUNT_DEF),
        @NamedQuery(
                name = jpaConst.Q_EMP_COUNT_REGISTERED_BY_CODE,
                query = jpaConst.Q_EMP_COUNT_REGISTERED_BY_CODE_DEF),
        @NamedQuery(
                name = jpaConst.Q_EMP_GET_BY_CODE_AND_PASS,
                query = jpaConst.Q_EMP_GET_BY_CODE_AND_PASS_DEF)
    })

    @Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
    @Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
    @NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
    @AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
    @Entity

public class Employee {


    @Id
    @Column(name = jpaConst.EMP_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = jpaConst.EMP_COL_CODE, nullable = false,unique = true)
    private String code;


    @Column(name = jpaConst.EMP_COL_NAME, nullable = false)
    private String name;

    @Column(name = jpaConst.EMP_COL_PASS,length =64, nullable = false)
    private String password;

    //管理権限があるかどうか
    @Column(name = jpaConst.EMP_COL_ADMIN_FLAG, nullable = false)
    private Integer adminFlag;


    @Column(name = jpaConst.EMP_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;


    @Column(name = jpaConst.EMP_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = jpaConst.EMP_COL_DELETE_FLAG, nullable = false)
    private Integer deleteFlag;







}
