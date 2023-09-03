package me.gamerduck.safeapi.common.permission;

public enum TriState {
    TRUE(true),
    FALSE(false),
    UNDEFINED(false);

    public static TriState fromBoolean(boolean val) {
        return val ? TRUE : FALSE;
    }

    public static TriState fromBoolean(Boolean val) {
        if (val == null) {
            return UNDEFINED;
        }
        return val ? TRUE : FALSE;
    }

    private final boolean booleanValue;

    TriState(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public boolean asBoolean() {
        return this.booleanValue;
    }
}
