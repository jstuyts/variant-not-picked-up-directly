package com.javathinker;

import org.apache.wicket.markup.html.WebPage;

public abstract class BasePage extends WebPage {
    protected String variation = null;

    @Override
    public String getVariation() {
        return variation;
    }
}
