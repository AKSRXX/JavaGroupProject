package com.example.librarymanager;

public class Item {
  private int itemId;
  private String itemName;

  //constructor
  public Item(int itemId, String itemName){
    this.itemId = itemId;
    this.itemName = itemName;
  }

  //getters and setters
  public int getItemID(){ return this.itemId; }
  public void setItemID(int itemId){ this.itemId = itemId; }
  public String getItemName(){ return this.itemName; }
  public void setItemName(String itemName){ this.itemName = itemName; }

}
