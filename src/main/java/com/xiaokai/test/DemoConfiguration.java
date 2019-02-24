package com.xiaokai.test;

import javax.swing.*;

/**
 * @author hansong.xhs
 * @version $Id: DemoConfiguration.java, v 0.1 2019年02月24日 4:55 PM hansong.xhs Exp $
 */
public class DemoConfiguration {
    private JButton saveBtn;
    private JTextField textField1;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;

    private DemoSettings demoSettings;

    public DemoConfiguration(DemoSettings demoSettings) {
        this.demoSettings = demoSettings;
        saveBtn.addActionListener(e -> this.demoSettings.setValue(textField1.getText()));
    }

    public String getValue() {
        return textField1.getText();
    }
}