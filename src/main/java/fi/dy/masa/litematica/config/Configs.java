package fi.dy.masa.litematica.config;

import java.io.File;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fi.dy.masa.litematica.Reference;
import fi.dy.masa.litematica.data.DataManager;
import fi.dy.masa.litematica.selection.CornerSelectionMode;
import fi.dy.masa.litematica.util.BlockInfoAlignment;
import fi.dy.masa.litematica.util.InventoryUtils;
import fi.dy.masa.litematica.util.PasteNbtBehavior;
import fi.dy.masa.litematica.util.ReplaceBehavior;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.HudAlignment;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigColor;
import fi.dy.masa.malilib.config.options.ConfigDouble;
import fi.dy.masa.malilib.config.options.ConfigInteger;
import fi.dy.masa.malilib.config.options.ConfigOptionList;
import fi.dy.masa.malilib.config.options.ConfigString;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;

public class Configs implements IConfigHandler
{
    private static final String CONFIG_FILE_NAME = Reference.MOD_ID + ".json";

    public static class Generic
    {
        public static final ConfigBoolean       AREAS_PER_WORLD         = new ConfigBoolean(    "RegionsAuswahlenProWelt", true, "Nutze den Dateipfad deiner Welt oder die Root-Dateipfade deines Servers für die Regions-Auswahl!\n§6Hinweis: Bitte deaktiviere diese Funktion nicht, wenn du gerade livestreamst, da\n§6der Regions-Auswahl-Browser sonst die Server-IP und den Namen/den Pfad\n§6der aktuellen Auswahl im Navigations-Widget anzeigt!\n§6Dies wird sich auch nicht ändern, bis du entweder den Dateipfad oder den Namen der Auswahl änderst!");
        public static final ConfigBoolean       BETTER_RENDER_ORDER     = new ConfigBoolean(    "bessereRenderingQualität", true, "Wenn diese Funktion aktiviert ist, wird die Schematic\nmithilfe eines Eingriffs in den Vanilla-Rendering-Code gerendert!\nDies kann zu einer besseren Qualität des Renderings über durchsichtige Blöcke hinweg führen!\nDiese Funktion ist nützlich, um eine bessere Qualität beim Rendering in einer normal generierten Welt zu erzielen!\nWenn das Rendering nicht funktioniert (z.B. bei Nutzung von Optifine),\nso wird empfohlen, diese Funktion zu deaktivieren!");
        public static final ConfigBoolean       CHANGE_SELECTED_CORNER  = new ConfigBoolean(    "BeiBewegungAusgewähltEckeÄndern", true, "Wenn diese Option auf 'true' gesetzt ist, wird die ausgewählte Ecke der aktuellen Regions-Auswahl immer\ndie zuletzt bearbeitete Ecke sein, wenn du\nDie Hotkeys für das Setzen von Ecken verwendest!");
        public static final ConfigBoolean       DEBUG_LOGGING           = new ConfigBoolean(    "DebugLog", false, "Aktiviere Debug-Log-Nachrichten in der Spielkonsole, um\nFehlern und Crashs auf die Spur zu kommen!");
        public static final ConfigBoolean       EASY_PLACE_FIRST        = new ConfigBoolean(    "easyPlaceZuerst", true, "Diese Funktion bewirkt, dass der Easy-Place-Modus zuerst den Block platziert, der dem Spieler am Nächsten liegt\nund nicht der Block, der am Weitesten vom Spieler entfernt liegt!\nWenn diese Funktion auf 'False' gesetzt ist, können mehrere Schichten auf einmal platziert werden!");
        public static final ConfigBoolean       EASY_PLACE_HOLD_ENABLED = new ConfigBoolean(    "easyPlaceHoldEnabled", true, "Wenn diese Funktion aktiviert ist, kannst du auf den Use-Key klicken und\nauf verschiedene Schematip-Blöcke blicken, um sie zu platzieren\nohne immer auf jeden einzelnen Block klicken zu müssen!");
        public static final ConfigBoolean       EASY_PLACE_MODE         = new ConfigBoolean(    "easyPlaceModus", false, "Wenn diese Funktion aktiviert ist, kannst du unabhängig vom Item/Block in deine Hand\nmit einem Klick auf einen Schematisch-Block diesen Block platzieren!");
        public static final ConfigBoolean       EASY_PLACE_SP_HANDLING  = new ConfigBoolean(    "easyPlaceEinzelspielerHandling", true, "Wenn diese Funktion aktiviert ist, wird Litematica das \n\"Carpet-Mod-Accurate-Placement-Protokoll\" verwenden!\nWenn du Tweakeroo installiert hast, kann diese Funktion ohne Weiteres deaktivieren!\nDer Grund hierfür liegt bei der 'ClientPlatzierungsRotation'! Damit kann exakt die gleiche Aktion durchgeführt werden!");
        public static final ConfigBoolean       EASY_PLACE_PROTOCOL_V3  = new ConfigBoolean(    "easyPlaceProtokollV3", true, "Wenn diese Funktion aktiviert ist, wird Litematica \"Version 3\"\ndes sogenannten \"Accurate-Placement-Protokolls\" verwenden.\nDiese Funktion ist allerdings momentan nur im Einzelspieler-Modus und mit Native-Litematica nutzbar!");
        public static final ConfigBoolean       EXECUTE_REQUIRE_TOOL    = new ConfigBoolean(    "WerkzeugVoraussetzen", true, "Setze ein aktiviertes Werkzeug-Item\nfür den executeOperation-Hotkey voraus!");
        public static final ConfigBoolean       FIX_RAIL_ROTATION       = new ConfigBoolean(    "SchienenBugFixen", true, "Wenn diese Funktion auf 'true' gesetzt ist, wird der Vanilla-Bug der Rotation von Eisenbahn-Schienen gefixt, bei dem\nRotationen um 180 Grad in Richtung Nord --> Süd und\nOst --> West Schienen um 90 Grad weiter im Uhrzeigersinn drehen lies! >_>");
        public static final ConfigBoolean       GENERATE_LOWERCASE_NAMES = new ConfigBoolean(   "UnderlinesStattLeerzeichen", false, "Wenn diese Funktion aktiviert ist, werden die defaultmäßigen Schematic-Namen\nUnderlines statt Leerzeichen beinhalten!");
        public static final ConfigBoolean       HIGHLIGHT_BLOCK_IN_INV  = new ConfigBoolean(    "HighlighterItemImInventar", false, "Wenn diese Funktion aktiviert ist, werden alle Blöcke (Shulker-Boxen inklusive)\nfarblich hervorgehoben, wenn diese anvisiert werden!");
        public static final ConfigBoolean       LAYER_MODE_DYNAMIC      = new ConfigBoolean(    "LayerFolgtSpieler", false, "Wenn diese Funktion auf 'true' gesetzt ist, wird das Render-Layer dem Spieler stets folgen!\nHinweis: This currently collapses Layer Range type ranges unfortunately");
        public static final ConfigBoolean       LOAD_ENTIRE_SCHEMATICS  = new ConfigBoolean(    "GanzeSchematicsLaden", false, "Wenn diese Funktion auf 'true' gesetzt ist, wird immer die ganze Schematic auf einmal geladen!\nWenn diese Funktion auf 'false' gesetzt ist, wird immer nur der Teil einer Schematic geladen,\nder sich innerhalb der Chunk-Render-Distance des Spielers befindet!");
        public static final ConfigInteger       PASTE_COMMAND_INTERVAL  = new ConfigInteger(    "IntervallZwischenBefehlen", 1, 1, 1000, "Das Intervall zwischen jedem Gametick, wenn die Schematic\nmithilfe des befehlsbasierten Paste-Features eingefügt wird!");
        public static final ConfigInteger       PASTE_COMMAND_LIMIT     = new ConfigInteger(    "LimitAnPasteBefehlen", 64, 1, 1000000, "Maximale Zahl an Befehlen pro Gameticks, wenn\nwenn das befehlsbasierte Paste-Feature auf\neinem Server verwendet wird!");
        public static final ConfigString        PASTE_COMMAND_SETBLOCK  = new ConfigString(     "NameDesSetBlockBefehls", "setblock", "Der Name des SetBlock-Befehls, wenn die\nSchematic\nüber das befehlsbasierte Paste-Feature eingefügt wird!");
        public static final ConfigBoolean       PASTE_IGNORE_ENTITIES   = new ConfigBoolean(    "EntitiesBeimEinfügenIgnorieren", false, "Wenn diese Funktion aktiviert ist, wird die Paste-Funktion keine Entities einfügen");
        public static final ConfigBoolean       PASTE_IGNORE_INVENTORY  = new ConfigBoolean(    "InventareIgnorieren", false, "Wenn diese Funktion aktiviert ist, werden keine Inventories eingefügt");
        public static final ConfigOptionList    PASTE_NBT_BEHAVIOR      = new ConfigOptionList( "VerhaltenDesNBTRestorers", PasteNbtBehavior.NONE, "Soll die NBT-Data von Blöcken restauriert werden?\nWelche Methode soll hierfür verwendet werden?\nPlace & Data-Modifizierungen: Blöcke werden anhand von NBT-Tags in der Nähe des Spielers platziert.\nIm Folgenden soll der Data-Modify-Befehl ausgeführt werden, um die NBT-Daten in den platzierten Block\nzu übertragen!\n-Place & Close: Blöcke werden anhand von NBT-Tags in der Nähe des Spielers platziert.\nIm Folgenden wird der Block auf seine Endposition geklont!\n- Teleport & Place: Diese Funktion wird den Spieler teleportieren\nund den anhand von NBT-Daten berechneten Block direkt in die richtige Position einfügen\nHinweis: Die Funktion Teleport & Place wird vermutlich nicht richtig/gar nicht funktionieren\nDie empfohlene Vorgehensweise ist 'Place & Data'! Damit diese Aktion richtig ausgeführt wird,\nsollte 'pasteCommandLimit' auf 1 Command pro Gametick gesetzt werden\nund 'pasteCommandInterval' auf 1-4 Ticks gesetzt werden!\nDann sollten alle wichtigen Blöcke und die benötigten Daten dafür richtig eingefügt werden!");
        public static final ConfigOptionList    PASTE_REPLACE_BEHAVIOR  = new ConfigOptionList( "PasteReplaceVerhalten", ReplaceBehavior.NONE, "Das Verhalten beim Ersetzen bestehender Blöcke\nim Paste-Schematic-Tool-Mode");
        public static final ConfigBoolean       PASTE_TO_MCFUNCTION     = new ConfigBoolean(    "InTextDateienSpeichern", false, "Wenn diese Funktion aktiviert ist, wird die Schematic nicht direkt platziert, sondern sie\nsie wird mithilfe von Setblock-Befehlen in eine Text-Datei übertragen");
        public static final ConfigBoolean       PICK_BLOCK_ENABLED      = new ConfigBoolean(    "pickBlockAktiviert", true, "Aktiviert die Pick-Block-Hotkeys\nEs gibt übrigens auch einen Hotkey, um die Hotkeys dieser Funktion zu deaktivieren! o.o", "Pick-Block Hotkeys");
        public static final ConfigBoolean       PICK_BLOCK_SHULKERS     = new ConfigBoolean(    "pickBlockShulkerkiste", false, "Wenn diese Funktion aktiviert ist, wird der Spieler nicht direkt das Werkzeug für die Pick-Block-Funktion erhalten\nDer Spieler wird stattdessen eine Shulker-Kiste mit dem entsprechenden Werkzeug ins Inventar gelegt bekommen!");
        public static final ConfigString        PICK_BLOCKABLE_SLOTS    = new ConfigString(     "SlotsBlockieren", "1,2,3,4,5", "Die Slots in der Hotbar, die für\nden Schematic-Pick-Block verwendet werden dürfen!");
        public static final ConfigBoolean       PLACEMENT_RESTRICTION   = new ConfigBoolean(    "PlatzierungsBeschränkungen", false, "Wenn diese Funktion aktiviert ist, kann der Key nur\ndann verwendet werden, wenn das korrekte Werkzeug für die anvisierte Position verwendet wird\nund die anvisierte Position einen fehlenden Block in der Schematic aufweist", "Platzierungs-Beschränkungen");
        public static final ConfigBoolean       RENDER_MATERIALS_IN_GUI = new ConfigBoolean(    "MaterialienListeninGUIRendern", true, "Soll die Materialien-Liste in\nGUIs visualisiert werden!");
        public static final ConfigBoolean       RENDER_THREAD_NO_TIMEOUT = new ConfigBoolean(   "KeinRenderWorkerTimeout", true, "Entfernt das Timeout der Rendering-Worker-Threads.\nSollte dein Client während der Operation anfangen, zu laggen, wird empfohlen\ndiese Option zu deaktivieren!\nInsbesondere beim Einfügen großer Schematics wird zu diesem Schritt geraten!");
        public static final ConfigOptionList    SELECTION_CORNERS_MODE  = new ConfigOptionList( "CornersMode", CornerSelectionMode.CORNERS, "Der Corner-Modus der Regions-Auswahl (Ecken oder Gesamtauswahl)");
        public static final ConfigString        TOOL_ITEM               = new ConfigString(     "Werkzeug", "minecraft:stick", "Welches Item soll das\"Tool\" zum Auswählen sein?");
        public static final ConfigBoolean       TOOL_ITEM_ENABLED       = new ConfigBoolean(    "WerkzeugAktiv", true, "Wenn diese Funktion aktiviert ist, kann das \"Tool\"-Item zum Verwalten deiner Auswahl verwendet werden!", "Tool-Item aktiviert");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                AREAS_PER_WORLD,
                //BETTER_RENDER_ORDER,
                CHANGE_SELECTED_CORNER,
                DEBUG_LOGGING,
                EASY_PLACE_FIRST,
                EASY_PLACE_HOLD_ENABLED,
                EASY_PLACE_MODE,
                EASY_PLACE_SP_HANDLING,
                EASY_PLACE_PROTOCOL_V3,
                EXECUTE_REQUIRE_TOOL,
                FIX_RAIL_ROTATION,
                GENERATE_LOWERCASE_NAMES,
                HIGHLIGHT_BLOCK_IN_INV,
                LAYER_MODE_DYNAMIC,
                LOAD_ENTIRE_SCHEMATICS,
                PASTE_IGNORE_ENTITIES,
                PASTE_IGNORE_INVENTORY,
                PASTE_NBT_BEHAVIOR,
                PASTE_TO_MCFUNCTION,
                PICK_BLOCK_ENABLED,
                PICK_BLOCK_SHULKERS,
                PLACEMENT_RESTRICTION,
                RENDER_MATERIALS_IN_GUI,
                RENDER_THREAD_NO_TIMEOUT,
                TOOL_ITEM_ENABLED,

