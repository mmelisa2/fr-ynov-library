package fr.ynov.library.domain;

public enum ReadingStatus {
    WANT_TO_READ("Want To Read"),
    CURRENTLY_READING("Currently Reading"),
    READ("Read"),
    DID_NOT_FINISH("Did Not Finish");

    private final String displayName;
    ReadingStatus(String displayName) {
        this.displayName = displayName;
    }
    @Override
    public String toString() {
        return displayName;
    }
}
