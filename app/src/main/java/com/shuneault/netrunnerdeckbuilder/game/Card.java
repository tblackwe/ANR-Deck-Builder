package com.shuneault.netrunnerdeckbuilder.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.shuneault.netrunnerdeckbuilder.R;
import com.shuneault.netrunnerdeckbuilder.SettingsActivity;
import com.shuneault.netrunnerdeckbuilder.helper.AppManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Card {

    public static final String NAME_LAST_MODIFIED = "last-modified";
    public static final String NAME_CODE = "code";
    public static final String NAME_COST = "cost";
    public static final String NAME_TITLE = "title";
    public static final String NAME_TYPE = "type";
    public static final String NAME_TYPE_CODE = "type_code";
    public static final String NAME_SUBTYPE = "subtype";
    public static final String NAME_SYBTYPE_CODE = "subtype_code";
    public static final String NAME_TEXT = "text";
    public static final String NAME_BASELINK = "baselink";
    public static final String NAME_FACTION = "faction";
    public static final String NAME_FACTION_CODE = "faction_code";
    public static final String NAME_FACTION_COST = "factioncost";
    public static final String NAME_FLAVOR = "flavor";
    public static final String NAME_ILLUSTRATOR = "illustrator";
    public static final String NAME_INFLUENCE_LIMIT = "influencelimit";
    public static final String NAME_MINIMUM_DECK_SIZE = "minimumdecksize";
    public static final String NAME_NUMBER = "number";
    public static final String NAME_QUANTITY = "quantity";
    public static final String NAME_SET_NAME = "setname";
    public static final String NAME_SET_CODE = "set_code";
    public static final String NAME_SIDE = "side";
    public static final String NAME_SIDE_CODE = "side_code";
    public static final String NAME_UNIQUENESS = "uniqueness";
    public static final String NAME_URL = "url";
    public static final String NAME_IMAGE_SRC = "imagesrc";
    public static final String NAME_AGENDA_POINTS = "agendapoints";
    public static final String NAME_ADVANCEMENT_COST = "advancementcost";
    public static final String NAME_MEMORY_UNITS = "memoryunits";
    public static final String NAME_TRASH = "trash";
    public static final String NAME_STRENGTH = "strength";

    private Date lastModified;
    private String code;
    private String cost;
    private String title;
    private String type;
    private String typeCode;
    private String subtype;
    private String text;
    private String baselink;
    private String faction;
    private String factionCode;
    private String factionCost;
    private String flavor;
    private String illustrator;
    private String influenceLimit;
    private String minimumDeckSize;
    private String number;
    private String quantity;
    private String setName;
    private String setCode;
    private String side;
    private String sideCode;
    private int agendaPoints;
    private int advancementCost;
    private int memoryunits;
    private int trash;
    private int strength;
    private boolean uniqueness;
    private URL url;
    private URL imagesrc;

    public Card(JSONObject json) {

        try {
            //this.lastModified = DateFormat.getDateTimeInstance().parse(json.getString(NAME_LAST_MODIFIED));
            this.lastModified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(json.getString(NAME_LAST_MODIFIED));
            //this.lastModified.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(json.getString(NAME_LAST_MODIFIED)));
            this.code = json.optString(NAME_CODE);
            this.cost = json.optString(NAME_COST);
            this.title = json.optString(NAME_TITLE);
            this.type = json.optString(NAME_TYPE);
            this.typeCode = json.optString(NAME_TYPE_CODE);
            this.subtype = json.optString(NAME_SUBTYPE);
            this.text = json.optString(NAME_TEXT);
            this.baselink = json.optString(NAME_BASELINK);
            this.faction = json.optString(NAME_FACTION);
            this.factionCode = json.optString(NAME_FACTION_CODE);
            this.factionCost = json.optString(NAME_FACTION_COST);
            this.flavor = json.optString(NAME_FLAVOR);
            this.illustrator = json.optString(NAME_ILLUSTRATOR);
            this.influenceLimit = json.optString(NAME_INFLUENCE_LIMIT);
            this.minimumDeckSize = json.optString(NAME_MINIMUM_DECK_SIZE);
            this.number = json.optString(NAME_NUMBER);
            this.quantity = json.optString(NAME_QUANTITY);
            this.setName = json.optString(NAME_SET_NAME);
            this.setCode = json.optString(NAME_SET_CODE);
            this.uniqueness = json.optBoolean(NAME_UNIQUENESS);
            this.url = new URL(json.optString(NAME_URL));
            this.imagesrc = new URL(NetRunnerBD.BASE_URL + json.optString(NAME_IMAGE_SRC));
            this.side = json.optString(NAME_SIDE);
            this.sideCode = json.optString(NAME_SIDE_CODE);
            this.agendaPoints = json.optInt(NAME_AGENDA_POINTS, 0);
            this.advancementCost = json.optInt(NAME_ADVANCEMENT_COST, 0);
            this.memoryunits = json.optInt(NAME_MEMORY_UNITS, 0);
            this.trash = json.optInt(NAME_TRASH, 0);
            this.strength = json.optInt(NAME_STRENGTH, 0);
        } catch (ParseException e) {
            //
            e.printStackTrace();
        } catch (JSONException e) {
            //
            e.printStackTrace();
        } catch (MalformedURLException e) {
            //
            e.printStackTrace();
        }
    }


    public Date getLastModified() {
        return lastModified;
    }

    public String getCode() {
        return code;
    }

    public String getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getText() {
        return text;
    }

    public String getBaselink() {
        return baselink;
    }

    public String getFaction() {
        return faction;
    }

    public String getFactionCode() {
        return factionCode;
    }

    public int getFactionCost() {
        try {
            return Integer.parseInt(factionCost);
        } catch (Exception e) {
            return 0;
        }
    }

    public String getFlavor() {
        return flavor;
    }

    public String getIllustrator() {
        return illustrator;
    }

    public int getInfluenceLimit() {
        if (influenceLimit.equals(""))
            return 0;
        else
            return Integer.parseInt(influenceLimit);
    }

    public int getMinimumDeckSize() {
        if (minimumDeckSize.equals(""))
            return 0;
        else
            return Integer.parseInt(minimumDeckSize);
    }

    public int getNumber() {
        if (number.equals(""))
            return 0;
        else
            return Integer.parseInt(number);
    }

    public int getQuantity() {
        if (quantity.equals(""))
            return 0;
        else
            return Integer.parseInt(quantity);
    }

    public String getSetName() {
        return setName;
    }

    public String getSetCode() {
        return setCode;
    }

    public String getSide() {
        return side;
    }

    public String getSideCode() {
        return sideCode;
    }

    public boolean isUniqueness() {
        return uniqueness;
    }

    public int getAgendaPoints() {
        return agendaPoints;
    }

    public int getAdvancementCost() {
        return advancementCost;
    }

    public int getMemoryUnits() {
        return memoryunits;
    }

    public int getTrashCost() {
        return trash;
    }

    public int getStrength() {
        return strength;
    }


    public URL getUrl() {
        return url;
    }

    public URL getImagesrc() {
        return imagesrc;
    }


    /**
     * Splits subtype string by " - " into array of subtypes.
     * @return Array of subtype strings.
     * If subtype string is empty, array will contain a single empty string.
     */
    public String[] getSubtypeArray() {
        return subtype.split(" - ");
    }

    /**
     * Calculates how many of that card you can add in a deck
     * - Checks how many core decks you have and calculate
     *
     * @return How many cards you can use in a deck
     */
    public int getMaxCardCount() {
        try {
            if (this.setName.equals(SetName.CORE_SET)) {
                int iAmountCoreDecks = Integer.parseInt(AppManager.getInstance().getSharedPrefs().getString(SettingsActivity.KEY_PREF_AMOUNT_OF_CORE_DECKS, "3"));
                return Math.min(iAmountCoreDecks * Integer.parseInt(this.quantity), Deck.MAX_INDIVIDUAL_CARD);
            } else {
                return Integer.parseInt(this.quantity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Deck.MAX_INDIVIDUAL_CARD;
        }
    }

    /**
     * @return Formatted text with images
     */
    public SpannableString getFormattedText(Context context) {
        return getFormattedString(context, this.getText());
    }

    public static SpannableString getFormattedString(Context context, String text) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("[Agenda]", R.drawable.agenda);
        map.put("[Click]", R.drawable.click);
        map.put("[Trash]", R.drawable.trash);
        map.put("[Credits]", R.drawable.credits);
        map.put("[Subroutine]", R.drawable.subroutine);
        map.put("[Memory Unit]", R.drawable.memory_unit);
        map.put("[Recurring Credits]", R.drawable.credit_recurr);
        map.put("[Link]", R.drawable.links);
        map.put("[Fist]", R.drawable.fist);

        // replace all occurences
        SpannableString span = new SpannableString(Html.fromHtml(text.replace("\r\n", "<br />")));
        for (String txt : map.keySet()) {
            int index = span.toString().indexOf(txt);
            while (index >= 0) {
                span.setSpan(new ImageSpan(context, map.get(txt), ImageSpan.ALIGN_BOTTOM), index, index + txt.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                index = span.toString().indexOf(txt, index + 1);
            }
        }

        return span;
    }

    public Bitmap getImage(Context context) {
        return BitmapFactory.decodeFile(new File(context.getCacheDir(), this.getImageFileName()).getAbsolutePath());
    }

    public Bitmap getSmallImage(Context context) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        return BitmapFactory.decodeFile(new File(context.getCacheDir(), this.getImageFileName()).getAbsolutePath(), options);
    }

    public boolean isImageFileExists(Context context) {
        if (context == null) return false;
        //File f = new File(context.getFilesDir(), this.getImageFileName());
        File f = new File(context.getCacheDir(), this.getImageFileName());
        return f.exists();
    }

    @Override
    public String toString() {
        //
        return this.getTitle();
    }

    public String getImageFileName() {
        return this.getCode() + AppManager.EXT_CARDS_IMAGES;
    }

    public String getFactionImageResName() {
        String lowCaseFaction = this.getFaction().toLowerCase();
        if (lowCaseFaction.equals(Faction.FACTION_NEUTRAL)) {
            lowCaseFaction = this.getSideCode() + "_" + lowCaseFaction;
        }
        lowCaseFaction = lowCaseFaction.replace("-", "_");
        lowCaseFaction = lowCaseFaction.replace(" ", "_");
        return lowCaseFaction;
    }

    public int getFactionImageRes(Context context) {
        if (getFactionCode().equals(Faction.FACTION_NEUTRAL)) return R.drawable.neutral;
        return context.getResources().getIdentifier(getFactionImageResName(), "drawable", context.getPackageName());
    }

    /**
     * Gets ice/icebreaker main subtype.
     * @return The main subtype of an ice or icebreaker (if detected) card, otherwise an empty string.
     */
    public String getIceOrIcebreakerSubtype() {
        switch (typeCode)
        {
            case Type.ICE:
                return getSubtypeArray()[0];
            case Type.PROGRAM:
                String[] subtypes = getSubtypeArray();
                // FIXME: Can't detect icebreakers on non-english cards.
                return (subtypes.length > 1 && subtypes[0].equals("Icebreaker")) ? subtypes[1] : "";
            default:
                return "";
        }
    }

    @Override
    public boolean equals(Object o) {
        return ((Card) o).getCode().equals(this.getCode());
    }

    public static class Faction {
        public static final String FACTION_NEUTRAL = "neutral";
        public static final String FACTION_SHAPER = "shaper";
        public static final String FACTION_CRIMINAL = "criminal";
        public static final String FACTION_WEYLAND_CONSORTIUM = "weyland-consortium";
        public static final String FACTION_ANARCH = "anarch";
        public static final String FACTION_HAAS_BIOROID = "haas-bioroid";
        public static final String FACTION_JINTEKI = "jinteki";
        public static final String FACTION_NBN = "nbn";
    }

    public static class Side {
        public static final String SIDE_RUNNER = "runner";
        public static final String SIDE_CORPORATION = "corp";
    }

    public static class Type {
        public static final String AGENDA = "agenda";
        public static final String ASSET = "asset";
        public static final String EVENT = "event";
        public static final String ICE = "ice";
        public static final String IDENTITY = "identity";
        public static final String HARDWARE = "hardware";
        public static final String OPERATION = "operation";
        public static final String PROGRAM = "program";
        public static final String RESOURCE = "resource";
        public static final String UPGRADE = "upgrade";
    }

    public static class SetName {
        public static final String ALTERNATES = "Alternates";
        public static final String CORE_SET = "Core Set";
        public static final String SPECIAL = "Special";
    }

    public static class SpecialCards {
        public static final String CARD_THE_PROCESSOR = "03029";
        public static final String CARD_ANDROMEDA = "02083";
        public static final String CARD_CUSTOM_BIOTICS_ENGINEERED_FOR_SUCCESS = "03002";
        public static final String APEX = "09029";
    }


}
