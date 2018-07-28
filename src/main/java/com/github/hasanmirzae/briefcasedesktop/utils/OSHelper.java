package com.github.hasanmirzae.briefcasedesktop.utils;

import com.github.hasanmirzae.briefcasedesktop.GUI;
import dorkbox.systemTray.MenuItem;
import dorkbox.util.CacheUtil;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class OSHelper {


    private static final String LOGO_PATH = "src/main/resources/static/logo.jpeg";

    public static void openBrowser(String url){
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            resolveBrowser(url);
        }
    }


    private static void resolveBrowser(String url){
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();

        try{

            if (os.indexOf( "win" ) >= 0) {

                // this doesn't support showing urls in the form of "page.html#nameLink"
                rt.exec( "rundll32 url.dll,FileProtocolHandler " + url);

            } else if (os.indexOf( "mac" ) >= 0) {

                rt.exec( "open " + url);

            } else if (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0) {

                // Do a best guess on unix until we get a platform independent way
                // Build a list of browsers to try, in this order.
                String[] browsers = {"chrome","chromium","google-chrome","firefox","mozilla","opera","epiphany", "konqueror", "netscape","links","lynx"};

                // Build a command string which looks like "browser1 "url" || browser2 "url" ||..."
                StringBuffer cmd = new StringBuffer();
                for (int i=0; i<browsers.length; i++)
                    cmd.append( (i==0  ? "" : " || " ) + browsers[i] +" \"" + url + "\" ");

                rt.exec(new String[] { "sh", "-c", cmd.toString() });

            } else {
                return;
            }
        }catch (Exception e){
            return;
        }
        return;
    }

    public static void initSystemTrayIcon() throws MalformedURLException {

        dorkbox.systemTray.SystemTray.DEBUG = true; // for test apps, we always want to run in debug mode
        CacheUtil.clear(); // for test apps, make sure the cache is always reset. You should never do this in production.


        URL imageUrl = Paths.get(LOGO_PATH).toUri().toURL();
        dorkbox.systemTray.SystemTray systemTray = dorkbox.systemTray.SystemTray.get();
        if (systemTray == null) {
            throw new RuntimeException("Unable to load SystemTray!");
        }

        systemTray.setTooltip("Briefcase");
        systemTray.setImage(imageUrl);
        dorkbox.systemTray.Menu mainMenu = systemTray.getMenu();
        dorkbox.systemTray.MenuItem restartEntry = new dorkbox.systemTray.MenuItem("Restart", new ActionListener() {
            @Override
            public
            void actionPerformed(final ActionEvent e) {
                System.out.println("Restart ...");
            }
        });
        restartEntry.setImage(imageUrl);
        // case does not matter
        restartEntry.setShortcut('R');
        restartEntry.setTooltip("Restart application");
        mainMenu.add(restartEntry);


        systemTray.getMenu().add(new MenuItem("Quit", new ActionListener() {
            @Override
            public
            void actionPerformed(final ActionEvent e) {
                systemTray.shutdown();
//                System.exit(0); // not necessary if all non-daemon threads have stopped.
            }
        })).setShortcut('q'); // case does not matter


    }


    public static void createAndShowGUI(ConfigurableApplicationContext ctx) {
        String port = ctx.getEnvironment().getProperty("local.server.port");
        GUI frame = new GUI("Briefcase running at http://localhost:"+port, LOGO_PATH);
        frame.getShutdownBtn().addActionListener(actionEvent -> System.exit(0));

        frame.getLaunchBtn().addActionListener(actionEvent -> resolveBrowser("http://localhost:"+ctx.getEnvironment().getProperty("local.server.port")));

        frame.showWindow();
    }
}
