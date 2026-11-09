// Clock preset: bg
const el = gui.clock({style: "bg", format: "HH:mm", showDate: true});
setInterval(() => el.update(new Date()), 1000);