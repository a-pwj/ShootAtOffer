package scut.carson_ho.shootatoffer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 测试用例
        // 功能测试
        System.out.println("功能测试");
        Exam_41Solution test = new Exam_41Solution();
        // 通过循环插入，代表动态从数据流获取数据
        for(int i = 0; i < 10; ++i) {
            test.Insert(i);
            System.out.print(test.GetMedian() + "  ");
        }
        System.out.println();

        // 特殊输入测试：无数据输入
        System.out.println("特殊输入测试");
        Exam_41Solution test1 = new Exam_41Solution();
        System.out.print(test1.GetMedian() + "  ");
    }
}
