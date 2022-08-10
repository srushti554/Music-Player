package com.sru;

import java.util.*;

public class Main {
	
private static ArrayList<Album> albums=new ArrayList<>();

private static void play(LinkedList<Song> playlist)
{
	Scanner sc=new Scanner(System.in);
	boolean quit=false;
	boolean forward=true;
	ListIterator<Song> listitr= playlist.listIterator();
	
	if(playlist.size()==0)
	{
		System.out.println("No Song");
	}
	else
	{
		System.out.println("Now playing: \n"+listitr.next().toString());
		Menu();
	}
	while(!quit)
	{
		int ch=sc.nextInt();
		sc.nextLine();
		switch(ch)
		{
		case 0: System.out.println("Playlist complete");
		        quit=true;
		        break;
		case 1: 
			if(!forward)
			{
				if(listitr.hasNext())
				{
					listitr.next();
				}
				forward=true;
			}
			if(listitr.hasNext())
			{
				System.out.println("Now Playing:"+listitr.next().toString());
			}
			else
			{
				System.out.println("No song available, reached to the end of the list");
				forward=false;
			}
			break;
		case 2:
			if(forward)
			{
				if(listitr.hasPrevious())
						{
					listitr.previous();
						}
				forward=false;
			}
			if(listitr.hasPrevious())
			{
				System.out.println("Now Playing"+listitr.previous().toString());
			}
			else
			{
				System.out.println("We are at the first song!");
				forward=false;
			}
			break;
		case 3:
			if(forward)
			{
				if(listitr.hasPrevious())
				{
					System.out.println("Now Playing "+listitr.previous().toString());
					forward=false;
				}
				else
				{
					System.out.println("We are at the start of the playlist!");
				}
			}
			else
			{
				if(listitr.hasNext())
				{
					System.out.println("Now Playing:"+listitr.next().toString());
					forward=true;
				}
				else
				{
					System.out.println("No song available, reached to the end of the list");
					forward=false;
				}
			}
			break;
		case 4:
			printlist(playlist);
			break;
		case 5:
			Menu();
			break;
		case 6:
			if(playlist.size()>0)
			{
				listitr.remove();
				if(listitr.hasNext())
				{
					System.out.println("Now Playing:"+listitr.next().toString());
				
				}
				else
				{
					if(listitr.hasPrevious())
					{
						System.out.println("Now Playing "+listitr.previous().toString());
						forward=false;
					}
				
				}
			}
			break;
			
		}
	}
}

private static void Menu()
{
	System.out.println("Available options \n press ");
	System.out.println("0-to quit\n"+"1-to play next song\n"+
	"2-to play previous song\n"+"3-to replay the current song\n"
		+"4-List of all songs\n"+"5-Print all available options\n"+"6-Delete Current song \n");
}

private static void printlist(LinkedList<Song> playlist) 
{
	Iterator<Song> itr=playlist.iterator();
	System.out.println("*---------------------*");
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}
	System.out.println("*----------------------*");
} 

public static void main(String[] args)
	{
		// TODO Auto-generated method stub

Album album=new Album("Album1","ACDC");

album.addsong("TNT", 4.6); 
album.addsong("Night we met", 7.8);
album.addsong("Hunger", 4.6);
album.addsong("Passori", 3.7);
albums.add(album);

album= new Album("Album2","Arijit Singh");

album.addsong("Sun raha hai", 4.6);
album.addsong("Hawayein", 7.8);
album.addsong("Bulleya", 4.6);
album.addsong("Ae Dil hai Mushkil", 3.7);
albums.add(album);

LinkedList<Song> playlist1=new LinkedList<>();
albums.get(0).addToPlaylist("TNT",playlist1);
albums.get(1).addToPlaylist("Hawayein",playlist1);
albums.get(1).addToPlaylist("Bulleya",playlist1);
albums.get(0).addToPlaylist("Passori",playlist1);
play(playlist1);



	}

}
