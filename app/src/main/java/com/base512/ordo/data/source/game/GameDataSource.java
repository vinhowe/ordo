package com.base512.ordo.data.source.game;

import android.content.Context;
import android.support.annotation.NonNull;

import com.base512.ordo.data.Game;
import com.base512.ordo.data.source.BaseDataSource;

/**
 * Created by Thomas on 2/21/2017.
 */

public interface GameDataSource {
    void getCurrentGame(@NonNull Context context, BaseDataSource.GetDataCallback<Game> gameDataCallback);

    void setCurrentGame(@NonNull Game game, @NonNull Context context);

    void getGame(@NonNull String gameId, BaseDataSource.GetDataCallback<Game> gameDataCallback);

    void setGameState(@NonNull String gameId, @NonNull Game.State state, @NonNull Context context, @NonNull BaseDataSource.UpdateDataCallback updateGameCallback);

    void createGame(@NonNull Game.Config config, @NonNull Context context, BaseDataSource.GetDataCallback<Game> gameDataCallback);
}
