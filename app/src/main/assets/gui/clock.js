// Clock preset: aes
const el = gui.clock({style: "aes", format: "HH:mm", showDate: true});
setInterval(() => el.update(new Date()), 1000);