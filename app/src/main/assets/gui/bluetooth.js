// Bluetooth GUI
gui.panel("Bluetooth")
  .add(gui.toggle("Bluetooth", BT.enabled))
  .add(gui.list("Paired devices", BT.paired));