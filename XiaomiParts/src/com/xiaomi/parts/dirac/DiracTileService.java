package com.xiaomi.parts.dirac;

import android.content.Context;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

import com.xiaomi.parts.R;

public class DiracTileService extends TileService {

    private DiracUtils mDiracUtils;

    @Override
    public void onStartListening() {

        Tile tile = getQsTile();
        if (mDiracUtils.isDiracEnabled()) {
            tile.setState(Tile.STATE_ACTIVE);
        } else {
            tile.setState(Tile.STATE_INACTIVE);
        }

        tile.updateTile();
        super.onStartListening();
    }

    @Override
    public void onClick() {
        Tile tile = getQsTile();
        if (mDiracUtils.isDiracEnabled()) {
            mDiracUtils.setEnabled(false);
            tile.setState(Tile.STATE_INACTIVE);
        } else {
            mDiracUtils.setEnabled(true);
            tile.setState(Tile.STATE_ACTIVE);
        }
        tile.updateTile();
        super.onClick();
    }
}
