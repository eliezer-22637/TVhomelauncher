package app.tvhome.launcher

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import org.json.JSONArray
import org.json.JSONObject

class LauncherActivity : Activity() {
  override fun onCreate(b: Bundle?) {
    super.onCreate(b)
    val w = WebView(this)
    w.settings.javaScriptEnabled = true
    w.addJavascriptInterface(Bridge(), "Android")
    w.loadUrl("file:///android_asset/index.html")
    setContentView(w)
  }

  inner class Bridge {
    @JavascriptInterface fun apps(): String {
      val pm = packageManager
      val tv = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LEANBACK_LAUNCHER)
      var list = pm.queryIntentActivities(tv, 0)
      if (list.isEmpty()) list = pm.queryIntentActivities(Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER), 0)
      val out = JSONArray()
      for (r in list) {
        if (r.activityInfo.packageName == packageName) continue
        out.put(JSONObject().put("label", r.loadLabel(pm).toString()).put("pkg", r.activityInfo.packageName))
      }
      return out.toString()
    }

    @JavascriptInterface fun open(pkg: String) {
      val i = packageManager.getLeanbackLaunchIntentForPackage(pkg) ?: packageManager.getLaunchIntentForPackage(pkg)
      if (i != null) startActivity(i)
    }

    @JavascriptInterface fun settings(action: String) {
      try { startActivity(Intent(action).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)) } catch (e: Exception) {}
    }
  }

  override fun onBackPressed() {}
}
