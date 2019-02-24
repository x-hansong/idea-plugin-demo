package com.xiaokai.test;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;

/**
 * @author hansong.xhs
 * @version $Id: DemoSettings.java, v 0.1 2019年02月24日 5:04 PM hansong.xhs Exp $
 */
@State(name = "DemoSettings", storages = { @Storage(file = "$APP_CONFIG$/Demo-settings.xml") })
public class DemoSettings implements PersistentStateComponent<DemoSettings> {

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    public DemoSettings() {
    }

    @Nullable
    @Override
    public DemoSettings getState() {
        if (value == null) {
            return new DemoSettings();
        }
        return this;
    }

    @Override
    public void loadState(@NotNull DemoSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}