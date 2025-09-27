package conway;

public interface GameArguments {
  void loadArguments(String args[]) throws Exception;

  GameData getArguments();
}
