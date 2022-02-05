package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class GroupData {
    private final String newGName;
    private final String header;
    private final String footer;

    public GroupData(String newGName, String header, String footer) {
        this.newGName = newGName;
        this.header = header;
        this.footer = footer;
    }

    public String newGName() {
        return newGName;
    }

    public String header() {
        return header;
    }

    public String footer() {
        return footer;
    }

}