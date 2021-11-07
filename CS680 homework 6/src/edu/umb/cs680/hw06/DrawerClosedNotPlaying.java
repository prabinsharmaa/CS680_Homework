package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State{
	
	private static DrawerClosedNotPlaying drawerClosedNotPlaying = null;
	private DVDPlayer player;
	
	private DrawerClosedNotPlaying() {
		player = player.getInstance();
	}
	
	public static DrawerClosedNotPlaying getInstance() {
		if(drawerClosedNotPlaying == null) {
			drawerClosedNotPlaying = new DrawerClosedNotPlaying();
		}
		return drawerClosedNotPlaying;
	}

	@Override
	public void openCloseButtonPushed() {
	
		player.open();
		player.changeState(DrawerOpen.getInstance());
	}

	@Override
	public void playButtonPushed() {
		
		player.play();
		player.changeState(DrawerClosedPlaying.getInstance());

		
	}

	@Override
	public void stopButtonPushed() {
		
		System.out.println("Already nothing is playing");

	}
}
