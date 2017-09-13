package patrickstar.com.accountms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 静静 on 17/9/13.
 */

public class Sysset extends AppCompatActivity {

    EditText txtpwd;
    Button btnSet,btnsetCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sysset);

        txtpwd=(EditText)findViewById(R.id.txtPwd);
        btnSet=(Button)findViewById(R.id.btnSet);
        btnsetCancel=(Button)findViewById(R.id.btnsetCancel);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                PwdDAO pwdDAO=new PwdDAO(Sysset.this);
                Tb_pwd tb_pwd=new Tb_pwd(txtpwd.getText().toString());
                if(pwdDAO.getCount()==0){
                    pwdDAO.add(tb_pwd);
                }
                else {
                    pwdDAO.update(tb_pwd);

                }

                //弹出信息提示
                Toast.makeText(Sysset.this,"［密码］设置成功！",Toast.LENGTH_SHORT).show();

            }
        });

        btnsetCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                txtpwd.setText("");
                txtpwd.setHint("请输入密码");

            }
        });
    }
}
