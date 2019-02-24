package com.xiaokai.test;

import javax.swing.*;

import org.apache.commons.codec.binary.StringUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;

/**
 * @author hansong.xhs
 * @version $Id: DemoConfigurable.java, v 0.1 2019年02月24日 5:03 PM hansong.xhs Exp $
 */
public class DemoConfigurable implements SearchableConfigurable {

    private DemoSettings      settings;

    private DemoConfiguration demoConfiguration;

    public DemoConfigurable() {
        settings = ServiceManager.getService(DemoSettings.class);
    }

    @NotNull
    @Override
    public String getId() {
        return "plugin.demo";
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Demo";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (demoConfiguration == null) {
            demoConfiguration = new DemoConfiguration(settings);
        }
        return demoConfiguration.getMainPanel();
    }

    @Override
    public boolean isModified() {
        return StringUtils.equals(demoConfiguration.getValue(), settings.getValue());
    }

    @Override
    public void apply() throws ConfigurationException {
        settings.setValue(demoConfiguration.getValue());
    }
}