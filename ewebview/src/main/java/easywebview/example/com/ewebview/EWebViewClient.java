package easywebview.example.com.ewebview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by v_chicunxiang on 2018/3/8.
 *
 * @史上最帅无敌创建者 ccx
 * @创建时间 2018/3/8 10:50
 */

public class EWebViewClient extends WebViewClient {


    private Context context;

    public EWebViewClient() {
        super();
    }

    public EWebViewClient(Context context) {
        super();
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url == null)
            return false;

        try {
            if (url.startsWith("http:") || url.startsWith("https:")) {
                view.loadUrl(url);
                return true;
            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(intent);
                return true;
            }
        } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
            return false;
        }

    }

}
