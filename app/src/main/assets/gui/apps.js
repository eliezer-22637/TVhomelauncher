// Apps list GUI (aes)
appsList.layout("grid", {columns: 6, style: "aes"});
appsList.onLaunch(app => Launcher.open(app.packageName));