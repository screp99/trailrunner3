package model.field


trait IField(): 
  def isBroken: Boolean
  def isSet: Boolean
  def PlayerWalksOnField(): IField
  def PlayerLeavesField(): IField
  def setValue(newValue : Int): IField
  def earthquake: IField