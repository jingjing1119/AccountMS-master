package patrickstar.com.accountms;

/**
 * Created by 静静 on 17/9/13.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final EditText txtlogin=(EditText)findViewById(R.id.txtLogin);
        Button btnlogin=(Button)findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,MainActivity.class);
                PwdDAO pwdDAO=new PwdDAO(Login.this);
                if((pwdDAO.getCount()==0| pwdDAO.find().getPassword().isEmpty())&&
                        txtlogin.getText().toString().isEmpty()){
                    startActivity(intent);
                }
                else {
                    //判断输入的密码是否与数据库中的密码一致
                    if(pwdDAO.find().getPassword().equals(txtlogin.getText().toString())){
                        startActivity(intent);
                    }
                    else {
                        //弹出信息提示
                        Toast.makeText(Login.this,"请输入正确的密码",Toast.LENGTH_SHORT).show();
                    }
                }
                txtlogin.setText("");

            }
        });
    }
}
