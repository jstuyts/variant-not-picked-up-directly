package com.javathinker;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;

import java.util.Locale;

public class AjaxHomePage extends BasePage {
    public AjaxHomePage() {
        WebMarkupContainer container = new WebMarkupContainer("container");
        container.setOutputMarkupId(true);
        Label type = new Label("type", "Ajax");
        Form<Void> form = new Form<>("form");
        AjaxButton noVariantButton = new AjaxButton("noVariantButton") {
            @Override
            public void onSubmit(AjaxRequestTarget target) {
                getSession().setStyle(null);
                variation = null;
                getSession().setLocale(Locale.getDefault());
                target.add(container);
            }
        };
        AjaxButton theStyleButton = new AjaxButton("theStyleButton") {
            @Override
            public void onSubmit(AjaxRequestTarget target) {
                getSession().setStyle("style1");
                variation = null;
                getSession().setLocale(Locale.getDefault());
                target.add(container);
            }
        };
        AjaxButton theVariationButton = new AjaxButton("theVariationButton") {
            @Override
            public void onSubmit(AjaxRequestTarget target) {
                getSession().setStyle(null);
                variation = "variation1";
                getSession().setLocale(Locale.getDefault());
                target.add(container);
            }
        };
        AjaxButton theLocaleButton = new AjaxButton("theLocaleButton") {
            @Override
            public void onSubmit(AjaxRequestTarget target) {
                getSession().setStyle(null);
                variation = null;
                getSession().setLocale(Locale.FRENCH);
                target.add(container);
            }
        };
        VariantsPanel panel = new VariantsPanel("panel");

        add(container);
        container.add(type, form, panel);
        form.add(noVariantButton, theStyleButton, theVariationButton, theLocaleButton);
    }
}
