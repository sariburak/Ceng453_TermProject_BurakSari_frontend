package com.ceng453group15.frontend.GameLogic.PlayerStates;

public interface PlayerState {

    public abstract void move(int amount);

    public abstract boolean buyProperty();
}
