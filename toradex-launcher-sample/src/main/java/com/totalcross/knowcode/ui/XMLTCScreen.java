package com.totalcross.knowcode.ui;


import com.totalcross.knowcode.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerLayout;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import totalcross.sys.InvalidNumberException;
import totalcross.sys.Settings;
import totalcross.ui.*;
import totalcross.ui.font.Font;
import totalcross.util.BigDecimal;

public class XMLTCScreen extends XMLPresenter {
    public XMLTCScreen() {
        super(XmlContainerFactory.create("xml/imxmulti.xml"));
    }
    @Override
    public void onPresent() {
        Label title =(Label) ((XmlContainerLayout) content).getControlByID("@+id/textView");
        try {
            title.setFont(Font.getFont(false, new BigDecimal(110).multiply(BigDecimal.valueOf(Settings.screenHeight)).divide(BigDecimal.valueOf(1080), BigDecimal.ROUND_DOWN).intValue()));
        } catch (InvalidNumberException e) {
            e.printStackTrace();
        }
        Control button = ((XmlContainerLayout) content).getControlByID("@+id/GLES2");
        button.setVisible(false);
        button = ((XmlContainerLayout) content).getControlByID("@+id/GS");
        button.setVisible(false);
        button = ((XmlContainerLayout) content).getControlByID("@+id/VG");
        button.setVisible(false);
        button = ((XmlContainerLayout) content).getControlByID("@+id/arrow");
        button.addPressListener(this.navigator::back);
        Control gs = ((XmlContainerLayout) content).getControlByID("@+id/opengl");
        Control qtq = ((XmlContainerLayout) content).getControlByID("@+id/tcq");
        navigator.onClick(gs,XMLTCSecondScreen.class);
        navigator.onClick(qtq,XMLTCSecondScreen.class);

    }
}
