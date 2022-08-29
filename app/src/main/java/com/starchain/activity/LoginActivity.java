package com.starchain.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.starchain.R;
import com.starchain.utils.Util_Pattern;

public class LoginActivity extends BaseActivity{

    private boolean is_agree;
    private EditText account_input;
    private EditText password_input;

    /**
     * 定义页面初始化时的行为
     * @param savedInstanceState android.os.Bundle
     */
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.is_agree = false;

        RadioButton agreement_button = findViewById(R.id.agreement_button);
        TextView agreement_Link = findViewById(R.id.agreement_link);
        agreement_Link.setText(Util_Pattern.get_agreement_Span(this));
        agreement_Link.setMovementMethod(LinkMovementMethod.getInstance());
        agreement_button.setOnClickListener(v -> {
            this.is_agree = !this.is_agree;
            ((RadioButton) v).setChecked(this.is_agree);
        });

    }

}
