package main;

public class Event {

	private String name, description, room, time;
	private boolean freeFood;
	
	public Event( String name, String description, String room, String time, boolean freeFood ) {
		this.name = name;
		this.description = description;
		this.room = room;
		this.time = time;
		this.freeFood = freeFood;
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
