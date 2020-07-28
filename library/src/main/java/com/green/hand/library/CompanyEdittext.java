package com.green.hand.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.EditText;
import android.text.TextUtils;

/**
 * @author OneGreenHand
 * @package com.green.hand.companyedittext
 * @fileName CompanyEdittext
 * @data on 2019/1/2 17:15
 * @describe 带单位的输入框
 */
@SuppressLint("AppCompatCustomView")
public class CompanyEdittext extends EditText {

    private Context context;
    private String ceText;//文本内容
    private int ceColor;//文字颜色

    public CompanyEdittext(Context context) {
        super(context);
        this.context = context;
        initView(null);
    }

    public CompanyEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(attrs);
    }

    public CompanyEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(attrs);
    }


    private void initView(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CompanyEdittext);
            ceText = array.getString(R.styleable.CompanyEdittext_ce_text);
            ceColor = array.getColor(R.styleable.CompanyEdittext_ce_text_color,0);
            array.recycle();
        }
        addTextChangedListener(textWatcher);
    }


    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (ceText.trim().isEmpty())
                return;
            if (!TextUtils.isEmpty(s.toString())) {
                removeTextChangedListener(this);//移除输入监听
                if (s.toString().trim().equals(ceText)) {
                    setText("");
                } else {
                    String str = s.toString().replace(ceText, "") + ceText;//去重
                    //设置文字颜色
                    if (ceColor != 0) {
                        SpannableStringBuilder builder = new SpannableStringBuilder(str);
                        builder.setSpan(new ForegroundColorSpan(ceColor), str.length() - ceText.length(), str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        setText(builder);
                    } else
                        setText(str);
                }
                addTextChangedListener(this);
            }
        }
    };

    //设置光标位置
    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (!getText().toString().isEmpty() && selEnd == getText().toString().length()) {
            setSelection(getText().toString().length() - ceText.length());
        } else {
            setSelection(selStart);
        }
    }

}
