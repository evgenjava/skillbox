package main;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UIResources {

    public static final String LARGE_LOGO = "res/images/logo.png";
    public static final String MINI_LOGO = "res/images/logo-mini.png";
    public static final String MICRO_LOGO = "res/images/logo-micro.png";
    public static final String BACKGROUND = "res/images/background.png";
    public static final String BUTTON_BACKGROUND = "res/images/button-background.png";

    public static final String ICON_LOCK = "res/images/icon-lock.png";
    public static final String ICON_PHONE = "res/images/icon-phone.png";

    public static final String OPEN_SANS_LIGHT = "res/fonts/OpenSansLight.ttf";
    public static final String OPEN_SANS_REGULAR = "res/fonts/OpenSansRegular.ttf";
    public static final String OPEN_SANS_SEMIBOLD = "res/fonts/OpenSansSemiBold.ttf";

    public static final String ICON_BACK = "res/buttons/icon-back.png";
    public static final String ICON_CLOSE = "res/buttons/icon-close.png";
    public static final String ICON_EDIT = "res/buttons/icon-edit.png";
    public static final String ICON_HIDE = "res/buttons/icon-hide.png";
    public static final String ICON_PLUS = "res/buttons/icon-plus.png";
    public static final String ICON_SEARCH = "res/buttons/icon-search.png";
    public static final String ICON_SETTINGS = "res/buttons/icon-settings.png";

    public static final String MASK_BLUE_MINI = "res/mask/mask-blue-mini.png";
    public static final String MASK_DARK_GRAY_BIG = "res/mask/mask-dark-gray-big.png";
    public static final String MASK_GRAY = "res/mask/mask-gray.png";
    public static final String MASK_GRAY_ONLINE = "res/mask/mask-gray-online.png";
    public static final String MASK_WHITE = "res/mask/mask-white.png";
    public static final String MASK_WHITE_MINI = "res/mask/mask-white-mini.png";
    public static final String MASK_WHITE_ONLINE = "res/mask/mask-white-online.png";

    public static final Color LIGHT_BLUE_COLOR = new Color(0, 181, 234);
    public static final Color PROMPT_COLOR = new Color(172, 172, 172);

    private static Font OpenSansLigth;
    private static Font OpenSansRegular;
    private static Font OpenSansSemiBold;

    public static Font getFont(String fontName) {
        switch(fontName) {
            case OPEN_SANS_LIGHT:
                if (OpenSansLigth == null) {
                    OpenSansLigth = loadFont(fontName);
                }
                return OpenSansLigth;
            case OPEN_SANS_REGULAR:
                if (OpenSansRegular == null) {
                    OpenSansRegular = loadFont(fontName);
                }
                return OpenSansRegular;
            case OPEN_SANS_SEMIBOLD:
                if (OpenSansSemiBold == null) {
                    OpenSansSemiBold = loadFont(fontName);
                }
                return OpenSansSemiBold;
             default: return Font.getFont(Font.SANS_SERIF);
        }
    }

    private static Font loadFont(String fontName) {
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fontName));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return font;
    }

}
