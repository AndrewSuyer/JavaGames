package AWT_applet;

import java.awt.Canvas;
import java.awt.Color;

public class User {
	
	// All user responeses will be stored in a User object
	
	private String name;
	private String username;
	private String password;
	
	private char favoriteLetter;
	private String favoriteWord;
	private Color favoriteColor;
	private Canvas favoritePicture;
	
		// creats user with a name, username, and a password
	public User(String nm, String user, String pass) {
		name = nm;
		username = user;
		password = pass;
	}

	public char getFavoriteLetter() {
		return favoriteLetter;
	}

	public void setFavoriteLetter(char favoriteLetter) {
		this.favoriteLetter = favoriteLetter;
	}

	public String getFavoriteWord() {
		return favoriteWord;
	}

	public void setFavoriteWord(String favoriteWord) {
		this.favoriteWord = favoriteWord;
	}

	public Color getFavoriteColor() {
		return favoriteColor;
	}

	public void setFavoriteColor(Color favoriteColor) {
		this.favoriteColor = favoriteColor;
	}
	
	public Canvas getFavoritePicture() {
		return this.favoritePicture;
	}
	
	public void setFavoritePicture(Canvas favoritePicture) {
		this.favoritePicture = favoritePicture;
	}
	
	public String toString() {
		return "Favorite letter: " + getFavoriteLetter() + ", Favorite word: " + getFavoriteWord() + ", Favorite Color: " + getFavoriteColor() + ", Favorite Picture: " + getFavoritePicture().getName();
	}

}
