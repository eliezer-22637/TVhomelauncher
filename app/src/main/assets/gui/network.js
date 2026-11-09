// Network GUI
gui.panel("Network")
  .add(gui.toggle("Wi-Fi", Net.wifi))
  .add(gui.toggle("Ethernet", Net.ethernet));