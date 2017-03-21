package com.rarnu.tophighlight.xposed

import android.view.View
import android.view.ViewGroup
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers

/**
 * Created by zhaibingjie on 17/2/10.
 */
object HookTabView {

    //LauncherUIBottomTabView.java
    //钩在ohu上
    fun hookTabView(classLoader: ClassLoader?) {
        XposedHelpers.findAndHookMethod(Versions.bottomTabView, classLoader, Versions.bottomMethod, Integer.TYPE, ViewGroup::class.java, object : XC_MethodHook() {
            @Throws(Throwable::class)
            override fun afterHookedMethod(param: XC_MethodHook.MethodHookParam?) {
                XpConfig.xposedload()
                var aVar = param?.result
                var ohU = XposedHelpers.getObjectField(aVar, Versions.bottomField) as View
                ohU.setBackgroundColor(XpConfig.bottomBarColor)
                /*var backBitmap = BitmapFactory.decodeFile(XpConfig.bottomBarPath)
                val drawable = BitmapDrawable(backBitmap)
                ohU.background = drawable*/
            }
        })
    }
}