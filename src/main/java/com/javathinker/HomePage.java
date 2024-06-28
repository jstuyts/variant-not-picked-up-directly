package com.javathinker;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;

import java.util.Locale;

public class HomePage extends BasePage {
    public HomePage() {
        WebMarkupContainer container = new WebMarkupContainer("container");
        container.setOutputMarkupId(true);
        Label type = new Label("type", "No Ajax");
        Form<Void> form = new Form<>("form");
        Button noVariantButton = new Button("noVariantButton") {
            @Override
            public void onSubmit() {
                getSession().setStyle(null);
                variation = null;
                getSession().setLocale(Locale.getDefault());
            }
        };
        Button theStyleButton = new Button("theStyleButton") {
            @Override
            public void onSubmit() {
                getSession().setStyle("style1");
                variation = null;
                getSession().setLocale(Locale.getDefault());
            }
        };
        Button theVariationButton = new Button("theVariationButton") {
            @Override
            public void onSubmit() {
                getSession().setStyle(null);
                variation = "variation1";
                getSession().setLocale(Locale.getDefault());
            }
        };
        Button theLocaleButton = new Button("theLocaleButton") {
            @Override
            public void onSubmit() {
                getSession().setStyle(null);
                variation = null;
                getSession().setLocale(Locale.FRENCH);
            }
        };
        VariantsPanel panel = new VariantsPanel("panel");

        add(container);
        container.add(type, form, panel);
        form.add(noVariantButton, theStyleButton, theVariationButton, theLocaleButton);
    }
}
