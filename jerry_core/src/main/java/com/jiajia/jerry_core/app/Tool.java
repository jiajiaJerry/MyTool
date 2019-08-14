package com.jiajia.jerry_core.app;

import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

/**
 * Coder : jerry
 * Time : 2018/7/8 8:30
 */
public final class Tool {

    public static Configurator init(Context context) {
        getConfiguration().put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigType.HANDLER);
    }

    public static HashMap<Object, Object> getConfiguration() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static <T> T getConfiguration(Object key) {
        return Configurator.getInstance().getConfiguration(key);
    }

    public static Context getApplication() {
        return (Context) getConfiguration().get(ConfigType.APPLICATION_CONTEXT);
    }
}
