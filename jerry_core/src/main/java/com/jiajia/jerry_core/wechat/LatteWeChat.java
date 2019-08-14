package com.jiajia.jerry_core.wechat;

import android.app.Activity;

import com.example.chen.latte_core.app.ConfigKeys;
import com.example.chen.latte_core.app.Latte;
import com.example.chen.latte_core.wechat.callbacks.IWeChatSignInCallback;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * @author : jerry
 * @date : 2018/7/23 10:18
 */
public class LatteWeChat {
    public static final String APP_ID = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_ID);
    public static final String APP_SECRET = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_SECRET);
    private final IWXAPI WXAPI;
    private IWeChatSignInCallback mIWeChatSignInCallback = null;

    private static final class Holder {
        private static final LatteWeChat INSTANCE = new LatteWeChat();
    }

    public static LatteWeChat getInstance() {
        return Holder.INSTANCE;
    }

    private LatteWeChat() {
        final Activity activity = Latte.getConfiguration(ConfigKeys.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public IWeChatSignInCallback getIWeChatSignInCallback() {
        return mIWeChatSignInCallback;
    }

    public LatteWeChat onSignInSuccess(IWeChatSignInCallback iWeChatSignInCallback) {
        this.mIWeChatSignInCallback = iWeChatSignInCallback;
        return this;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }
}
