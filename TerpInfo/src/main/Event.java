package main;

public class Event {

	private String name, host, description, room, time;
	private boolean freeFood;
	
	public Event( String name, String host, String description, String room, String time, boolean freeFood ) {
		this.name = name;
		this.host = host;
		this.description = description;
		this.room = room;
		this.time = time;
		this.freeFood = freeFood;
	}

	public String getHost() {
		return host;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getRoom() {
		return room;
	}

	public String getTime() {
		return time;
	}

	public boolean isFreeFood() {
		return freeFood;
	}
	
}
