package com.sru;
import java.util.*;
public class Album {
private String name;
private String artist;
private ArrayList<Song> songs;

public Album(String name, String artist) {
	this.name = name;
	this.artist = artist;
	this.songs = new ArrayList<Song>();
}
public Album()
{
	
}
public Song findSong(String title)
{
	for(Song checkedSong:songs)
	{
		if(checkedSong.getTitle().equals(title))
		{
			return checkedSong;
		}
		
	}
	return null;
}
public boolean addsong(String title,Double duration)
{
	if(findSong(title)==null)
	{
		songs.add(new Song(title,duration));
		//System.out.println(title+"succefully added to the list");
		return true;
	}
	else
	{
		//System.out.println(title+"already exists in playlist");
		return false;
		
	}
}
public boolean addToPlaylist(int track_no,LinkedList<Song> playlist)
{
	int index=track_no-1;
	if(index>0 && index<=this.songs.size())
	{
	   playlist.add(this.songs.get(index));
	   return true;
	}
		//System.out.println("This song with tarck number "+track_no+" does not exist!");
	return false;
}
public boolean addToPlaylist(String title,LinkedList<Song> playlist)
{
	for(Song checkedSong: this.songs)
	{
		if(checkedSong.getTitle().equals(title))
		{
			playlist.add(checkedSong);
			return true;
		}
	}
	//System.out.println("This song with title "+title+" does not exist!");
	return false;
}
}