                PASTE_REPLACE_BEHAVIOR,
                SELECTION_CORNERS_MODE,

                PASTE_COMMAND_INTERVAL,
                PASTE_COMMAND_LIMIT,
                PASTE_COMMAND_SETBLOCK,
                PICK_BLOCKABLE_SLOTS,
                TOOL_ITEM
        );
    }

    public static class Visuals
    {
        public static final ConfigBoolean       ENABLE_AREA_SELECTION_RENDERING     = new ConfigBoolean("BoxenRenderingFürRegionsAuswahlAktiviert", true, "Aktiviert das Boxen-Rendering für deine Regions-Auswahl", "Boxen-Rendering (Regions-Auswahl)");
        public static final ConfigBoolean       ENABLE_PLACEMENT_BOXES_RENDERING    = new ConfigBoolean("BoxenRenderingFürSchematicAktiviert", true, "Aktiviert das Boxen-Rendering für deine Schematic-Platzierung", "Boxen-Rendering (Schematic-Platzierung)");
        public static final ConfigBoolean       ENABLE_RENDERING                    = new ConfigBoolean("RenderingFunktionAktivieren", true, "De-/aktiviere die Haupt-Rendering.Funktion", "Haupt-Rendering");
        public static final ConfigBoolean       ENABLE_SCHEMATIC_BLOCKS             = new ConfigBoolean("SchematicBlockRenderingAktivieren",  true, "Aktiviere das Block-Rendering bei Schematics\nDie Deaktivierung der Funktion bewirkt, dass dir nur die Farben des Overlays gezeigt werden!", "Block-Rendering");
        public static final ConfigBoolean       ENABLE_SCHEMATIC_OVERLAY            = new ConfigBoolean("SchematicOverlayAktivieren",  true, "De-/aktiviere die Block-Overlay-Funktion", "Overlay-Rendering");
        public static final ConfigBoolean       ENABLE_SCHEMATIC_RENDERING          = new ConfigBoolean("SchematicRenderingAktivieren", true, "Aktiviere das Rendering von Schematic und Overlay", "Schematic-Rendering");
        public static final ConfigDouble        GHOST_BLOCK_ALPHA                   = new ConfigDouble( "AlphaWertVonGhostBlöcken", 0.5, 0, 1, "Der Alpha-Wert von Ghost-Blöcken, wenn\nsie als durchsichtige Blöcke gerendert werden\n§6Hinweis: §7Bitte denk daran, das Rendering von durchsichtigen Blöcken seperat zu aktivieren, indem\ndu die Option 'renderBlocksAsTranslucent' nutzt!");
        public static final ConfigBoolean       IGNORE_EXISTING_FLUIDS              = new ConfigBoolean("FlüssigeBlöckeIgnorieren", false, "Wenn diese Funktion aktiviert ist, werden flüssige Blöcke nicht als \"Weitere Blöcke\" und \"Fehlerhafte Blöcke\"gewertet, wo die Schematic Luftblöcke u.Ä. beinhaltet!\nDiese Funktion ist vor allem für den Bau von Unterwasser-Konstruktionen empfohlen!\nHinweis: Du solltest auch die Funktion: 'renderCollidingSchematicBlocks'\naktivieren, um das Rendering von Blöcken in Flüssigkeiten zu gestatten!");
        public static final ConfigBoolean       OVERLAY_REDUCED_INNER_SIDES         = new ConfigBoolean("OverlayReduzierung", false, "Wenn diese Funktion, werden benachbarte/innere Seitenlinien der Block-Overlays\nentfernt/nicht gerendert!");
        public static final ConfigDouble        PLACEMENT_BOX_SIDE_ALPHA            = new ConfigDouble( "AlphaWertDerSubRegionsBoxen", 0.2, 0, 1, "Der Alpha-Wert der Sub-Regions-Boxen");
        public static final ConfigBoolean       RENDER_AREA_SELECTION_BOX_SIDES     = new ConfigBoolean("SeitenDerRegionsAuswahlBoxen", true, "Wenn diese Funktion aktiviert ist, wird die Regions-Auswahl\nSeiten-Linien gerendert bekommen!");
        public static final ConfigBoolean       RENDER_BLOCKS_AS_TRANSLUCENT        = new ConfigBoolean("BlockAlsDurchscheinendRendern", false, "Wenn diese Funktion aktiviert ist, wird die Schematic\nGhost-Blöcke als durchsichtig werten und dementsprechend rendern!","Durchsichtiges Block-Rendering");
        public static final ConfigBoolean       RENDER_COLLIDING_SCHEMATIC_BLOCKS   = new ConfigBoolean("KollidierenVonSchematicBlöckenVermeiden", false, "Wenn diese Funktion aktiviert ist, werden Blöcke in der Schematic\nauch dann gerendert, wenn sich bereits ein (falscher) Block in der\nClient-Welt befindet! Diese Funktion ist nützlich, wenn etwas an einer Stelle gebaut werden soll,\nan der sich eine Schneedecke oder eine Wasserfläche im Weg befindet");
        public static final ConfigBoolean       RENDER_ERROR_MARKER_CONNECTIONS     = new ConfigBoolean("ErrorMarkerVerbindungenRendern", false, "Rendering-Verbindungslinien zwischen den Ecken der Verifizierungs-Highlighter-Boxen!\nDies war ein bekannter Rendering-Bug, der bei einigen Nutzern auftrat. Das fehlerhafte Design wurde aber gemocht\nund so blieb das Feature auf Bitten einiger Nutzer bestehen! Mit der Nutzung dieser Funktion wird das Design \"zurückgesetzt\"!");
        public static final ConfigBoolean       RENDER_ERROR_MARKER_SIDES           = new ConfigBoolean("ErrorMarkerRendern", true, "Wenn diese Funktion aktiviert ist, werden die Error-Marker des Verifiers\ndurchsichtige Seiten, statt der üblichen Seitenlinien gerendert bekommen!");
        public static final ConfigBoolean       RENDER_PLACEMENT_BOX_SIDES          = new ConfigBoolean("BoxenSeitenDerPlatzierungRendern", false, "Wenn diese Funktion aktiviert ist, werden alle Sub-Regions-Boxen\nihre Seiten-Linien gerendert bekommen!");
        public static final ConfigBoolean       RENDER_PLACEMENT_ENCLOSING_BOX      = new ConfigBoolean("SchematicUmschließendeBoxRendern", true, "Wenn diese Funktion aktiviert ist, wird eine Linie um\naalle Sub-Regionen einer Schematic gerendert! (Platzierung)");
        public static final ConfigBoolean       RENDER_PLACEMENT_ENCLOSING_BOX_SIDES= new ConfigBoolean("SeitenVonSchematicUmschließendenBoxenRendern", false, "Wenn diese Funktion aktiviert ist, werden\nLinien, die um eine Schematic-Platzierung gerendert werden eine durchscheinende Seitenwand erhalten!");
        public static final ConfigBoolean       RENDER_TRANSLUCENT_INNER_SIDES      = new ConfigBoolean("DurchscheinendeBlockinnenseitenRendern", false, "Wenn diese Funktion aktiviert ist, werden auch die Innenseiten von Blöcken\nfür die Innenseiten im Transcluent-Mode verwendet!");
        public static final ConfigBoolean       SCHEMATIC_OVERLAY_ENABLE_OUTLINES   = new ConfigBoolean("SchematicOverlayLinienRendern",  true, "Aktiviert Seitenlinien für\ndas Schematic-Block-Overlay", "Schematic-Overlay-Linien");
        public static final ConfigBoolean       SCHEMATIC_OVERLAY_ENABLE_SIDES      = new ConfigBoolean("DurchsichtigeSeitenFürOverlayRendern",     true, "Aktiviert das Rendering durchsichtiger Seiten für\ndas Schemtatic-Block-Overlay", "Schematic-Overlay-Seiten");
        public static final ConfigBoolean       SCHEMATIC_OVERLAY_MODEL_OUTLINE     = new ConfigBoolean("EckpunkteRendern",    true, "Wenn diese Funktion aktiviert ist, wird das Schematic-Overlay\nQuads/Eckpunkte für Block-Modelle statt dem\ntraditonellen Block-Overlay verwenden!");
        public static final ConfigBoolean       SCHEMATIC_OVERLAY_MODEL_SIDES       = new ConfigBoolean("ModellSeitenRendern",      true, "Wenn diese Funktion aktiviert ist, wird das Schematic-Overlay\nQuads/Eckpunkte für Block-Modelle statt dem\ntraditionellen Block-Overlay verwenden!");
        public static final ConfigDouble        SCHEMATIC_OVERLAY_OUTLINE_WIDTH     = new ConfigDouble( "LinienbreiteDerUmrisse",  1.0, 0, 64, "Die Linienbreite der Umrisse von Block- (Modelle)");
        public static final ConfigDouble        SCHEMATIC_OVERLAY_OUTLINE_WIDTH_THROUGH = new ConfigDouble( "LinienbreiteDerUmrisseDurchBlöcke",  3.0, 0, 64, "Die Linienbreite der Umrisse von Block- (Modelle)\nwenn das Overlay durch Blöcke hindurch gerendert wird!");
        public static final ConfigBoolean       SCHEMATIC_OVERLAY_RENDER_THROUGH    = new ConfigBoolean("SchematicOverlayBeiRenderingDurchBlöcke", false, "Wenn diese Funktion aktiviert ist, wird das Schematic-Overlay\nüber die Blöcke hinweg gerendert! Diese Funktion wird allerdings nur empfohlen, wenn du bereits den Bau\nbeendet hast und auf der Suche nach Baufehlern bist!");
        public static final ConfigBoolean       SCHEMATIC_OVERLAY_TYPE_EXTRA        = new ConfigBoolean("SchematicOverlayFürZusätzliche",       true, "Aktiviere das Schematic-Overlay für zusätzliche Blöcke");
        public static final ConfigBoolean       SCHEMATIC_OVERLAY_TYPE_MISSING      = new ConfigBoolean("SchematicOverlayFürFehlende",     true, "Aktiviere das Schematic-Overlay für fehlende Blöcke");
        public static final ConfigBoolean       SCHEMATIC_OVERLAY_TYPE_WRONG_BLOCK  = new ConfigBoolean("SchematicOverlayFürFalsche",  true, "Aktiviere das Schematic-Overlay für falsche Blöcke");
        public static final ConfigBoolean       SCHEMATIC_OVERLAY_TYPE_WRONG_STATE  = new ConfigBoolean("SchematicOverlayFürFalscheStati",  true, "Aktiviere das Schematic-Overlay für falsche Block-Stati");
        public static final ConfigBoolean       SCHEMATIC_VERIFIER_BLOCK_MODELS     = new ConfigBoolean("BlockmodelleErzwingen", false, "Erzwinge die Nutzung von Block-Modellen für alle Ergebnisse in der Verfifier-\nErgebnisliste! Item-Modelle werden normalerweise für alle Ergebnisse genutzt,\ndie Items sein könnten, alle restlichen Entities erhalten Block-Modelle!\nZu diesen Entities zählen übrigens auch Blumentöpfe!");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                ENABLE_RENDERING,
                ENABLE_SCHEMATIC_RENDERING,

                ENABLE_AREA_SELECTION_RENDERING,
                ENABLE_PLACEMENT_BOXES_RENDERING,
                ENABLE_SCHEMATIC_BLOCKS,
                ENABLE_SCHEMATIC_OVERLAY,
                IGNORE_EXISTING_FLUIDS,
                OVERLAY_REDUCED_INNER_SIDES,
                RENDER_AREA_SELECTION_BOX_SIDES,
                RENDER_BLOCKS_AS_TRANSLUCENT,
                RENDER_COLLIDING_SCHEMATIC_BLOCKS,
                RENDER_ERROR_MARKER_CONNECTIONS,
                RENDER_ERROR_MARKER_SIDES,
                RENDER_PLACEMENT_BOX_SIDES,
                RENDER_PLACEMENT_ENCLOSING_BOX,
                RENDER_PLACEMENT_ENCLOSING_BOX_SIDES,
                RENDER_TRANSLUCENT_INNER_SIDES,
                SCHEMATIC_OVERLAY_ENABLE_OUTLINES,
                SCHEMATIC_OVERLAY_ENABLE_SIDES,
                SCHEMATIC_OVERLAY_MODEL_OUTLINE,
                SCHEMATIC_OVERLAY_MODEL_SIDES,
                SCHEMATIC_OVERLAY_RENDER_THROUGH,
                SCHEMATIC_OVERLAY_TYPE_EXTRA,
                SCHEMATIC_OVERLAY_TYPE_MISSING,
                SCHEMATIC_OVERLAY_TYPE_WRONG_BLOCK,
                SCHEMATIC_OVERLAY_TYPE_WRONG_STATE,
                SCHEMATIC_VERIFIER_BLOCK_MODELS,

                GHOST_BLOCK_ALPHA,
                PLACEMENT_BOX_SIDE_ALPHA,
                SCHEMATIC_OVERLAY_OUTLINE_WIDTH,
                SCHEMATIC_OVERLAY_OUTLINE_WIDTH_THROUGH
        );
    }

    public static class InfoOverlays
    {
        public static final ConfigOptionList    BLOCK_INFO_LINES_ALIGNMENT          = new ConfigOptionList( "AusrichtiungBlockinfozeilen", HudAlignment.TOP_RIGHT, "Die Ausrichtung des Overlays für Blockinfozeilen");
        public static final ConfigBoolean       BLOCK_INFO_LINES_ENABLED            = new ConfigBoolean(    "BlcokinfozeilenAktivieren", true, "Wenn diese Funktion aktiviert ist, wird das Mini-Block-Info-Overlay\nfür alle anvisierten Blöcke geladen!");
        public static final ConfigDouble        BLOCK_INFO_LINES_FONT_SCALE         = new ConfigDouble(     "SchriftgrößeVonBlockinfos", 0.5, 0, 10, "Die Schriftgröße der Block-Information");
        public static final ConfigInteger       BLOCK_INFO_LINES_OFFSET_X           = new ConfigInteger(    "xOffsetBlockinfozeilen", 4, 0, 2000, "Das x-Offset der Blockinfozeilen des ausgewählten Rahmens");
        public static final ConfigInteger       BLOCK_INFO_LINES_OFFSET_Y           = new ConfigInteger(    "yOffsetBlockinfozeilen", 4, 0, 2000, "Das Y-Offset der Blockinfozeilen des ausgewählten Rahmens");
        public static final ConfigOptionList    BLOCK_INFO_OVERLAY_ALIGNMENT        = new ConfigOptionList( "AusrichtigungBlcokinfoOverlay", BlockInfoAlignment.TOP_CENTER, "Die Ausrichtung des Block-Info-Overlays");
        public static final ConfigInteger       BLOCK_INFO_OVERLAY_OFFSET_Y         = new ConfigInteger(    "xOffsetBlockinfoOverlay", 6, -2000, 2000, "Das x-Offset des Block-Info-Overlays vom ausgewählten Rahmen");
        public static final ConfigBoolean       BLOCK_INFO_OVERLAY_ENABLED          = new ConfigBoolean(    "BlockinfoOverlayAktiv", true, "Aktiviere das Block-Informations-Overlay, um Infos\nüber den aktuell anvisierten Block oder den Verfifizierungs-Fehler-Marker zu erhalten, wenn\nder 'Render-Info-Overlay' Key", "Rendering des Block-Info-Overlay");
        public static final ConfigOptionList    INFO_HUD_ALIGNMENT                  = new ConfigOptionList( "AusrichtungInfoHUD", HudAlignment.BOTTOM_RIGHT, "Die Ausrichtung des \"Info-HUDs\",\nwelche unter anderem für Materialien-Listen, Verifier und ähnliche Dinge verwendet wird!");
        public static final ConfigInteger       INFO_HUD_MAX_LINES                  = new ConfigInteger(    "MaxLinienInfoHUD", 10, 1, 128, "Die maximale Anzahl an Zeilen, die gleichzeitig auf der Info-HUD gezeigt werden sollen");
        public static final ConfigInteger       INFO_HUD_OFFSET_X                   = new ConfigInteger(    "xOffsetInfoHUD", 1, 0, 32000, "Das X-Offset des Info-HUDs vom ausgewählten Rahmen");
        public static final ConfigInteger       INFO_HUD_OFFSET_Y                   = new ConfigInteger(    "yOffsetInfoHUD", 1, 0, 32000, "Das Y-Offset des Info-HUDs vom ausgewählten Rahmen");
        public static final ConfigDouble        INFO_HUD_SCALE                      = new ConfigDouble(     "SkalierungInfoHUD", 1, 0.1, 4, "Skalierungs-Faktor für die Info-HUD");
        public static final ConfigBoolean       INFO_OVERLAYS_TARGET_FLUIDS         = new ConfigBoolean(    "InfoOverlayErkenntFlüssigkeiten", false, "Wenn diese Funktion aktiviert ist, wird das Block-Info-Overlay\nin der Lage sein, fluide Blöcke wie Wasser zu erkennen, anstatt sie zu skippen");
        public static final ConfigInteger       MATERIAL_LIST_HUD_MAX_LINES         = new ConfigInteger(    "MaxLinienMaterialienHUD", 10, 1, 128, "Die maximale Anzahl an Items, die gleichzeitig auf\nthe Material List Info HUD at once");
        public static final ConfigDouble        MATERIAL_LIST_HUD_SCALE             = new ConfigDouble(     "SkalierungMaterialienHUD", 1, 0.1, 4, "Skalierungs-Faktor für die Info-HUD der Materialien-Liste");
        public static final ConfigBoolean       STATUS_INFO_HUD                     = new ConfigBoolean(    "StatusInfoHUD", false, "Aktiviert ein Status-Info-HUD,\nwelches ein paar Statusinformationen anzeigt, z.B.\nder aktuelle Layer-Mode oder der Rendering-Status!");
        public static final ConfigBoolean       STATUS_INFO_HUD_AUTO                = new ConfigBoolean(    "AutomatischesStatusInfoHUDs", true, "Erlaubt die automatische Aktivierung des Info-HUDs, wenn\"when needed\",\nfor example when creating a placement and having rendering disabled");
        public static final ConfigOptionList    TOOL_HUD_ALIGNMENT                  = new ConfigOptionList( "AusrichtungWerkzeugHUD", HudAlignment.BOTTOM_LEFT, "Die Ausrichtung des \"Tool-HUD\", bei Nutzung des konfigurierten \"Tools\"");
        public static final ConfigInteger       TOOL_HUD_OFFSET_X                   = new ConfigInteger(    "xOffsetWerkzeugHUD", 1, 0, 32000, "Das X-Offset des Werkzeug-HUDs");
        public static final ConfigInteger       TOOL_HUD_OFFSET_Y                   = new ConfigInteger(    "xOffsetWerkzeugHUD", 1, 0, 32000, "Das X-Offset des Werkzeug-HUDs");
        public static final ConfigDouble        TOOL_HUD_SCALE                      = new ConfigDouble(     "SkalierungWerkzeugHUD", 1, 0.1, 4, "Skalierungs-Faktor für den Text des Werkzeug-HUDs");
        public static final ConfigDouble        VERIFIER_ERROR_HILIGHT_ALPHA        = new ConfigDouble(     "AlphaWertFehlerMarkerBoxen", 0.2, 0, 1, "Der Alpha-Wert der Fehler-Marker-Boxen");
        public static final ConfigInteger       VERIFIER_ERROR_HILIGHT_MAX_POSITIONS = new ConfigInteger(   "MaxAnzahlFehlerhaftePositionen", 1000, 1, 1000000, "Die maximale Anzahl an fehlerhaft gerenderten Positionen\nim Schematic-Verfizierungs-Overlay");
        public static final ConfigBoolean       VERIFIER_OVERLAY_ENABLED            = new ConfigBoolean(    "VerifierOverlayAktiv", true, "Aktiviere das Rendering des Verifizierungs-Overlays", "Rendering des Verifizierungs-Overlays");
        public static final ConfigBoolean       WARN_DISABLED_RENDERING             = new ConfigBoolean(    "WarnungBeiDeaktiviertemRendering", true, "Soll eine Warnungs-Nachricht über deinen aktuellen Layer-Mode-Status\noder über den Status deiner Rendering-Optionen gesendet werden, wenn\ndu eine Schematic lädst oder eine neue Platzierung erstellst!");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                BLOCK_INFO_LINES_ENABLED,
                BLOCK_INFO_OVERLAY_ENABLED,
                INFO_OVERLAYS_TARGET_FLUIDS,
                STATUS_INFO_HUD,
                STATUS_INFO_HUD_AUTO,
                VERIFIER_OVERLAY_ENABLED,
                WARN_DISABLED_RENDERING,

                BLOCK_INFO_LINES_ALIGNMENT,
                BLOCK_INFO_OVERLAY_ALIGNMENT,
                INFO_HUD_ALIGNMENT,
                TOOL_HUD_ALIGNMENT,

                BLOCK_INFO_LINES_OFFSET_X,
                BLOCK_INFO_LINES_OFFSET_Y,
                BLOCK_INFO_LINES_FONT_SCALE,
                BLOCK_INFO_OVERLAY_OFFSET_Y,
                INFO_HUD_MAX_LINES,
                INFO_HUD_OFFSET_X,
                INFO_HUD_OFFSET_Y,
                INFO_HUD_SCALE,
                MATERIAL_LIST_HUD_MAX_LINES,
                MATERIAL_LIST_HUD_SCALE,
                TOOL_HUD_OFFSET_X,
                TOOL_HUD_OFFSET_Y,
                TOOL_HUD_SCALE,
                VERIFIER_ERROR_HILIGHT_ALPHA,
                VERIFIER_ERROR_HILIGHT_MAX_POSITIONS
        );
    }

    public static class Colors
    {
        public static final ConfigColor AREA_SELECTION_BOX_SIDE_COLOR       = new ConfigColor("FarbeVonAuswahlBoxenBeiNichtAuswahl",          "0x30FFFFFF", "Die Farbe der Auswahl-Boxen, wenn sie nicht ausgewählt sind");
        public static final ConfigColor HIGHTLIGHT_BLOCK_IN_INV_COLOR       = new ConfigColor("HervorhebungDesBlockes",    "#30FF30FF", "Die Farbe des Blocks, auf den du gerade schaust");
        public static final ConfigColor MATERIAL_LIST_HUD_ITEM_COUNTS       = new ConfigColor("FarbeDerItemanzahlInInfoHUD",     "0xFFFFAA00", "Die Farbe der Itemanzahl in der Info-HUD der Materialien-Liste");
        public static final ConfigColor REBUILD_BREAK_OVERLAY_COLOR         = new ConfigColor("schematicRebuildBreakPlaceOverlayColor", "0x4C33CC33", "Die Farbe des Schematic-Rebuild-Modes beim Platzieren und Zerstören von Blöcken mit aktiviertem Auswahl-Overlay");
        public static final ConfigColor REBUILD_BREAK_EXCEPT_OVERLAY_COLOR  = new ConfigColor("schematicRebuildBreakExceptPlaceOverlayColor", "0x4CF03030", "Die Farbe des Schematic-Rebuild-Modes, zerstört alle vom Auswahl-Overlay anvisierten Blöcke!");
        public static final ConfigColor REBUILD_REPLACE_OVERLAY_COLOR       = new ConfigColor("schematicRebuildReplaceOverlayColor",    "0x4CF0A010", "Die Farbe des Schematic-Rebuild-Modes ersetzt das Auswahl-Overlay");
        public static final ConfigColor SCHEMATIC_OVERLAY_COLOR_EXTRA       = new ConfigColor("FarbeBlockOverlaySpeziell",         "0x4CFF4CE6", "Die Farbe des Block-Overlays für spezielle Blöcke");
        public static final ConfigColor SCHEMATIC_OVERLAY_COLOR_MISSING     = new ConfigColor("FarbeBlockOverlayFehlend",       "0x2C33B3E6", "Die Farbe des Block-Overlays für fehlende Blöcke");
        public static final ConfigColor SCHEMATIC_OVERLAY_COLOR_WRONG_BLOCK = new ConfigColor("FarbeBlockOverlayFalsch",    "0x4CFF3333", "Die Farbe des Block-Overlays für falsche Blöcke");
        public static final ConfigColor SCHEMATIC_OVERLAY_COLOR_WRONG_STATE = new ConfigColor("FarbeBlockOverlayFalscheBlockStati",    "0x4CFF9010", "Die Farbe des Block-Overlays für falsche Block-Stati");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                AREA_SELECTION_BOX_SIDE_COLOR,
                HIGHTLIGHT_BLOCK_IN_INV_COLOR,
                MATERIAL_LIST_HUD_ITEM_COUNTS,
                REBUILD_BREAK_OVERLAY_COLOR,
                REBUILD_BREAK_EXCEPT_OVERLAY_COLOR,
                REBUILD_REPLACE_OVERLAY_COLOR,
                SCHEMATIC_OVERLAY_COLOR_EXTRA,
                SCHEMATIC_OVERLAY_COLOR_MISSING,
                SCHEMATIC_OVERLAY_COLOR_WRONG_BLOCK,
                SCHEMATIC_OVERLAY_COLOR_WRONG_STATE
        );
    }

    public static void loadFromFile()
    {
        File configFile = new File(FileUtils.getConfigDirectory(), CONFIG_FILE_NAME);

        if (configFile.exists() && configFile.isFile() && configFile.canRead())
        {
            JsonElement element = JsonUtils.parseJsonFile(configFile);

            if (element != null && element.isJsonObject())
            {
                JsonObject root = element.getAsJsonObject();

                ConfigUtils.readConfigBase(root, "Farben", Colors.OPTIONS);
                ConfigUtils.readConfigBase(root, "Generelles", Generic.OPTIONS);
                ConfigUtils.readConfigBase(root, "Hotkeys", Hotkeys.HOTKEY_LIST);
                ConfigUtils.readConfigBase(root, "Informations-Overlays", InfoOverlays.OPTIONS);
                ConfigUtils.readConfigBase(root, "Visualisierungen", Visuals.OPTIONS);
            }
        }

        DataManager.setToolItem(Generic.TOOL_ITEM.getStringValue());
        InventoryUtils.setPickBlockableSlots(Generic.PICK_BLOCKABLE_SLOTS.getStringValue());
    }

    public static void saveToFile()
    {
        File dir = FileUtils.getConfigDirectory();

        if ((dir.exists() && dir.isDirectory()) || dir.mkdirs())
        {
            JsonObject root = new JsonObject();

            ConfigUtils.writeConfigBase(root, "Farben", Colors.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Generelles", Generic.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Hotkeys", Hotkeys.HOTKEY_LIST);
            ConfigUtils.writeConfigBase(root, "Informations-Overlays", InfoOverlays.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Visualisierungen", Visuals.OPTIONS);

            JsonUtils.writeJsonToFile(root, new File(dir, CONFIG_FILE_NAME));
        }
    }

    @Override
    public void load()
    {
        loadFromFile();
    }

    @Override
    public void save()
    {
        saveToFile();
    }
}
