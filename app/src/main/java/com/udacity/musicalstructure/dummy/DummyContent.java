package com.udacity.musicalstructure.dummy;

import android.content.Context;
import android.support.annotation.Nullable;

import com.udacity.musicalstructure.R;
import com.udacity.musicalstructure.model.Theme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<>();
    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<>();
    private static final int COUNT = 13;
    static {
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }


    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Música " + position, makeDetails(position));
    }


    /**
     * O conteúdo será obtido remotamente, aqui é apenas um esboço
     * @param position
     * @return
     */
    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Detalhes sobre a música: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMais informação detalhada aqui");
        }
        return builder.toString();
    }


    public static class DummyItem
    {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details)
        {
            this.id      = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString()
        {
            return content;
        }
    }


    /**
     * O conteúdo imagens, títulos, e quantidade de temas de músicas deve ser atualizado
     * @param section
     */
    public static List<Theme> initThemes(Context context, int section) {
        String[] itemsName = initNameItems(context, section);
        List<Theme> themes = new ArrayList<>();
        int[] covers = new int[] {R.mipmap.ic_launcher};
        Theme theme;
        if (itemsName != null) {
            for (int i = 0; i < itemsName.length; i++) {
                theme = new Theme(itemsName[i], 13, covers[0]);
                themes.add(theme);
            }
        }
        return themes;
    }


    @Nullable
    private static String[] initNameItems(Context context, int section) {
        String[] itemsName;
        switch (section) {
            case 0: // Como quero me sentir?
                itemsName = context.getResources().getStringArray(R.array.states);
                break;
            case 1: // O que estou fazendo?
                itemsName = context.getResources().getStringArray(R.array.doing);
                break;
            case 2: // Meus favoritos
                itemsName = new String[]{};
                break;
            default:
                itemsName = null;
                break;
        }
        return itemsName;
    }
}
