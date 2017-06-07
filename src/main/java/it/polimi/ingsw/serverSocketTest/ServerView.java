package it.polimi.ingsw.serverSocketTest;

import it.polimi.ingsw.GC_40.Observable;
import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.changes.Change;

public abstract class ServerView extends Observable<Action> implements Observer<Change>{


}
