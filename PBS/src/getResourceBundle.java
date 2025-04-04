import java.util.Locale;
import java.util.ResourceBundle;

public class getResourceBundle {

    ResourceBundle getResourceBundle(String language) {
        Locale locale;//uygulamayı farklı dillerde çalıştırabilmek için locale nesnesi oluşturduk
        switch (language) {
            case "en":
                locale = new Locale("en", "US");
                break;
            case "de":
                locale = new Locale("de", "DE");
                break;
            default:
                locale = new Locale("tr", "TR");
        }
        return ResourceBundle.getBundle("messages", locale);//messages dosyasını aradım ardından locale değişkenine uygun
        //dil dosyasını seçtim
    }
}