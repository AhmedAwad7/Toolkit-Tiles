import android.content.Context
import android.content.res.Configuration
import java.util.*

object LocaleManager {
    
    fun setLocale(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
        
        // حفظ اللغة المختارة في SharedPreferences
        val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        sharedPref.edit().putString("language", languageCode).apply()
    }
    
    fun getSelectedLanguage(context: Context): String {
        val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        return sharedPref.getString("language", "en") ?: "en"
    }
}
