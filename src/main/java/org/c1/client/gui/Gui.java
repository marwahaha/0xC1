package org.c1.client.gui;

import java.util.*;

import com.google.common.collect.*;

import org.c1.*;

public abstract class Gui {

    private List<GuiComponent> components;
    protected C1Game game;

    public Gui(C1Game gameInstance) {
        this.game = gameInstance;
        components = Lists.newArrayList();
    }

    public abstract void init();

    public void render(double delta) {
        components.forEach(comp -> comp.render(delta));
    }

    public void update(double delta) {
        components.forEach(comp -> comp.update(delta));
    }

    public void addComponent(GuiComponent comp) {
        components.add(comp);
    }

    public void onKeyPressed(int keycode, char eventchar) {
        components.forEach(comp -> comp.onKeyPressed(keycode, eventchar));
    }

    public void onKeyReleased(int keycode, char eventchar) {
        components.forEach(comp -> comp.onKeyReleased(keycode, eventchar));
    }

    public void clearComponents() {
        components.clear();
    }

    public void onMousePressed(int x, int y, int button) {
        components.forEach(comp -> comp.onMousePressed(x, y, button));
    }

    public void onMouseReleased(int x, int y, int button) {
        components.forEach(comp -> comp.onMouseReleased(x, y, button));
    }

    public void onScroll(int x, int y, int direction) {
        components.forEach(comp -> comp.onScroll(x, y, direction));
    }

    public void onMouseMoved(int x, int y, float dx, float dy) {
        components.forEach(comp -> comp.onMouseMoved(x, y, dx, dy));
    }

    public boolean locksMouse() {
        return true;
    }
}
