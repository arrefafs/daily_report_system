package views;

import java.util.ArrayList;
import java.util.List;

import constants.AttributeConst;
import constants.jpaConst;
import models.Employee;

//従業員データのDTOモデル、Viewモデルの変換を行うクラス

public class EmployeeConverter {


    //ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
    //@param evEmployeeViewのインスタンス
    //@return Employeeのインスタンス

    public static Employee toModel(EmployeeView ev) {


        return new Employee(

                ev.getId(),
                ev.getCode(),
                ev.getName(),
                ev.getPassword(),
                ev.getAdminFlag() == null
                        ? null
                        : ev.getAdminFlag() == jpaConst.ROLE_ADMIN
                                ? AttributeConst.ROLE_ADMIN.getIntegerValue()
                                : AttributeConst.ROLE_GENERAL.getIntegerValue(),
                ev.getCreatedAt(),
                ev.getUpdatedAt(),
                ev.getDeleteFlag() == null
                        ? null
                        : ev.getDeleteFlag() == AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                                ? jpaConst.EMP_DEL_TRUE
                                : jpaConst.EMP_DEL_FALSE);



               }


    public static EmployeeView toView(Employee e) {

        if(e == null) {
            return null;
        }

        return new EmployeeView(

                e.getId(),
                e.getCode(),
                e.getName(),
                e.getPassword(),
                e.getAdminFlag() == null
                       ? null
                       :  e.getAdminFlag() == jpaConst.ROLE_ADMIN
                       ? AttributeConst.ROLE_ADMIN.getIntegerValue()
                       : AttributeConst.ROLE_GENERAL.getIntegerValue(),
       e.getCreatedAt(),
       e.getUpdatedAt(),
       e.getDeleteFlag() == null
               ? null
               : e.getDeleteFlag() == jpaConst.EMP_DEL_TRUE
                       ? AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                       : AttributeConst.DEL_FLAG_FALSE.getIntegerValue());
}

/**
* DTOモデルのリストからViewモデルのリストを作成する
* @param list DTOモデルのリスト
* @return Viewモデルのリスト
*/
public static List<EmployeeView> toViewList(List<Employee> list) {
List<EmployeeView> evs = new ArrayList<>();

for (Employee e : list) {
   evs.add(toView(e));
}

return evs;
}

/**
* Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
* @param e DTOモデル(コピー先)
* @param ev Viewモデル(コピー元)
*/
public static void copyViewToModel(Employee e, EmployeeView ev) {
e.setId(ev.getId());
e.setCode(ev.getCode());
e.setName(ev.getName());
e.setPassword(ev.getPassword());
e.setAdminFlag(ev.getAdminFlag());
e.setCreatedAt(ev.getCreatedAt());
e.setUpdatedAt(ev.getUpdatedAt());
e.setDeleteFlag(ev.getDeleteFlag());



}











    }





