package main;
import connect.JdbcModel;
import connect.ObjectFactoryForConnect;
import connect.SampleObject;

import java.util.Map;
import java.util.Scanner;

public class testConnect {
    public static void main(String[] args) {
        JdbcModel jm = new JdbcModel();
        var flg = true;
        String select;
        while (flg) {
            System.out.println("0:quit 1:insert 2:selectAll 3:selectUnit 4:update 5:deleteAll 6:deleteUnit");
            select = new Scanner(System.in).nextLine();
            switch (select) {
                case "0":
                    System.out.println("終了");
                    flg = false;
                    break;
                case "1":
                    System.out.println("挿入");
                    boolean isInsert = jm.insert(ObjectFactoryForConnect.create());
                    System.out.println("isInsert:" + isInsert);
                    break;
                case "2":
                    System.out.println("すべて選択");
                    Map<String, SampleObject> soMap = jm.selectAll();
                    soMap.entrySet().forEach(System.out::println);
                    break;
                case "3":
                    System.out.println("単体選択");
                    System.out.println("表示する対象のIDを入力してください。");
                    select = new Scanner(System.in).nextLine();
                    System.out.println(jm.selectUnit(select));
                    break;
                case "4":
                    System.out.println("選択してアップデート");
                    System.out.println("updateする対象のIDを入力してください。");
                    select = new Scanner(System.in).nextLine();
                    jm.update(select);
                    break;
                case "5":
                    System.out.println("テーブル初期化");
                    jm.deleteAll();
                    break;
                case "6":
                    System.out.println("単体削除");
                    System.out.println("updateする対象のIDを入力してください。");
                    select = new Scanner(System.in).nextLine();
                    jm.deleteUnit(select);
                    break;
            }
        }
    }
}
