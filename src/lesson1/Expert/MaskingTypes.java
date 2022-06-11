package lesson1.Expert;

public enum MaskingTypes {
    PHONE("\\d{4}(\\d{3})\\d{4}", "*", false),
    EMAIL_DOMAIN("@(\\w+)","*", false),
    EMAIL_USERNAME_LAST_LETTER("(\\w+)@", "*", false),
    FIRSTNAME("\"^\\\\p{L}(\\\\p{L}+)\\\\p{L}\"", "*", false),
    FATHER_NAME("\"\\\\p{L}+ \\\\p{L}+ \\\\p{L}(\\\\p{L}+)\"", ".", true),
    ;
    private String pattern;
    private String replacement;
    private boolean onlyOneLetterReplacement;

    MaskingTypes(String pattern, String replacement, boolean onlyOneLetterReplacement) {
        this.pattern = pattern;
        this.replacement = replacement;
        this.onlyOneLetterReplacement = onlyOneLetterReplacement;
    }

    public String getPattern() {
        return pattern;
    }

    public String getReplacement() {
        return replacement;
    }

    public boolean isOnlyOneLetterReplacement() {
        return onlyOneLetterReplacement;
    }
}
