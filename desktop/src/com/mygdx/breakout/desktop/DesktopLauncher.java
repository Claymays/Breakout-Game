package com.mygdx.breakout.desktop;

import breakout.Breakout;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 900;
		config.width = 700;
		new LwjglApplication(new Breakout(), config);
	}
}
