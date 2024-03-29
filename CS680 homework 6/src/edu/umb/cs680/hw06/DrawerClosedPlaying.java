package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State{
	
	private static DrawerClosedPlaying drawerClosedPlaying = null;
	private DVDPlayer player;
	
	public static DrawerClosedPlaying getInstance() {
		if(drawerClosedPlaying == null) {
			drawerClosedPlaying = new DrawerClosedPlaying();
		}
		return drawerClosedPlaying;
	}
	
	private DrawerClosedPlaying() {
		player = player.getInstance();
	}

	@Override
	public void openCloseButtonPushed() {
		player.stop();
		player.open();
		player.changeState(DrawerOpen.getInstance());
	}

	@Override
	public void playButtonPushed() {
		System.out.println("Playing content");
	}

	@Override
	public void stopButtonPushed() {
		player.stop();
		player.changeState(DrawerClosedNotPlaying.getInstance());
	}
	
	
}
